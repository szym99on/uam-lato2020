package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class EndingMoveObstacleTest {

    @Test
    void applyShouldReturnNewEndPointForCreature() {
        Creature creature = Creature.builder().aCanFly(false).build();
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle obstacle = factory.createObstacle("river", new Point(1, 1));
        assertEquals(new Point(1,1),obstacle.apply(creature));
    }

    @Test
    void applyErrorCase() {
        Creature creature = Creature.builder().aCanFly(false).build();
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle obstacle = factory.createObstacle("river", new Point(1, 1));
        assertNotEquals(new Point(9,1),obstacle.apply(creature));
    }


}
