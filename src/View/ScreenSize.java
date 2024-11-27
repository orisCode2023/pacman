package View;

public class ScreenSize {
    public static final int ORIGINAL_TILE_SIZE = 15; // 15 * 15 pixel
    public static final int SCALE = 2; // 2 * 15 increase
    public static final int Tile_size = ORIGINAL_TILE_SIZE * SCALE; // 30 pixel per tile
    public static final int MAX_SCREEN_COLUM = 25; // colum from side to side
    public static final int MAX_SCREEN_ROW = 25; // row from up and down

    public static final int SCREEN_WIDTH = Tile_size * MAX_SCREEN_COLUM; // sum of the pixel 750
    public static final int SCREEN_HEIGHT = Tile_size * MAX_SCREEN_ROW; //sum of the pixel 750
}


