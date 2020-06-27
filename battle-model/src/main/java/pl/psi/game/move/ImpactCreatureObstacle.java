package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

public abstract class ImpactCreatureObstacle implements ObstacleIf {

    String name;
    Point point;

    public ImpactCreatureObstacle(String aName, Point aPoint){
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

    abstract void apply(Creature creature);
}
