package View;

import Control.KeyHandler;
import Model.Ghosts.*;
import Model.MapPacman;
import Model.Pacman;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    KeyHandler kHandler = new KeyHandler();
    public Pacman pacman = new Pacman(kHandler);
    TileManager tm = new TileManager();
    public GhostManager gm = new GhostManager();
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenSize.SCREEN_WIDTH, ScreenSize.SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);// background color
        this.setDoubleBuffered(true);// to make sure to draw screen with no problem
        this.addKeyListener(kHandler);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tm.draw(g2);
        pacman.draw(g2);
        gm.drawGhost(g2);

        g2.setColor(Color.WHITE); // צבע הטקסט
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Lives: " + pacman.LIFE, 10, 20); // הדפסת מספר חיים
        g2.drawString("Score: " + pacman.score, 10, 50); // הדפסת ניקוד

        g2.dispose();
    }
    public void updateScore(int points) {
        this.pacman.score += points;
        repaint();
    }
    public void updateLives(int change) {
        this.pacman.LIFE += change;
        repaint();
    }
}



