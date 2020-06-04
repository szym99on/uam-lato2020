package pl.psi.game.move;


import java.util.LinkedList;

public interface MoveStrategyIf {

    void move(int x, int y);
    LinkedList<Step> getSteps(int finalX, int finalY);

}
