import java.awt.*;

public class MoveEngine {

    private Creature activeCreature;
    private final Board board;

    public MoveEngine(Board aBoard) {
        board = aBoard;
    }

    public void setActiveCreature(Creature activeCreature) {
        this.activeCreature = activeCreature;
    }

    public boolean isMovePossible(int x, int y) {
        return board.isTileEmpty(x,y) && new Point(x,y).distance(board.getCreatureLocation(activeCreature).get()) <= activeCreature.getMoveRange();
    }
}
