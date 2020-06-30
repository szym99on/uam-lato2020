package pl.psi.gui.states;

import pl.psi.game.GameEngine;
import pl.psi.game.move.GuiTileIf;
import pl.psi.gui.SpellBookGui;
import pl.psi.gui.tiles.SpellCastPossibleTileFactoryDecorator;
import pl.psi.gui.tiles.*;

import java.awt.*;

public class SpellCastState implements StateMap {
    private GameEngine gameEngine;


    @Override
    public MapTile createTile(int aX, int aY, GameEngine aGameEngine) {
        gameEngine = aGameEngine;

        AbstractTileFactory factory = new DefaultTileFactory();
        GuiTileIf somethingToRender = gameEngine.getByPoint(aX, aY);

        if (somethingToRender != null) {
            factory = new ObjectTileFactory(factory, somethingToRender, gameEngine);
        }

        if (gameEngine.getActiveCreature().getKey().equals(new Point(aX, aY))) {
            factory = new ActiveObjectTileFactoryDecorator(factory);
        }
        if(gameEngine.spellCastPossible(aX,aY,SpellBookGui.selectedSpell))
        factory = new SpellCastPossibleTileFactoryDecorator(factory, aX, aY, gameEngine);


        return factory.generateTile();
    }
}
