package Model;

public abstract class Entity {
    protected int x, y;
    protected char symbol;
    protected boolean isActive;

    public Entity(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public abstract void update();

    public int getX() { return x; }
    public int getY() { return y; }
    public char getSymbol() { return symbol; }
    public boolean isActive() { return isActive; }
    public void destroy() { isActive = false; }
}
