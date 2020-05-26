package pl.psi.game.move;

import lombok.Builder;

public class MoveInfo {

    
    private final String groundType;
    private final boolean diagonalMove;


    @Builder
    public MoveInfo(boolean aDiagonalMove,String aGroundType){
        diagonalMove = aDiagonalMove;
        groundType = aGroundType;
    }
}
