package pl.psi.game.move;

import java.awt.*;

public class ObstacleFactory implements ObstacleFactoryIf {

    @Override
    public ImpactCreatureObstacle createImpactCreatureObstacle(String name, Point point) {

        ImpactCreatureObstacle obstacle;
        if (name.equals("lava")){
            obstacle =  new DealDamageObstacle(name, point);
        } else {
            throw new IllegalArgumentException("Unknown obstacle: " + name);
        }

        return obstacle;

    }

    @Override
    public ImpactMoveObstacle createImpactMoveObstacle(String name, Point point) {
        ImpactMoveObstacle obstacle;
        if (name.equals("marsh")){
            obstacle =  new ReduceMoveRangeObstacle(name, point);
        } else if (name.equals("rock")){
            obstacle = new EndingMoveObstacle(name, point);
        } else {
            throw new IllegalArgumentException("Unknown obstacle: " + name);
        }

        return obstacle;

    }
}
