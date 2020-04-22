package pl.psi.game.move;

public class Obstacle implements GuiTileIf {

    @Override
    public String getName() {
        return "X";
    }

    @Override
    public boolean isCreature() {
        return false;
    }
}
