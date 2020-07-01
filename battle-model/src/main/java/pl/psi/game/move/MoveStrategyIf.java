package pl.psi.game.move;

import java.awt.*;
import java.util.List;

interface MoveStrategyIf {

    void move(Point desPoint);
    boolean isMovePossible(Point destPoint);
    List getMovePath(Point destPoint);
}
