package Gameplay.Walls;

import Gameplay.CollidableObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Wall implements CollidableObject {

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    public static void setImg(BufferedImage wallImg){ }

    public void drawImage(Graphics2D buffer){ }

    public abstract boolean hasCollided();

}
