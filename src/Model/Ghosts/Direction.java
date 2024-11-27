package Model.Ghosts;

public enum Direction {
    UP(0),
    DOWN(1),
    LEFT(2),
    RIGHT(3),
    STARING(4);
    private final int id;

    Direction(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
