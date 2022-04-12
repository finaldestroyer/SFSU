package Gameplay;

import Gameplay.PowerUp.*;
import Gameplay.PowerUp.ExtraLife;
import Gameplay.PowerUp.SpeedBoost;
import Gameplay.PowerUp.Spray;
import Gameplay.Walls.BreakableWall;
import Gameplay.Walls.UnbreakableWall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class GameWorld extends JPanel{
    public static final float SCREEN_WIDTH = 1440;
    public static final float SCREEN_HEIGHT = 1080;
    public static final float WORLD_WIDTH = 1536;
    public static final float WORLD_HEIGHT = 1152;
    private static boolean gameOver = false;
    private static ExtraLife life;

    private BufferedImage world;
    private BufferedImage player1wins;
    private BufferedImage player2wins;
    private Background backgroundImg;
    private Graphics2D buffer;
    private JFrame jf;
    private Tank t1;
    private Tank t2;
    private GameMap map;

    public static void main(String[] args) {
        Thread x;
        GameWorld theOne = new GameWorld();
        theOne.init();
        try {

            while (!gameOver) {
                theOne.repaint();
                Thread.sleep(1000 / 144);
            }
        } catch (InterruptedException ignored) {

        }
    }
    private void init() {
        this.jf = new JFrame("Tank Wars");

        this.world = new BufferedImage((int)GameWorld.WORLD_WIDTH, (int)GameWorld.WORLD_HEIGHT, BufferedImage.TYPE_INT_RGB);
        BufferedImage t1img=null;

        try {
            BufferedImage tmp;

            t1img = ImageIO.read(getClass().getResource("/resources/tank1.png"));

            backgroundImg = new Background(ImageIO.read(getClass().getResource("/resources/Background.bmp")));

            UnbreakableWall.setImg(ImageIO.read(getClass().getResource("/resources/Wall1.gif")));

            BreakableWall.setImg(ImageIO.read(getClass().getResource("/resources/Wall2.gif")));

            Bullet.setImg(ImageIO.read(getClass().getResource("/resources/Weapon.gif")));

            ExtraLife.setImg(ImageIO.read(getClass().getResource("/resources/extraLife.png")));

            SpeedBoost.setImg(ImageIO.read(getClass().getResource("/resources/speed-boost.png")));

            player1wins = ImageIO.read(getClass().getResource("/resources/player-1-wins.png"));

            player2wins = ImageIO.read(getClass().getResource("/resources/player-2-wins.png"));


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        t1 = new Tank(430, 600, 0, 0, 0, t1img);
        t2 = new Tank(1200, 600, 0, 0, 180, t1img);

        map = new GameMap();

        life = new ExtraLife(0, 0);

        TankControl tc1 = new TankControl(t1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER);
        TankControl tc2 = new TankControl(t2, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE);

        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);


        this.jf.addKeyListener(tc1);
        this.jf.addKeyListener(tc2);

        this.jf.setSize((int)SCREEN_WIDTH, (int)(SCREEN_HEIGHT + 30));
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.setVisible(true);

    }

    private void update(){
        t1.update();
        t2.update();

        t1.checkCollision(t2);
        t2.checkCollision(t1);
        map.handleCollision(t1);
        map.handleCollision(t2);

    }

    private float getXCoordinate(Tank t){
        float x = t.getX();
        if(x < SCREEN_WIDTH / 4)
            x = SCREEN_WIDTH / 4;
        if(x > WORLD_WIDTH - SCREEN_WIDTH / 4)
            x = WORLD_WIDTH - SCREEN_WIDTH / 4;
        return x;
    }

    public float getYCoordinate(Tank t){
        float y = t.getY();
        if(y < SCREEN_HEIGHT / 2)
            y = SCREEN_HEIGHT / 2;
        if(y > WORLD_HEIGHT - SCREEN_HEIGHT / 2)
            y = WORLD_HEIGHT - SCREEN_HEIGHT / 2;
        return y;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        update();

        buffer = world.createGraphics();

        super.paintComponent(g2);

        this.setBackground(Color.black);

        this.backgroundImg.drawImage(buffer);

        map.drawImage(buffer);

        this.t1.drawImage(buffer);
        this.t2.drawImage(buffer);

        BufferedImage leftScreen = world.getSubimage((int)(getXCoordinate(t1) - SCREEN_WIDTH / 4), (int)(getYCoordinate(t1) - SCREEN_HEIGHT / 2), (int)(SCREEN_WIDTH / 2), (int)(SCREEN_HEIGHT));
        BufferedImage rightScreen = world.getSubimage((int)(getXCoordinate(t2) - SCREEN_WIDTH / 4), (int)(getYCoordinate(t2) - SCREEN_HEIGHT / 2), (int)(SCREEN_WIDTH / 2), (int)(SCREEN_HEIGHT));

        g2.drawImage(leftScreen, 0, 0, null);
        g2.drawImage(rightScreen, (int) (SCREEN_WIDTH / 2 + 10), 0, null);

        int location;
        int placement;
        for(float i=1; i <= t1.getLives(); i++){
            location = (int) ((life.getImg().getWidth() + 40) * i);
            placement = location / 2;
            g2.drawImage(life.getImg(), placement, 10, null);
        }

        for(float i=1; i <= t2.getLives(); i++){
            location = (int) ((life.getImg().getWidth() + 40) * i);
            placement = (int) (location/2 + SCREEN_WIDTH - SCREEN_WIDTH / 2 + 10);
            g2.drawImage(life.getImg(), placement, 10, null);
        }

        g2.setColor(Color.GREEN);
        g2.fillRect((int) (SCREEN_WIDTH / 4), 30, 2* t1.getCurrentHealth(), 20);
        g2.fillRect((int) (SCREEN_WIDTH - SCREEN_WIDTH / 4), 30, 2* t2.getCurrentHealth(), 20);


        g2.drawImage(world, (int)(SCREEN_WIDTH / 2 - WORLD_WIDTH / 10), (int)(SCREEN_HEIGHT - WORLD_HEIGHT / 5), (int)(WORLD_WIDTH / 5), (int)(WORLD_HEIGHT / 5), null);

        if(t1.getLives() == 0){
            g2.drawImage(player2wins, 0, 0, (int)(SCREEN_WIDTH + 10), (int)(SCREEN_HEIGHT), null);
            gameOver = true;
        }

        if(t2.getLives() == 0) {
            g2.drawImage(player1wins, 0, 0, (int)(SCREEN_WIDTH + 10), (int)(SCREEN_HEIGHT), null);
            gameOver = true;
        }

    }
}
