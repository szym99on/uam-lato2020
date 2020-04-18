package pl.psi.game;

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
