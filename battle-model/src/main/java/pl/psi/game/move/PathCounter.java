package pl.psi.game.move;

import pl.psi.game.Board;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static pl.psi.game.Board.BOARD_HIGH;
import static pl.psi.game.Board.BOARD_WIDTH;


public class PathCounter {

    private int obstacleCost;

    public PathCounter(String type) {
       switch (type) {
           case "fly":
               obstacleCost = 0;
               break;
           case "walk":
               obstacleCost = 200;
               break;
           default:
               throw new IllegalArgumentException("Creature doesn't have such a strategy!");
       }
    }



    List countPath(Point point, Point endPoint, List path){

        Point up = new Point(point.x,point.y + 1);
        Point down = new Point(point.x,point.y - 1);
        Point left = new Point(point.x - 1,point.y);
        Point right = new Point(point.x + 1,point.y);

        double upDistance = endPoint.distance(up) * 1000  + getMapCost(up) + pointInPath(path,up);
        double downDistance = endPoint.distance(down) * 1000 + getMapCost(down) + pointInPath(path,down);
        double leftDistance = endPoint.distance(left) * 1000 + getMapCost(left) + pointInPath(path,left);
        double rightDistance = endPoint.distance(right) * 1000 + getMapCost(right) + pointInPath(path,right);

        //TODO this is ugly, but works. Now I don't now how do it better
        if(point.equals(endPoint)){
            return path;
        } else

        if (upDistance <= downDistance && upDistance <= leftDistance && upDistance <= rightDistance) {
            path.add(up);
            countPath(up, endPoint, path);
        }
        if (downDistance < upDistance && downDistance < leftDistance && downDistance < rightDistance) {
            path.add(down);
            countPath(down, endPoint, path);
        }
        if (leftDistance < upDistance && leftDistance < downDistance && leftDistance < rightDistance) {
            path.add(left);
            countPath(left, endPoint, path);
        }
        if (rightDistance < upDistance && rightDistance < downDistance && rightDistance < leftDistance) {
            path.add(right);
            countPath(right, endPoint, path);
        }

        return path;
    }

    private int pointInPath(List path, Point point){
        if( path.contains(point))
        {
            return Integer.MAX_VALUE;
        }
        else {
            return 0;
        }
    }

    private Map<Point, Integer> mapCostGenerate(){
        Map<Point, GuiTileIf> copyBoard = Board.copyBoardValues();
        Map<Point, Integer> aStarBoard = new HashMap<>();

        for (int i = 0; i <= BOARD_WIDTH ; i++) {
            for (int j = 0; j <= BOARD_HIGH ; j++) {
                aStarBoard.put(new Point(i,j),0);
            }
        }

        for (Point key: copyBoard.keySet()
        ) {
            if(Board.getBoard().getTile(key.x, key.y).isCreature()){
                aStarBoard.replace(key,Integer.MAX_VALUE);
            } else {
                //aStarBoard.replace(key,200);
                aStarBoard.replace(key,200);;
            }
        }
        return aStarBoard;

    }

    private int getMapCost(Point point){
        Map<Point,Integer> mapCost = mapCostGenerate();

        if (point.x > BOARD_WIDTH || point.x < 0 || point.y > BOARD_HIGH || point.y < 0) {
            return Integer.MAX_VALUE;
        }
        else {
            return mapCost.get(point);
        }
    }


}
