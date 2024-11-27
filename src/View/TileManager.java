package View;

import Model.CellType;
import Model.MapPacman;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    Tile[] tiles;
    MapPacman mp = MapPacman.getInstance();

    public TileManager() {
        this.tiles = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Resource/tiles/wall.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Resource/tiles/floor.png"));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/Resource/tiles/coin.png"));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/Resource/tiles/powerCoin.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int screenX;
        int screenY;
        mp.convertToEnum(mp.myMap);
        for (int i = 0; i < mp.myMap.length; i++) {
            for (int j = 0; j < mp.myMap[0].length; j++) {
                int tileNumber = mp.myMap[j][i];
                screenX = i * ScreenSize.Tile_size;
                screenY = j * ScreenSize.Tile_size;
                if (tileNumber == CellType.WALL.getId()) {
                    g2.drawImage(tiles[CellType.WALL.getId()].image, screenX, screenY, ScreenSize.Tile_size, ScreenSize.Tile_size, null);
                }
                else if (tileNumber == CellType.PATH.getId()) {
                    g2.drawImage(tiles[CellType.PATH.getId()].image, screenX, screenY, ScreenSize.Tile_size, ScreenSize.Tile_size, null);
                }
                else if (tileNumber == CellType.COIN.getId()) {
                    g2.drawImage(tiles[CellType.COIN.getId()].image, screenX, screenY, ScreenSize.Tile_size, ScreenSize.Tile_size, null);
                }
                else {
                    g2.drawImage(tiles[CellType.POWER_COIN.getId()].image, screenX, screenY, ScreenSize.Tile_size, ScreenSize.Tile_size, null);
                }
            }
        }
    }
}
