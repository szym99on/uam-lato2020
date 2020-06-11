package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

public abstract class Obstacle implements GuiTileIf {

    private final String name;
    private final Point point;

    public Obstacle(String aName, Point aPoint){
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

    public abstract void apply(Creature aCreature);

    @Override
    public Point getPoint() {
        return point;
    }
}
