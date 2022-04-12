package Gameplay.Walls;

import Gameplay.CollidableObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UnbreakableWall extends Wall {

    private float x, y;
    private Rectangle r;
    private static BufferedImage wallImg;

    public UnbreakableWall() {}

    public UnbreakableWall(float x, float y){
        this.x = x;
        this.y = y;
        this.r = new Rectangle((int)x, (int)y, wallImg.getWidth(), wallImg.getHeight());
    }

    public static void setImg(BufferedImage img){
        UnbreakableWall.wallImg = img;
    }


    @Override
    public void checkCollision(CollidableObject c) { }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle((int) x, (int) y, wallImg.getWidth(), wallImg.getHeight());
    }

    public void drawImage(Graphics2D buffer){
        buffer.drawImage(wallImg, (int)x, (int)y, null);
    }

    @Override
    public boolean hasCollided() {
        return false;
    }
}
