package pl.psi.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.CreatureStack;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.gui.states.NormalState;
import pl.psi.gui.states.StateMap;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
    private final EconomyHero economyHero1;
    private final EconomyHero economyHero2;
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
        this.economyHero1 = init.getH1();
        this.economyHero2 = init.getH2();
        hero1 = HeroEcoBattleConverter.convert(economyHero1);
        hero2 = HeroEcoBattleConverter.convert(economyHero2);

        gameEngine = new GameEngine(hero1, hero2);
    }

    public MainBattleController(EconomyHero economyHero1, EconomyHero economyHero2) {
        this.economyHero1 = economyHero1;
        this.economyHero2 = economyHero2;
        hero1 = HeroEcoBattleConverter.convert(economyHero1);
        hero2 = HeroEcoBattleConverter.convert(economyHero2);

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
        gameEngine.addObserver(GameEngine.SPELL_CASTED,(e) ->{
            stateMap = new NormalState();
            refreshGui();
        });
    }

    protected void refreshGui() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                createTile(i, j);
            }
        }
        if (gameEngine.isFightEnd())
            endFight();
    }
    public void setEcoHeroCreaturesToBattleHero(EconomyHero economyHero, Hero hero) {
        List<CreatureStack> toremove = new ArrayList<>();
        for (Creature c : hero.getCreatures()) {
            for (CreatureStack creatureStack : economyHero.getCreatures()) {
                if (c.getName().equals(creatureStack.getName())) {
                    if (c.getAmount() == 0)
                        toremove.add(creatureStack);
                    else
                        creatureStack.setCreaturesCount(c.getAmount());

                }
            }
        }
        for (CreatureStack creatureStack : toremove) {
            economyHero.getCreatures().remove(creatureStack);
        }
    }

    public void endFight(){

        setEcoHeroCreaturesToBattleHero(economyHero1, hero1);
        setEcoHeroCreaturesToBattleHero(economyHero2, hero2);

        if (gameEngine.didHeroLose(hero1))
            showAlert("Player 2");

        if (gameEngine.didHeroLose(hero2))
            showAlert("Player 1");

        closeBattleWindow();




    }

    public void showAlert(String hero){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(hero + " WON !!");
        alert.showAndWait();
    }

    private void closeBattleWindow() {
        Stage battleStage = (Stage) passButton.getScene().getWindow();
        battleStage.close();
    }

    private void createTile(int aX, int aY) {
        gridMap.add(stateMap.createTile(aX, aY, gameEngine), aX, aY);
    }
}
