package pl.psi.gui;

import com.google.common.collect.Range;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.move.GuiTileIf;
import pl.psi.gui.tiles.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MainBattleController {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    private final Hero hero1;
    private final Hero hero2;
    private final GameEngine gameEngine;

    public MainBattleController() {
        ArtifactInitializer init = new ArtifactInitializer();
//        SpellInitializer init = new SpellInitializer();

        hero1 = HeroEcoBattleConverter.convert(init.getH1());
        hero2 = HeroEcoBattleConverter.convert(init.getH2());

        gameEngine = new GameEngine(hero1, hero2);
    }

    @FXML
    private void initialize() {
        refreshGui();
        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            gameEngine.pass();
        });

        gameEngine.addObserver((e) -> Platform.runLater(this::refreshGui));
    }

    private void refreshGui() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                createTile(i, j);
            }
        }
    }

    private void createTile(int aX, int aY) {
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

        gridMap.add(factory.generateTile(), aX, aY);
    }
}
