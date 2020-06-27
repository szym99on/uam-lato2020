package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

public abstract class ImpactMoveObstacle implements ObstacleIf{

    String name;
    Point point;

    public ImpactMoveObstacle(String aName, Point aPoint){
        name = aName;
        point = aPoint;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public boolean isCreature() {
        return false;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public abstract boolean isMovePossible();
}
