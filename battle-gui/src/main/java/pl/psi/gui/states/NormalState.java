package pl.psi.gui.states;

import pl.psi.game.GameEngine;
import pl.psi.game.move.GuiTileIf;
import pl.psi.gui.states.StateMap;
import pl.psi.gui.tiles.*;

import java.awt.*;
import java.util.List;

public class NormalState implements StateMap {


    private GameEngine gameEngine;

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

        if (gameEngine.isAttackPossible(aX, aY)) {
            factory = new AttackPossibleTileFactoryDecorator(factory, aX, aY, gameEngine);
        }

        if (gameEngine.isMoveAllowed(aX, aY)) {
            factory = new MovePossibleTileFactoryDecorator(factory, aX, aY, gameEngine);
        }

        if (gameEngine.isPointInPath(aX,aY)){
            factory = new MovePathTileFactoryDecorator(factory, aX, aY, gameEngine);
        }
        return factory.generateTile();}
    }

