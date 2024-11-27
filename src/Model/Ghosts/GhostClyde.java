package Model.Ghosts;

import Model.CellType;
import Model.EntitiesDynamic;
import Model.MapPacman;
import View.ScreenSize;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GhostClyde extends EntitiesDynamic {
    public GhostClyde() {
        this.locationY = 10;
        this.locationX = 10;
        setDefaultValues();
        getGhostImage();
    }
    public void setDefaultValues() {
        startPoint();
        speed = 2;
        direction = Direction.UP;
    }
    public void getGhostImage() { // drawing the player in every position
        try {
            staring = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Resource/ghosts/3/right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public MapPacman[][] startPoint() {
        return new MapPacman[locationX][locationY];
    }
    void canMove() {
        number = random.nextInt(4);
        if (number == Direction.UP.getId()) {
            if (mp.myMap[locationY - 1][locationX] != CellType.WALL.getId()) {
                direction = Direction.UP;
            }
        }
        if (number == Direction.DOWN.getId()) {
            if (mp.myMap[locationY + 1][locationX] != CellType.WALL.getId()) {
                direction = Direction.DOWN;
            }
        }
        if (number == Direction.LEFT.getId()) {
            if (mp.myMap[locationY][locationX - 1] != CellType.WALL.getId()) {
                direction = Direction.LEFT;
            }
        }
        if (number == Direction.RIGHT.getId()) {
            if (mp.myMap[locationY][locationX + 1] != CellType.WALL.getId()) {
                direction = Direction.RIGHT;
            }
        }
    }
    void move() {
        int newX = locationX;
        int newY = locationY;
        moveCounter++;
        if (moveCounter >= (5 - speed)) {
            switch (direction) {
                case UP -> newY -= 1;
                case DOWN -> newY += 1;
                case LEFT -> newX -= 1;
                case RIGHT -> newX += 1;
            }
            moveCounter = 0;
        }
        if (isValidMove(newX, newY)) {
            locationX = newX;
            locationY = newY;
        }
    }
    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < mp.myMap[0].length &&
                y >= 0 && y < mp.myMap.length &&
                mp.myMap[y][x] != CellType.WALL.getId();
    }
    public void outBounds() {
        if (locationY == 10 && locationX == 0) {
            locationX = mp.myMap.length - 2;
        } else if (locationY == 10 && locationX == mp.myMap.length - 1) {
            locationX = 2;
        }
    }

    public void direction() {
        canMove();
        move();
        outBounds();
    }
    public void checkSprite() {
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image;
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
            default:
                image = staring;
                break;
        }
        g2.drawImage(image, locationX * ScreenSize.Tile_size , locationY * ScreenSize.Tile_size, ScreenSize.Tile_size, ScreenSize.Tile_size, null);
    }
}
