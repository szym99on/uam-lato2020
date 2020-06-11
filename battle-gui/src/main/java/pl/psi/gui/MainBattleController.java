package pl.psi.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import pl.psi.game.GameEngine;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.gui.states.NormalState;
import pl.psi.gui.states.StateMap;

public class MainBattleController {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    @FXML
    private Button spellButton;

    private final Hero hero1;
    private final Hero hero2;
    private final GameEngine gameEngine;
    private StateMap stateMap = new NormalState();

    public MainBattleController() {
//        ArtifactInitializer init = new ArtifactInitializer();
        SpellInitializer init = new SpellInitializer();

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
        spellButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            // na razie tylko jeden heroes
            SpellBookGui spellBookGui = new SpellBookGui(hero1, stateMap);

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
        gridMap.add(stateMap.createTile(aX, aY, gameEngine), aX, aY);
    }
}
