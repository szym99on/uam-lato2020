package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.AbstractMap;
import java.util.HashMap;

public class MoveStrategyWalk implements MoveStrategyIf {

    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;

    MoveStrategyWalk(Board aBoard) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void move(int x, int y) {
        Point oldPosition = activeCreature.getKey();
        board.move(x,y,activeCreature.getValue());
        activeCreature = new AbstractMap.SimpleEntry<>(new Point(x,y), activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());

    }
}
