package pl.psi.game.move;

import java.util.ArrayList;

public class ObstacleInfoFactory {

    private final ArrayList<ObstacleInfo> obstacle = new ArrayList<>() {
        {
            add(ObstacleInfo.builder().aObstacleClass(ObstacleInfo.ObstacleClass.LAVA).build());
            add(ObstacleInfo.builder().aObstacleClass(ObstacleInfo.ObstacleClass.MARSH).build());
            add(ObstacleInfo.builder().aObstacleClass(ObstacleInfo.ObstacleClass.ROCK).build());
        }
    };
}
