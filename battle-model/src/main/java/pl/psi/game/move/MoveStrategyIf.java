package pl.psi.game.move;

import pl.psi.game.Board;

import java.awt.*;
import java.util.List;

public interface MoveStrategyIf {

    void move(Point desPoint);
    List<Step> getSteps(Point destPoint);
    boolean isMovePossible(Board board, Point startPoint, Point destPoint);
}
