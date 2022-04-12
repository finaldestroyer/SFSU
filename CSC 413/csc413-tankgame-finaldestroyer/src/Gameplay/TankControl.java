package Gameplay;


import Gameplay.Tank;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;


public class TankControl extends KeyAdapter implements KeyListener  {

    /* Player 1 */
    private Tank t1;
    private final float up;
    private final float down;
    private final float right;
    private final float left;
    private final float shoot;

    /* Player 1 */
    public TankControl(Tank t1, float up, float down, float left, float right, float shoot) {
        this.t1 = t1;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.shoot = shoot;
    }
    /* Player 2 */
    /*
    private Tank t2;
    private final float up2;
    private final float down2;
    private final float right2;
    private final float left2 ;
    private final float shoot2;
    */
    /* Player 2 */
    /*
    public TankControl(Tank t2, float up, float down, float left, float right, float shoot) {
        this.t2 = t2;
        this.up2 = up2;
        this.down2 = down2;
        this.right2 = right2;
        this.left2 = left2;
        this.shoot2 = shoot2;
    }*/

    /* Player 1 */
    @Override
    public void keyPressed(KeyEvent ke) {
        float keyPressed = ke.getKeyCode();
        if (keyPressed == up) {
            this.t1.toggleUpPressed();
        }
        if (keyPressed == down) {
            this.t1.toggleDownPressed();
        }
        if (keyPressed == left) {
            this.t1.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.t1.toggleRightPressed();
        }
        //if (keyPressed == KeyEvent.CTRL_MASK){
        if (keyPressed == KeyEvent.VK_CONTROL){
            this.t1.shootBullet();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        float keyReleased = ke.getKeyCode();
        if (keyReleased  == up) {
            this.t1.unToggleUpPressed();
        }
        if (keyReleased == down) {
            this.t1.unToggleDownPressed();
        }
        if (keyReleased  == left) {
            this.t1.unToggleLeftPressed();
        }
        if (keyReleased  == right) {
            this.t1.unToggleRightPressed();
        }

    }
    /* Player 2 */
    /*
    @Override
    public void keyTyped(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (evt.getKeyChar() == 'w') {
            this.t2.toggleUpPressed();
        }
        if (evt.getKeyChar() == 's') {
            this.t2.toggleDownPressed();
        }
        if (evt.getKeyChar() == 'a') {
            this.t2.toggleLeftPressed();
        }
        if (evt.getKeyChar() == 'd') {
            this.t2.toggleRightPressed();
        }
        if (evt.getKeyChar() == '') {
            this.t2.toggleShootPressed();
        }
        if (keyPressed == KeyEvent.VK_SPACE){
            this.t1.shootBullet();
        }
    }
    public void keyUnTyped(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (evt.getKeyChar() == 'w') {
            this.t2.unToggleUpPressed();
        }
        if evt.getKeyChar() == 's') {
            this.t2.unToggleDownPressed();
        }
        if (evt.getKeyChar() == 'a') {
            this.t2unToggleLeftPressed();
        }
        if (evt.getKeyChar() == 'd') {
            this.t2.unToggleRightPressed();
        }
        if (evt.getKeyChar() == '') {
            this.t2.unToggleShootPressed();
        }
    }
    */

}
