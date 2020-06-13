package pl.psi.game.move;

import java.awt.*;

public class ObstacleFactory {

    public Obstacle createObstacle(String name, Point point){
        Obstacle obstacle = null;

        if (name.equals("lava")){
            obstacle = new DealDamageObstacle(name, point);
        } else if (name.equals("marsh")) {
            obstacle = new ReduceMoveRangeObstacle(name, point);
        } else if (name.equals("river")){
            obstacle = new EndingMoveObstacle(name, point);
        } else {
            throw new IllegalArgumentException("Unknown obstacle: " + name);
        }
        return obstacle;
    }
}
