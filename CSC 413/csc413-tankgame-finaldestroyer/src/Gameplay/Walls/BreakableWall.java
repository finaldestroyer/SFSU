package Gameplay.Walls;

import Gameplay.Bullet;
import Gameplay.CollidableObject;
import Gameplay.GameWorld;
import Gameplay.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BreakableWall extends Wall {

    private int x, y;
    private Rectangle r;
    private static BufferedImage wallImg;
    private boolean collided = false;

    public BreakableWall(float x, float y) {
        this.x = (int) x;
        this.y = (int) y;
        this.r = new Rectangle((int) x, (int) y, wallImg.getWidth(), wallImg.getHeight());
    }
    public static void setImg(BufferedImage img){
        wallImg = img;
    }

    @Override
    public void checkCollision(CollidableObject c) {
        if(c instanceof Bullet){
            if(this.getRectangle().intersects(c.getRectangle())){
                collided = true;
            }
        }
    }

    public boolean hasCollided() {
        return collided;
    }

    @Override
    public Rectangle getRectangle() {
        return r;
    }

    public void drawImage(Graphics2D buffer){
        buffer.drawImage(wallImg, x, y, null);
    }
}
