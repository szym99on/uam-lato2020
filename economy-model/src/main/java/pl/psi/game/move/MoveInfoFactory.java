package pl.psi.game.move;

import java.util.ArrayList;

public class MoveInfoFactory {

    public enum AirMagic{
        BASIC,
        ADVANCE,
        EXPERT
    }

    public enum Pathfinding{
        BASIC,
        ADVANCE,
        EXPERT
    }

    private ArrayList<Object[]> floors = new ArrayList<>() {
        {
            add(new Object[]{"dirt",100});
            add(new Object[]{"grass",100});
            add(new Object[]{"lava",100});
            add(new Object[]{"subterranean",100});
            add(new Object[]{"water",100});
            add(new Object[]{"highlands",100});
            add(new Object[]{"rough",125});
            add(new Object[]{"wasteland",125});
            add(new Object[]{"sand",150});
            add(new Object[]{"snow",150});
            add(new Object[]{"swamp",175});
            add(new Object[]{"dirtRoad",75});
            add(new Object[]{"gravelRoad",65});
            add(new Object[]{"cobblestoneroad",50});
            add(new Object[]{"favorablewinds",66});
        }
    };

    public ArrayList<MoveInfo> getMoveList() {
        return moveList;
    }

    private ArrayList<MoveInfo> moveList = new ArrayList<>();
    {
        for (Object[] floor : floors
        ) {
            moveList.add(new MoveInfo((String)floor[0],(int)floor[1]));
        }
    }
}
