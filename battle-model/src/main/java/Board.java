import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Point, Creature> board;

    public Board() {
        board = new HashMap<>();
    }

    public void putCreature(int x, int y, Creature aCreature) {
        board.put(new Point(x,y), aCreature);
    }

    public Creature getCreature(int x, int y) {
        return board.get(new Point(x,y));
    }
}
