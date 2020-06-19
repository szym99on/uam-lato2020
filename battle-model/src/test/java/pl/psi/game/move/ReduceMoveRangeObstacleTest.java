package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ReduceMoveRangeObstacleTest {

    @Test
    void applyMethod(){
        Creature creature = Creature.builder().build();
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle obstacle = factory.createObstacle("marsh", new Point(1, 1));
        assertNotEquals(new Point(1,1),obstacle.apply(creature));
    }
}
