package Model;

public enum CellType {
    WALL(0),
    PATH(1),
    PACMAN(2),
    COIN(3),
    POWER_COIN(4),
    GHOST(5),
    FRUIT(6);
    private final int id;

    CellType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
