package pl.psi.game.move;

import lombok.Builder;

import java.awt.*;

public class Obstacle implements GuiTileIf{

//    private final String type;
//    private final int attack;
//    private final Point point;

//    @Builder
//    public Obstacle(String type, int attack, Point point){
//        this.type = type;
//        this.attack = attack;
//        this.point = point;
//    }


    @Override
    public String getDisplayName() {
        // return type;
        return "X";
    }

    @Override
    public boolean isCreature() {
        return false;
    }


}
