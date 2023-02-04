package academy.mindswap.gameobjects.snake;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;

import java.util.Iterator;
import java.util.LinkedList;
public class Snake implements Iterable {
    private final static int SNAKE_INITIAL_SIZE = 3;
    private Direction direction;
    private boolean alive;
    private Position head;
    private Position tail;
    LinkedList<Position> snakeBody;
    //Iterator snakeIterator = snakeBody.iterator();
    public Snake(Direction direction) {
        this.direction = direction;
        snakeBody = new LinkedList<>();
        for(int i = 0; i < getSnakeSize(); i++) {
            snakeBody.add(i, new Position(50 - i, 12));
        }
        this.tail = snakeBody.getLast();
        this.head = snakeBody.getFirst();
        this.alive = true;
    }
    public void increaseSize(Fruit fruit) {
        if(head.equals(fruit.getFruitPosition())){
            getSnakeSize();
            fruit.getPosition();
        }
    }

    public void move(Direction direction) {
        if (direction == Direction.UP && this.direction == Direction.DOWN) return;
        if (direction == Direction.DOWN && this.direction == Direction.UP) return;
        if (direction == Direction.RIGHT && this.direction == Direction.LEFT) return;
        if (direction == Direction.LEFT && this.direction == Direction.RIGHT) return;
        else {
            this.direction = direction;
            switch (direction) {
                case DOWN:
                    snakeBody.addFirst(new Position(head.getCol(), head.getRow() + 1));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
                case UP:
                    snakeBody.addFirst(new Position(head.getCol(), head.getRow() - 1));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
                case LEFT:
                    snakeBody.addFirst(new Position(head.getCol() - 1, head.getRow()));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
                case RIGHT:
                    snakeBody.addFirst(new Position(head.getCol() + 1, head.getRow()));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
            }
        }
    }
    public void move(){
        move(direction);
    }
    public void die() {
        alive = false;
    }
    public boolean isAlive() {
        return alive;
    }
    public Position getHead() {
        return head;
    }
    public Position getTail() {
        return tail;
    }
    public LinkedList<Position> getFullSnake(){
        return snakeBody;
    }
    public int getSnakeSize() {
        int i=0;
        i += 1;
        return SNAKE_INITIAL_SIZE+i;
    }
    @Override
    public Iterator iterator() {
        return null;
    }
}
