package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed , downPressed , leftPressed , rightPressed; // bottoms

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if (code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
   }
}
