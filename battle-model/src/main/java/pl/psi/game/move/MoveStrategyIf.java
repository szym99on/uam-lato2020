package pl.psi.game.move;

import pl.psi.game.Board;

import java.awt.*;
import java.util.List;

public interface MoveStrategyIf {

    void move(Point desPoint);
    boolean isMovePossible(Point destPoint);
    List getMovePath(Point destPoint);
}
