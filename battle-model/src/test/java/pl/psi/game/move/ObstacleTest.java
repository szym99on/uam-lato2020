package pl.psi.game.move;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import static org.junit.jupiter.api.Assertions.*;



import java.awt.*;

public class ObstacleTest {

    @Test
    @Disabled
    void obstacleAttack(){
        Creature c = Creature.builder().aMoveRange(1).aMaxHp(10).build();
        Obstacle o = Obstacle.builder().aAttack(1).build();
        Board board = Board.getBoard();
        board.putCreature(1,1, c);
        board.putObstacle(2, 1, o);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);
        moveEngine.move(2, 1);

        assertEquals(9, c.getCurrentHp());
    }

    @Test
    void obstacleReduceMoveRange(){
    }

    @Test
    void obstacleEndMove(){

    }

}
