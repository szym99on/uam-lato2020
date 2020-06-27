package pl.psi.game.move;

import java.awt.*;

public interface ObstacleFactoryIf {
    ImpactCreatureObstacle createImpactCreatureObstacle(String name, Point point);
    ImpactMoveObstacle createImpactMoveObstacle(String name, Point point);
}
