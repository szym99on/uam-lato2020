package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;



public class DealDamageObstacleTest {
    @Test
    void walkingCreatureDealDamage(){

        Creature creature = Creature.builder().aMaxHp(10).aCanFly(false).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        ImpactCreatureObstacle obstacle = obstacleFactory.createImpactCreatureObstacle("lava", new Point(1, 2));

        obstacle.apply(creature);

        assertEquals(9, creature.getCurrentHp());

    }

    @Test
    void flyingCreature(){

        Creature creature = Creature.builder().aMaxHp(10).aCanFly(true).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        ImpactCreatureObstacle obstacle = obstacleFactory.createImpactCreatureObstacle("lava", new Point(1, 2));

        obstacle.apply(creature);

        assertEquals(creature.getMaxHp(), creature.getCurrentHp());

    }
}
