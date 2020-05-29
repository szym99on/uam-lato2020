package pl.psi.game.move;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Obstacle implements GuiTileIf, PropertyChangeListener {

    private final String type;
    private final int attack;
    private final int reduceMoveRange;
    private final boolean isEndingMove;
    private PropertyChangeSupport propertyChangeSupport;


    @Builder
    public Obstacle(String aType, int aAttack, int aReduceMoveRange, boolean aIsEndingMove){
        type = aType;
        attack = aAttack;
        reduceMoveRange = aReduceMoveRange;
        isEndingMove = aIsEndingMove;
    }


    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public boolean isCreature() {
        return false;
    }


    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    public void attack(Creature creature){

    }

    public void reduceMoveRange(Creature creature){

    }

    public void endMove(Creature creature){

    }

}
