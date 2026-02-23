package Model;

public class Enemy extends Entity {
    public Enemy (int x,  int y) {
        super(x, y, 'V');
    }

    @Override
    public void update() {
        if (Math.random() < 0.3) {
            y++;
        }
    }
}
