import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game {
    private boolean isRunning = true;
    private Player player;
    private List<Entity> entities = new ArrayList<>();
    private ConsoleRenderer renderer;
    private Scanner scanner = new Scanner(System.in);
    private int width = 10, height = 10;
    private String lastInput = "";

    public Game() {
        player = new Player(width / 2, height - 1);
        renderer = new ConsoleRenderer(width, height);
        // Spawn some initial enemies
        entities.add(new Enemy(2, 0));
        entities.add(new Enemy(5, 1));
        entities.add(new Enemy(8, 0));
    }

    public void run() {
        // Start input thread
        Thread inputThread = new Thread(() -> {
            while (isRunning) {
                if (scanner.hasNext()) {
                    lastInput = scanner.next();
                }
            }
        });
        inputThread.start();

        while (isRunning) {
            processInput();
            updateGameLogic();
            checkCollisions();
            renderer.draw(player, entities);
            sleep(300); // Game Speed
        }
        System.out.println("Game Over!");
        // We'd ideally interrupt the input thread here, but Scanner is blocking.
        // For this simple example, we accept the program might hang on exit until a key is pressed.
        System.exit(0); 
    }

    private void processInput() {
        // In a real-time loop, we check what the LAST input was, process it, then clear it.
        String input = lastInput;
        lastInput = ""; // Clear buffer

        if (input.equals("a")) player.moveLeft();
        else if (input.equals("d")) player.moveRight(width - 1);
        else if (input.equals("f")) entities.add(new Bullet(player.getX(), player.getY() - 1));
        else if (input.equals("q")) isRunning = false;
    }

    private void updateGameLogic() {
        // Polymorphism in action: We treat all specific objects as generic 'Entity'
        Iterator<Entity> iterator = entities.iterator();
        while(iterator.hasNext()) {
            Entity e = iterator.next();
            e.update();

            // Remove things that went off-screen
            if (!e.isActive() || e.getY() >= height || e.getY() < 0) {
                iterator.remove();
            }
        }

        // Simple enemy spawner
        if (Math.random() < 0.1) entities.add(new Enemy((int)(Math.random() * width), 0));
    }

    private void checkCollisions() {
        // Basic O(n^2) collision check
        List<Entity> bullets = new ArrayList<>();
        List<Entity> enemies = new ArrayList<>();

        for (Entity e : entities) {
            if (e instanceof Bullet) bullets.add(e);
            else if (e instanceof Enemy) enemies.add(e);
        }

        for (Entity b : bullets) {
            for (Entity e : enemies) {
                if (b.getX() == e.getX() && b.getY() == e.getY()) {
                    b.destroy();
                    e.destroy();
                    // System.out.println("BOOM!"); // Messes up rendering
                }
            }
        }
        
        // Check Player collision (Game Over condition)
        for (Entity e : enemies) {
             if (e.getX() == player.getX() && e.getY() == player.getY()) {
                 isRunning = false;
             }
        }
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        new Game().run();
    }
}