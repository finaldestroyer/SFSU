package Gameplay.PowerUp;

import Gameplay.CollidableObject;
import Gameplay.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spray extends PowerUp{

    private float x, y;
    private Rectangle r;
    private static BufferedImage img;
    private boolean collided = false;

    public Spray(float x, float y) {
        this.x = x;
        this.y = y;
        this.r = new Rectangle((int)x, (int)y, img.getWidth(), img.getHeight());
    }

    public static void setImg(BufferedImage img){
        Gameplay.PowerUp.Spray.img = img;
    }

    @Override
    public void checkCollision(CollidableObject c) {
        if(c instanceof Tank){
            if(this.getRectangle().intersects(c.getRectangle())){
                collided = true;
                //Code to shoot faster
            }
        }
    }
    @Override
    public boolean hasCollided() {
        return false;
    }

    public Rectangle getRectangle() {
        return new Rectangle((int)x, (int)y, img.getWidth(), img.getHeight());
    }

    public void drawImage(Graphics2D buffer){
        buffer.drawImage(img, (int)x, (int)y, null);
    }
}
