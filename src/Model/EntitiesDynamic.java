package Model;


import Model.Ghosts.Direction;
import View.ScreenSize;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class EntitiesDynamic {
    public abstract MapPacman[][] startPoint();

    public int speed;
    public int spriteNumber = 1;
    public int spriteCounter = 0;
    public int locationX;
    public int locationY;
    public Random random = new Random();
    public int number;
    public MapPacman mp = MapPacman.getInstance();
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, staring;
    public Direction direction;
    public int moveCounter = 0;
    public List<Direction> possibleDirections = new ArrayList<>();
}
