package pl.psi.game.move;

import java.util.ArrayList;

public class ObstacleInfoFactory {

    private final ArrayList<ObstacleInfo> obstacle = new ArrayList<>() {
        {
            add(new ObstacleInfo("impassable"));
        }
    };
}
