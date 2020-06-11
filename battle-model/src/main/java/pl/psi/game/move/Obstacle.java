package pl.psi.game.move;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

import java.awt.*;

public abstract class Obstacle implements GuiTileIf {

    private final String name;

    public Obstacle(String aName){

        name = aName;

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
        return null;
    }
}
