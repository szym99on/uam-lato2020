package pl.psi.gui;

import javafx.scene.layout.GridPane;
import pl.psi.game.GameEngine;
import pl.psi.gui.tiles.MapTile;

public interface  StateMap {
    MapTile createTile(int aX, int aY, GameEngine aGameEngine);
}
