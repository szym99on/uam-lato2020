package pl.psi.game.move;

import java.awt.*;

public interface ObstacleIf extends GuiTileIf {

    Point getPoint();
    boolean isPassable();

}
