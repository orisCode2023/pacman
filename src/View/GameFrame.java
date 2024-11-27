package View;

import javax.swing.*;

public class GameFrame extends JFrame{
    public void startFrame(GamePanel gamePanel){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("BEAT ME");
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
