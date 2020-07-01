package pl.psi.game.move;

import pl.psi.game.Board;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.psi.game.Board.BOARD_HIGH;
import static pl.psi.game.Board.BOARD_WIDTH;


class PathCounter {

    private final int recursionGuard = 500;
    private int obstacleCost;
    private int obstacleCostRock;
    Map<Point, Integer> aStarBoard = new HashMap<>();

    PathCounter(String type) {
        aStarBoard.clear();

       switch (type) {
           case "fly":
               obstacleCost = 0;
               obstacleCostRock = 0;
               break;
           case "walk":
               obstacleCost = 200;
               obstacleCostRock = 1000000;

               break;
           default:
               throw new IllegalArgumentException("Creature doesn't have such a strategy!");
       }
    }

    void init(Point startPoint){
        aStarBoard = mapCostGenerate(startPoint);
    }

    List countPath(Point point, Point endPoint, List<Point> path) {
        if(recursionGuard <= path.size()){
            return null;
        }
        double mapCost;
        double pointInPath;
        Point startPoint = path.get(0);


        Point up = new Point(point.x, point.y + 1);
        Point down = new Point(point.x, point.y - 1);
        Point left = new Point(point.x - 1, point.y);
        Point right = new Point(point.x + 1, point.y);

        mapCost = getMapCost(up);
        pointInPath = pointInPath(path, up);
        double upDistance = endPoint.distance(up) * 1000 + mapCost + pointInPath;

        mapCost = getMapCost(down);
        pointInPath = pointInPath(path, down);
        double downDistance = endPoint.distance(down) * 1000 + mapCost + pointInPath;

        mapCost = getMapCost(left);
        pointInPath = pointInPath(path, left);
        double leftDistance = endPoint.distance(left) * 1000 + mapCost + pointInPath;

        mapCost = getMapCost(right);
        pointInPath = pointInPath(path, right);
        double rightDistance = endPoint.distance(right) * 1000 + mapCost + pointInPath;

        if (point.equals(endPoint) || path.contains(endPoint)) {
            return path;
        } else {
            double min = findMinValue(upDistance, downDistance, leftDistance, rightDistance);

            if (upDistance == min) {
                updateMapCost(up,10000);
                path.add(up);
                countPath(up, endPoint, path);
            }
            if (downDistance == min) {
                updateMapCost(down,10000);
                path.add(down);
                countPath(down, endPoint, path);
            }
            if (leftDistance == min) {
                updateMapCost(left,10000);
                path.add(left);
                countPath(left, endPoint, path);
            }
            if (rightDistance == min) {
                updateMapCost(right,10000);
                path.add(right);
                countPath(right, endPoint, path);
            }

            return path;
        }
    }

    private int pointInPath(List path, Point point){
        if( path.contains(point))
        {
            return 500000;
        }
        else {
            return 0;
        }
    }

    private Map<Point, Integer> mapCostGenerate(Point startPoint){
        Map<Point, GuiTileIf> copyBoard = Board.copyBoardValues();

        for (int i = 0; i <= BOARD_WIDTH ; i++) {
            for (int j = 0; j <= BOARD_HIGH ; j++) {
                aStarBoard.put(new Point(i,j),0);
            }
        }

        for (Point key: copyBoard.keySet()
        ) {
            if (Board.getBoard().getTile(key.x, key.y).isCreature() && !startPoint.equals(new Point(key.x, key.y))) {
                aStarBoard.replace(key, Integer.MAX_VALUE);
            }
            if (Board.getBoard().getTile(key.x, key.y).isObstacle()) {
                if (Board.getBoard().getTile(key.x, key.y).getDisplayName().equals("rock")) {
                    aStarBoard.replace(key, obstacleCostRock);
                } else {
                    aStarBoard.replace(key, obstacleCost);
                }
            }
        }
        return aStarBoard;
    }


    private void updateMapCost(Point lastPointInPath, int value){
        Integer old = aStarBoard.get(lastPointInPath);
        old += value;
        aStarBoard.replace(lastPointInPath,old);
    };
    private int getMapCost(Point point){
        Map<Point,Integer> mapCost = aStarBoard;

        if (point.x > BOARD_WIDTH || point.x < 0 || point.y > BOARD_HIGH || point.y < 0) {
            return Integer.MAX_VALUE;
        }
        else {
            return mapCost.get(point);
        }
    }

    private double findMinValue(double a, double b, double c, double d) {
        double subSmall1;
        double subSmall2;

        if(a < b){
            //a is min
            subSmall1 = a;
        } else {
            //b is min or equals
            subSmall1 = b;
        }

        if(c < d){
            //c is min
            subSmall2 = c;
        } else {
            //d is min or equals
            subSmall2 = d;
        }

        if(subSmall1 < subSmall2){
            return subSmall1;
        } else {
            return subSmall2;
        }
    }

    List<Point> removeBadPaths(List<Point> list, Point startPoint, Point endPoint){
        list = list.subList(list.lastIndexOf(startPoint),list.size());
        list.remove(startPoint);
        return list.subList(0,list.indexOf(endPoint) + 1);
    }
}
