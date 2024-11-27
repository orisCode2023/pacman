package View;

import Model.Pacman;

import javax.swing.*;
import java.awt.*;

public class GameLoop implements Runnable {
    GamePanel gp;
    Thread gameThread;
    int counter = 0;

    public GameLoop(GamePanel gp) {
        this.gp = gp;
    }
    int FPS = 60;

    public void startGameThread() { // make sure that few code can run on the same time
        gameThread = new Thread(this);
        gameThread.start(); //  function to start the game
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // keeps the time between every update , and keeps unit rate 16,666,667
        double delta = 0; // variable
        long lastTime = System.nanoTime();
        long currentTime; // variable
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                gp.repaint();
                delta--;
                drawCount++;
                counter++;
                if (counter == 10){
                    gp.pacman.update();
                    gp.gm.updateGhosts();
                    counter = 0;
                }
            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }
}

