package Gameplay;

import Gameplay.PowerUp.PowerUp;
import Gameplay.PowerUp.ExtraLife;
import Gameplay.PowerUp.SpeedBoost;
import Gameplay.PowerUp.Spray;
import Gameplay.Walls.Wall;
import Gameplay.Walls.BreakableWall;
import Gameplay.Walls.UnbreakableWall;

import java.awt.*;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<PowerUp> powerUps = new ArrayList<>();
    float width = GameWorld.WORLD_WIDTH;
    float height = GameWorld.WORLD_HEIGHT;

    public GameMap(){
        for(float i = 0; i < width; i += 32){
            walls.add(new UnbreakableWall(i, 0));
            walls.add(new UnbreakableWall(i, height - 32));
        }

        for(float i = 32; i < height; i += 32){
            walls.add(new UnbreakableWall(width - 32, i));
            walls.add(new UnbreakableWall(0, i));
        }

        for(float i = width / 10; i < width; i += 192){
            for(float j = height / 4; j < height - 192; j += 192){
                walls.add(new BreakableWall(i, j));
            }
        }

        for(int i = 64; i < height - 64; i += 32){
            walls.add(new BreakableWall(width / 2 + 32, i));
        }

        powerUps.add(new ExtraLife(250, 550));
        powerUps.add(new ExtraLife(1000, 800));
        powerUps.add(new ExtraLife(1200, 100));

        powerUps.add(new SpeedBoost(100, 1000));
        powerUps.add(new SpeedBoost(900, 150));
    }
    public void handleCollision(CollidableObject c) {
        for(int i = 0; i < walls.size(); i++){
            c.checkCollision(walls.get(i));
            walls.get(i).checkCollision(c);
            if(walls.get(i).hasCollided()){
                walls.remove(i);
            }
        }
        for(int i = 0; i < powerUps.size(); i++){
            powerUps.get(i).checkCollision(c);
            if(powerUps.get(i).hasCollided()){
                powerUps.remove(i);
            }
        }
    }

    public void drawImage(Graphics g) {
        Graphics2D g2g = (Graphics2D) g;
        for(int i = 0; i < walls.size(); i++) {
            walls.get(i).drawImage(g2g);
        }
        for(int i = 0; i < powerUps.size(); i++){
            powerUps.get(i).drawImage(g2g);
        }
    }
}
