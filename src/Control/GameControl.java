package Control;

import Model.MapPacman;
import Model.Pacman;
import View.GameFrame;
import View.GameLoop;
import View.GamePanel;

public class GameControl {
    GamePanel gamePanel = new GamePanel();
    GameLoop gl = new GameLoop(gamePanel);
    GameFrame frame = new GameFrame();

    public void game() {
        frame.startFrame(gamePanel);
        gl.startGameThread();
        gl.run();
    }

}

