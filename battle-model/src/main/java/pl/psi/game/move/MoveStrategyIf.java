package pl.psi.game.move;


import java.util.LinkedList;

public interface MoveStrategyIf {

    void move(int x, int y); // zaorać
    LinkedList<Step> getSteps(int finalX, int finalY);
    // boolean isMovePossible(board,oldPoint,x,y) x,y -> point
}
