import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {

    private final Map<Point, Creature> board;
    private final static int BOARD_WIDTH = 14;
    private final static int BOARD_HIGH = 9;

    public Board() {
        board = new HashMap<>();
    }

    public void putCreature(int x, int y, Creature aCreature) {
        if (x > BOARD_WIDTH || x < 0 || y > BOARD_HIGH || y < 0){
            throw new IllegalArgumentException("You tried put creature outside the board");
        }

        if (board.containsKey(new Point(x,y))){
            throw new IllegalArgumentException("Field isn't empty");
        }

        board.put(new Point(x,y), aCreature);
    }

    public Creature getCreature(int x, int y) {
        return board.get(new Point(x,y));
    }

    public Optional<Point> getCreatureLocation(Creature c1) {
        return board.keySet().stream().filter( p -> board.get(p).equals(c1)).findAny();
    }

    public boolean isMovePossible(int x, int y) {
        return false;
    }
}
