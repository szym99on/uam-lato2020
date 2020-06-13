package pl.psi.gui.states;

import pl.psi.game.GameEngine;
import pl.psi.game.move.GuiTileIf;
import pl.psi.game.spellbook.Spell;
import pl.psi.gui.tiles.SummonUnitsPossibleTileFactoryDecorator;
import pl.psi.gui.tiles.*;

import java.awt.*;

public class SummonUnitsState implements StateMap {
    private GameEngine gameEngine;
    private Spell spell;

    @Override
    public MapTile createTile(int aX, int aY, GameEngine aGameEngine) {
        gameEngine = aGameEngine;

        AbstractTileFactory factory = new DefaultTileFactory();
        GuiTileIf somethingToRender = gameEngine.getByPoint(aX, aY);

        if (somethingToRender != null) {
            factory = new ObjectTileFactory(factory, somethingToRender);
        }

        if (gameEngine.getActiveCreature().getKey().equals(new Point(aX, aY))) {
            factory = new ActiveObjectTileFactoryDecorator(factory);
        }
        factory = new SummonUnitsPossibleTileFactoryDecorator(factory, aX, aY, gameEngine);


        return factory.generateTile();
    }
}
