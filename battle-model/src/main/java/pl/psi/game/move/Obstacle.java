package pl.psi.game.move;

import lombok.Builder;

import java.awt.*;

public class Obstacle implements GuiTileIf{

    private final String type;
    private final int attack;
    private final int reduceMoveRange;
    private final boolean isEndingMove;

    @Builder
    public Obstacle(String aType, int aAttack, int aReduceMoveRange, boolean aIsEndingMove){
        type = aType;
        attack = aAttack;
        reduceMoveRange = aReduceMoveRange;
        isEndingMove = aIsEndingMove;
    }


    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public boolean isCreature() {
        return false;
    }


}
