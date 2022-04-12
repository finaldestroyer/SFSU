package Gameplay.PowerUp;

import Gameplay.CollidableObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class PowerUp implements CollidableObject {
    public void checkCollision(CollidableObject c) { }

    @Override
    public Rectangle getRectangle() { return null; }

    public static void setImg(BufferedImage powerUp){ }

    public void drawImage(Graphics2D buffer){ }

    public abstract boolean hasCollided();
}
