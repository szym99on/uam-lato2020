package pl.psi.game.move;

import pl.psi.game.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

class DijkstraAlgo {
    List<Point> path(Point startPoint, Point endPoint, Board board){

        java.util.List<Point> path = new ArrayList<Point>();
        int distance = getDistance(startPoint, endPoint);


        return path;
    }

    List<Point> getNeighbors(Point point){
        List<Point> neighbors = new ArrayList<Point>();
        int x = (int) point.getX();
        int y = (int) point.getY();

        if (y >= 1) {
            Point neighbor = new Point(x, y - 1);
            neighbors.add(neighbor);
        }

        if (y <= Board.BOARD_HIGH - 1) {
            Point neighbor = new Point(x, y + 1);
            neighbors.add(neighbor);
        }

        if (x >= 1) {
            Point neighbor = new Point(x - 1, y);
            neighbors.add(neighbor);
        }

        if (y <= Board.BOARD_WIDTH) {
            Point neighbor = new Point(x + 1, y);
            neighbors.add(neighbor);
        }


        return neighbors;
    }

    int getDistance(Point startPoint, Point endPoint) {

        int distance = (int) (abs(endPoint.getX() - startPoint.getX()) + abs(endPoint.getY() - startPoint.getY()));

        return distance;

    }
}
