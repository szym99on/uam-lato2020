package pl.psi.gui.tiles;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.psi.game.GameEngine;
import pl.psi.game.spellbook.Spell;
import pl.psi.gui.SpellBookGui;
import pl.psi.gui.tiles.AbstractTileFactory;

import java.awt.*;

public class SummonUnitsPossibleTileFactoryDecorator extends AbstractTileFactory {

    private Point location;
    private GameEngine engine;
    private Spell selectedSpell;

    public SummonUnitsPossibleTileFactoryDecorator(AbstractTileFactory aDecorated, int aX, int aY, GameEngine aEngine) {
        super(aDecorated);
        engine = aEngine;
        location = new Point(aX,aY);

    }


    @Override
    public MapTile generateTile() {
        MapTile tile = getDecorated().generateTile();
        tile.setBackground(Color.GREY);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> engine.castSpell(location.x, location.y, SpellBookGui.selectedSpell));
        return tile;
    }
}
