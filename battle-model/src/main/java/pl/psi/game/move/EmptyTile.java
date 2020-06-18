package pl.psi.game.move;

import java.awt.*;

public class EmptyTile implements GuiTileIf{

    private final Point point;

    @Override
    public String getDisplayName() {
        return "empty tile";
    }

    @Override
    public boolean isCreature() {
        return false;
    }


    public EmptyTile(Point point){
    this.point = point;
    }

    public Point getPoint(){
        return point;
    }

    @Override
    public int weight() {
        return 1;
    }

    @Override
    public boolean isObstacle() {
        return false;
    }


}
