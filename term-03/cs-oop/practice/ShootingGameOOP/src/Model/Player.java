package Model;

public class Player extends Entity {
    public Player(int x, int y) {
        super(x, y, 'A');
    }

    @Override
    public void update() {
        // player movement logic
    }

    public void moveLeft() { if (x > 0) x--; }

    public void moveRight(int maxX) { if (x < maxX) x++; }
}

