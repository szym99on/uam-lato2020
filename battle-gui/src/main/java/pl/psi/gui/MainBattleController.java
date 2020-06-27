package pl.psi.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.psi.game.GameEngine;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.gui.states.NormalState;
import pl.psi.gui.states.StateMap;

public class MainBattleController {
private static final Logger LOG = LogManager.getLogger(MainBattleController.class);
    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    @FXML
    private Button spellButton;

    private final Hero hero1;
    private final Hero hero2;
    private final GameEngine gameEngine;
    @Setter
    private StateMap stateMap = new NormalState();

    public MainBattleController() {
        System.out.println( "Hello, user!" );
        LOG.trace("We've just greeted the user!");
        LOG.debug("We've just greeted the user!");
        LOG.info("We've just greeted the user!");
        LOG.warn("We've just greeted the user!");
        LOG.error("We've just greeted the user!");
        LOG.fatal("We've just greeted the user!");
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
            stateMap = new NormalState();
        });
        spellButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

            SpellBookGui spellBookGui = new SpellBookGui(gameEngine.getActiveHero(), stateMap,this);

            //zrobione na szybko do pokazania innym developerom
            //trzeba zrobic stateMap zaleznie od typu spella JESZCZE NIE ZAIMPLEMENTOWANE!!
            // coś w stylu instance of :( biedne jednorożce
//            stateMap = new SummonUnitsState();
//            refreshGui();

        });

        gameEngine.addObserver((e) -> Platform.runLater(this::refreshGui));
    }

    protected void refreshGui() {
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
