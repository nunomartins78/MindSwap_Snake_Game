package academy.mindswap.gameobjects.fruit;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.snake.Snake;

public class Fruit {
    Position fruitPosition;
    private Snake snake;

    public Fruit() {
        this.fruitPosition = getRandomPosition();
    }

    public Position getPosition() {
        return generateFruitPosition();
    }

    private Position generateFruitPosition() {
        Position snakeLocation = new Position(0, 0);
        while(fruitPosition==null) {
            fruitPosition = this.getRandomPosition();
            while (fruitPosition.equals(snakeLocation)) {
                for (int i = 0; i < snake.getSnakeSize(); i++) {
                    snakeLocation = new Position(
                            snake.getFullSnake().get(i).getCol(),
                            snake.getFullSnake().get(i).getRow()
                    );
                }
            }
        }
        return fruitPosition;
    }

    public Position getRandomPosition() {
        int randomCols = (int) Math.floor(Math.random() * 100 + 2);
        int randomRows = (int) Math.floor(Math.random() * 25 + 1);
        return new Position(randomCols,randomRows);
    }

    public Position getFruitPosition() {
        return fruitPosition;
    }
}