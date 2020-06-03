package pl.psi.game;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.HashMap;

@Getter
@Setter
public class BattleMap {
    private String mapName = "New Map";
    private HashMap<Point,String> board;

    public final static int BOARD_WIDTH = 14;
    public final static int BOARD_HIGH = 9;

    @Builder(builderMethodName = "battleMapBuilder")
    public BattleMap(String mapName, HashMap<Point, String> board) {
        this.mapName = mapName;
        this.board = board;
    }

    public BattleMap(){
        board = new HashMap<>();
    }

    //Add & Remove Point to/from board------------------------------------------
    //Not sure about fieldType type so i put String as placeholder
    public void addPointToBoard(Point point, String fieldType){
        if (isPointCorrect(point))
            board.put(point,fieldType);
    }

    public void removePointFromBoard(Point point){
        board.remove(point);
    }

    public void resetMap(){
        mapName = null;
        board = null;
    }

    //Private methods----------------------------------------
    private boolean isPointCorrect(Point p){
        if (p.getX()>13 || p.getX() <2)
            return false;
        return !(p.getY() > 9) && !(p.getY() < 1);
    }
}
