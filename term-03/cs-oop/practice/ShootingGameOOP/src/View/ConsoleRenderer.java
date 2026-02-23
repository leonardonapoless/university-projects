package View;
import Model.*;
import java.util.List;

public class ConsoleRenderer {
    private int width, height;
    public ConsoleRenderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(Player player, List<Entity> entities) {
        for (int i = 0; i < 50; i++) IO.println();
        char [][] buffer = new char[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                buffer[row][col] = '.';
            }
        }

        if (isInBounds(player.getX(), player.getY())){
            buffer[player.getY()][player.getX()] = player.getSymbol();
        }

        for (Entity e : entities) {
            if (isInBounds(e.getX(), e.getY())){
                buffer[e.getY()][e.getX()] = e.getSymbol();
            }
        }

        IO.println("Controls: [a] Left, [d] Right, [f] Fire, [q] Quit");
        for  (int row = 0; row < height; row++) IO.println(new String(buffer[row]));
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}