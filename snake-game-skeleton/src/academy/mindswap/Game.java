package academy.mindswap;
import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;

public class Game {
    private Snake snake;
    private Fruit fruit;
    private int delay;
    private int cols;
    private int rows;

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        snake = new Snake(Direction.RIGHT);
        this.delay = delay;
        this.cols = cols;
        this.rows = rows;
        this.fruit = new Fruit();
    }

    public void start() throws InterruptedException {
        generateFruit(); // uncomment when it's time to introduce fruits
        while (true) {
            Thread.sleep(delay);
            Field.clearTail(snake);
            moveSnake();
            checkCollisions();
            Field.drawSnake(snake);
        }
    }

    private void generateFruit() {
        fruit.getPosition();
        Field.drawFruit(fruit);
    }

    private void moveSnake() {
        Key k = Field.readInput();
        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    snake.move(Direction.UP);
                    return;
                case ArrowDown:
                    snake.move(Direction.DOWN);
                    return;
                case ArrowLeft:
                    snake.move(Direction.LEFT);
                    return;
                case ArrowRight:
                    snake.move(Direction.RIGHT);
                    return;
            }
        }
        snake.move();
    }

    private void checkCollisions() {
        if (snake.getHead().equals(fruit)) {
            snake.increaseSize(fruit);
        }
    }
}