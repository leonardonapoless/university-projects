package Model;

public class Bullet extends Entity {
    public Bullet(int x, int y) {
        super(x, y, '|');
    }

    @Override
    public void update(){
        y--;
        if (y < 0) destroy();

    }
}
