package Model;

import Control.KeyHandler;
import Model.Ghosts.Direction;
import View.ScreenSize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Pacman extends EntitiesDynamic {
    public int LIFE = 3;
    public int score = 0;
    KeyHandler kh;
    public Pacman(KeyHandler kh) {
        this.kh = kh;
        this.locationX = 12;
        this.locationY = 21;
        setDefaultValues();
        getPlayerImage();
    }
    @Override
    public MapPacman[][] startPoint() {
        return new MapPacman[locationX][locationY];
    }
    public void setDefaultValues() {
        startPoint();
        speed = 2;
        direction = Direction.RIGHT;
    }
    public void getPlayerImage() { // drawing the player in every position
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/up1.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/up2.png.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/down1.png.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/down2.png.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/left1.png.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/left2.png.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/right1.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Resource/pacman/right2.png.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void outBounds() {
        if (locationX == 0 && locationY == 10) {
            locationX = mp.myMap.length - 2;
        } else if (locationX == mp.myMap.length - 1 && locationY == 10) {
            locationX = 2;
        }
    }
    public void direction() {
        checkCoins();
        outBounds();
        if (kh.upPressed) {
            if (mp.myMap[locationY - 1][locationX] != CellType.WALL.getId()) {
                direction = Direction.UP;
                move();
            }
        }
        if (kh.downPressed) {
            if (mp.myMap[locationY + 1][locationX] != CellType.WALL.getId()) {
                direction = Direction.DOWN;
                move();
            }
        }
        if (kh.leftPressed) {
            if (mp.myMap[locationY][locationX - 1] != CellType.WALL.getId()) {
                direction = Direction.LEFT;
                move();
            }
        }
        if (kh.rightPressed) {
            if (mp.myMap[locationY][locationX + 1] != CellType.WALL.getId()) {
                direction = Direction.RIGHT;
                move();
            }
        }
        checkCoins();
    }
    void move() {
        switch (direction) {
            case UP -> locationY -= 1;
            case DOWN -> locationY += 1;
            case LEFT -> locationX -= 1;
            case RIGHT -> locationX += 1;
        }
    }
    public void checkSprite() {
        spriteCounter++;
        if (spriteCounter > 3) {
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }
    public void update() {
        checkSprite();
        direction();
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case UP:
                image = spriteNumber == 1 ? up1 : up2;
                break;
            case DOWN:
                image = spriteNumber == 1 ? down1 : down2;
                break;
            case LEFT:
                image = spriteNumber == 1 ? left1 : left2;
                break;
            case RIGHT:
                image = spriteNumber == 1 ? right1 : right2;
                break;
        }
        g2.drawImage(image, locationX * ScreenSize.Tile_size, locationY * ScreenSize.Tile_size, ScreenSize.Tile_size, ScreenSize.Tile_size, null);

    }

    public void checkCoins() {
        if (mp.myMap[locationY][locationX] == CellType.COIN.getId()) {
            score += 10;
            mp.myMap[locationY][locationX] = CellType.PATH.getId();
        }
        if (mp.myMap[locationY][locationX] == CellType.POWER_COIN.getId()) {
            score += 50;
            mp.myMap[locationY][locationX] = CellType.PATH.getId();
        }
    }
}



