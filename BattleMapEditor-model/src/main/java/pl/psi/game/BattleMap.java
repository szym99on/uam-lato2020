package pl.psi.game;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Map;

@Getter
@Setter
public class BattleMap {
    private String mapName;
    private Map<Point,String> board;

    public final static int BOARD_WIDTH = 14;
    public final static int BOARD_HIGH = 9;

    @Builder(builderMethodName = "battleMapBuilder")
    public BattleMap(String mapName, Map<Point, String> board, String mapName1) {
        this.mapName = mapName;
        this.board = board;
        this.mapName = mapName1;
    }

    //Not sure about fieldType type
    public void addPointToBoard(Point point, String fieldType){
        if (isPointCorrect(point))
            board.put(point,fieldType);
    }

    //not sure what happend if we try remove non existin point
    public void removePointFromBoard(Point point){
        board.remove(point);
    }

    public void resetMap(){
        mapName = null;
        board = null;
    }

    private boolean isPointCorrect(Point p){
        if (p.getX()>13 || p.getX() <2)
            return false;
        if (p.getY()>9 || p.getY()<1)
            return false;
        return true;
    }
}
