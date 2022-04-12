package Gameplay;



import Gameplay.GameConstants;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tank implements CollidableObject {


    private float x;
    private float y;
    private float vx;
    private float vy;
    private float angle;
    private Rectangle CBorder;

    private float R = 5;
    private final float ROTATIONSPEED = 4;
    private int currentHealth = 100;
    private int lives = 3;


    private BufferedImage img;
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;
    private ArrayList<Bullet> bullets = new ArrayList<>();

    Tank(float x, float y, float vx, float vy, float angle, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = img;
        this.angle = angle;

    }

    public float getX() { return x; }

    public float getY() { return y; }

    public void setSpeed(int value) { this.R+=value; }

    public void collided(int value){
        if(currentHealth - value <= 0){
            currentHealth = 0;
            removeLife();
        }
        else
            currentHealth -= value;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void powerHealth(int value){
        if(currentHealth + value >= 100)
            currentHealth = 100;
        else
            currentHealth += value;
    }

    public int getCurrentHealth() { return currentHealth; }

    public void addLife() { this.lives += 1; }

    public int getLives() { return this.lives; }

    public void removeLife() {
        if(lives == 0){
            currentHealth = 0;
        } else {
            lives -= 1;
            powerHealth(100);
        }
    }

    void setX(float x){ this.x = x; }

    void setY(float y) { this. y = y;}

    public void toggleUpPressed() {
        this.UpPressed = true;
    }

    public void toggleDownPressed() {
        this.DownPressed = true;
    }

    public void toggleRightPressed() {
        this.RightPressed = true;
    }

    public void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    public void unToggleUpPressed() {
        this.UpPressed = false;
    }

    public void unToggleDownPressed() {
        this.DownPressed = false;
    }

    public void unToggleRightPressed() {
        this.RightPressed = false;
    }

    public void unToggleLeftPressed() {
        this.LeftPressed = false;
    }

    void update() {
        if (this.UpPressed) {
            this.moveForwards();
        }
        if (this.DownPressed) {
            this.moveBackwards();
        }

        if (this.LeftPressed) {
            this.rotateLeft();
        }
        if (this.RightPressed) {
            this.rotateRight();
        }
        for(int i = 0; i < bullets.size(); i++){
            if(bullets.get(i).hasCollided()) {
                bullets.remove(i);
            }else{
                bullets.get(i).update();
            }
        }
    }

    private void rotateLeft() {
        this.angle -= this.ROTATIONSPEED;
    }

    private void rotateRight() {
        this.angle += this.ROTATIONSPEED;
    }

    private void moveBackwards() {
        vx = (float) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(R * Math.sin(Math.toRadians(angle)));
        x -= vx;
        y -= vy;
        checkBorder();
    }

    private void moveForwards() {
        vx = (float) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(R * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
        checkBorder();
    }

    void shootBullet() {
        Bullet b = new Bullet(this.x, this.y, this.angle);
        bullets.add(b);
    }

    //@Override
    public void checkCollision(CollidableObject c) {
        if(this.getRectangle().intersects(c.getRectangle())){
            if(c instanceof Bullet){
                collided(10);
            } else {
                Rectangle intersection = this.getRectangle().intersection(c.getRectangle());
                if(intersection.height > intersection.width  && this.x < intersection.x){ //left
                    x-= intersection.width/2;
                }
                else if(intersection.height > intersection.width  && this.x > c.getRectangle().x){ //right
                    x+= intersection.width/2;
                }
                else if(intersection.height < intersection.width  && this.y < intersection.y){ //up
                    y-= intersection.height/2;
                }
                else if(intersection.height < intersection.width  && this.y > c.getRectangle().y){ //down
                    y+= intersection.height/2;
                }
            }
        }
        for(Bullet b : bullets){
            b.checkCollision(c);
            c.checkCollision(b);
        }
    }

    public Rectangle getRectangle() {
        return new Rectangle((int)this.x, (int)this.y, img.getWidth(), img.getHeight());
    }

    private void checkBorder() {
        if (x < 30) {
            x = 30;
        }
        if (x >= GameConstants.GAME_SCREEN_WIDTH - 88) {
            x = GameConstants.GAME_SCREEN_WIDTH - 88;
        }
        if (y < 40) {
            y = 40;
        }
        if (y >= GameConstants.GAME_SCREEN_HEIGHT - 80) {
            y = GameConstants.GAME_SCREEN_HEIGHT - 80;
        }
    }

    //@Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", angle=" + angle;
    }


    void drawImage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(Bullet b : bullets){
            b.drawImage(g2d);
        }
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        g2d.drawImage(this.img, rotation, null);
    }



}
