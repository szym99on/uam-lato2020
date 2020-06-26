package pl.psi.gui.tiles;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.psi.game.GameEngine;

import java.awt.*;

public class MovePathTileFactoryDecorator  extends AbstractTileFactory {

    private Point location;
    private GameEngine engine;

    public MovePathTileFactoryDecorator(AbstractTileFactory aTileFactory, int aX, int aY, GameEngine aEngine) {
        super(aTileFactory);
        location = new Point(aX,aY);
        engine = aEngine;
    }

    @Override
    public MapTile generateTile() {
        MapTile tile = getDecorated().generateTile();
        tile.setBackground(Color.DARKGREY);
        tile.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> engine.getMovePath(location.x,location.y));
        return tile;
    }
}
