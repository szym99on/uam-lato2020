package pl.psi.game.move;

import pl.psi.game.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

class AStarAlgo {

    List<Point> path(Point startPoint, Point endPoint, Board board){

        java.util.List<Point> path = new ArrayList<Point>();
        int distance = getDistance(startPoint, endPoint);
        int winner;
        java.util.List<Point> closedSet = new ArrayList<Point>();
        java.util.List<Point> openSet = new ArrayList<Point>();

        openSet.add(startPoint);

        while (!openSet.isEmpty()){
            winner = 0;

            for (int i = 0; i < openSet.size(); i++){
                if( openSet.get(i))
            }
        }


        return path;
    }

    List<Point> getNeighbors(Point point){
        List<Point> neighbors = new ArrayList<Point>();
        int x = (int) point.getX();
        int y = (int) point.getY();

        if (x + 1 <= Board.BOARD_WIDTH) neighbors.add(new Point(x + 1, y));
        if (x - 1 > 0) neighbors.add(new Point(x - 1, y));
        if (y + 1 <= Board.BOARD_HIGH) neighbors.add(new Point(x, y + 1));
        if (y - 1 > 0) neighbors.add(new Point(x, y - 1));

        return neighbors;
    }

    int getDistance(Point startPoint, Point endPoint) {

        int distance = (int) (abs(endPoint.getX() - startPoint.getX()) + abs(endPoint.getY() - startPoint.getY()));

        return distance;

    }
}
