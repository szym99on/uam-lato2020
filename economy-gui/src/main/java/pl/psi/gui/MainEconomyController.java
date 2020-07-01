package pl.psi.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.psi.game.EconomyEngine;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.CreatureStack;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.skills.SkillInfo;
import pl.psi.game.skills.SkillInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainEconomyController {

    @FXML
    public Button buySpellButton;
    @FXML
    public Button buyArtifactButton;
    @FXML
    public Button passTurnButton;
    @FXML
    public Button buySpecialSkillButton;

    @FXML
    public Text gold;
    @FXML
    public VBox creaturesShop;
    @FXML
    public HBox creaturesShopLayout;
    @FXML
    public VBox creaturesShopInside;
    @FXML
    public VBox creaturesShopInside2;
    @FXML
    public Text heroName;
    @FXML
    public Text player;

    @FXML
    private Button buyCreatureButton;

    @FXML
    private VBox spellShop;

    @FXML
    private VBox skillShop;
    @FXML
    public VBox artifactsShop;
    @FXML
    public VBox creatureShop;
    @FXML
    public VBox spellShopInside;
    @FXML
    public VBox spellShopInside2;
    @FXML
    public VBox skillShopInside;
    @FXML
    public VBox skillShopInside2;
    @FXML
    public VBox artifactsShopInside;
    @FXML
    public VBox artifactsShopInside2;

    @FXML
    private URL location;

    @FXML
    public VBox heroSpellsInside;
    @FXML
    public VBox heroSpellsInside2;
    @FXML
    public VBox heroSkillInside;
    @FXML
    public VBox heroSkillInside2;
    @FXML
    public VBox heroArtifactsInside;
    @FXML
    public VBox heroArtifactsInside2;
    @FXML
    public VBox heroCreaturesInside;
    @FXML
    public VBox heroCreaturesInside2;


    @FXML
    private ResourceBundle resources;

    private final EconomyHero economyHero1;
    private final EconomyHero economyHero2;
    private final EconomyEngine economyEngine;
    private final HeroInfo heroInfo1;
    private final HeroInfo heroInfo2;

    public MainEconomyController() {
        new HeroInfoFactory();

        heroInfo1 = showChoiseDialog(1);
        economyHero1 = EconomyHero.builder().aGold(3000).aHeroInfo(heroInfo1).build();

        heroInfo2 = showChoiseDialog(2);
        economyHero2 = EconomyHero.builder().aGold(3000).aHeroInfo(heroInfo2).build();

        economyEngine = new EconomyEngine(economyHero1, economyHero2);
    }
    public MainEconomyController(EconomyHero economyHero1, EconomyHero economyHero2) {

        this.economyHero1 = economyHero1;
        this.heroInfo1 =  economyHero1.getHeroInfo();
        this.economyHero2 = economyHero2;
        this.heroInfo2 =  economyHero2.getHeroInfo();

        economyEngine = new EconomyEngine(economyHero1, economyHero2);
    }

    public HeroInfo showChoiseDialog(int i){
        List<HeroInfo> HeroesInfo = HeroInfoFactory.getAll();
        List<String> HeroesInfoNames = new ArrayList<>();
        for(HeroInfo hero: HeroesInfo)
            HeroesInfoNames.add(hero.getName().toUpperCase()+ " -> attack:"+hero.getAttack()+ " defence:"+hero.getDefence()+ " power:"+hero.getPower()+ " knowledge:"+hero.getKnowledge());

        ChoiceDialog dialog = new ChoiceDialog(HeroesInfoNames.get(0), HeroesInfoNames);
        dialog.initStyle(StageStyle.UNDECORATED);
        for (ButtonType b : dialog.getDialogPane().getButtonTypes()) {
            if(b.getText().equals("Cancel"))
                dialog.getDialogPane().lookupButton(b).setDisable(true);
        }
        dialog.setTitle("Hero choice");
        dialog.setHeaderText(" Player " + i +", please choose your hero");
        dialog.setContentText("Select hero:");
        dialog.showAndWait();
        String name = dialog.getSelectedItem().toString().split(" ->")[0];
        return  HeroInfoFactory.getHeroInfoByName(name.substring(0, 1)+name.substring(1).toLowerCase());
    }

    public void addItemToShop(String itemName, String description, int cost, HBox hbox, String type) {
        Button btn = new Button();
        btn.setTooltip(new Tooltip(description));
        btn.setId(itemName);
        btn.setText(itemName);
        btn.setMinSize(170, 19);
        switch (type) {
            case "Spell":
                btn.setOnAction(this::handleBuySpell);
                if(economyEngine.activeHero.getSpells().contains(SpellBookInfoFactory.getSpell(itemName)))
                    btn.setDisable(true);
                break;
            case "Artifact":
                btn.setOnAction(this::handleBuyArtifact);
                if(economyEngine.activeHero.getArtifacts().contains(ArtifactsInfoFactory.getArtifact(itemName)))
                    btn.setDisable(true);
                break;
            case "Skill":
                btn.setOnAction(this::handleBuySpecialSkill);
                if(economyEngine.activeHero.getSkills().contains(SkillInfoFactory.getSkill(itemName)))
                    btn.setDisable(true);
                break;
        }

        hbox.getChildren().add(btn);
        TextField text = new TextField(cost +"G");
        text.setEditable(false);
        text.setMaxWidth(70);
        text.setMinSize(50, 19);
        text.setId(itemName);
        hbox.getChildren().add(text);
    }

    @FXML
    private void initialize() {
        gold.setText(Integer.toString(economyEngine.activeHero.getGold()));
        if (economyEngine.activeHero.equals(economyHero1))
            player.setText("Player 1");
        else
            player.setText("Player 2");

        heroName.setText((economyEngine.activeHero.getHeroInfo().getName() + " equipment:").toUpperCase());

        int spellvar = 0;
        for (SpellInfo spell : economyEngine.getSpellsAvailableToBuy()) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            if (spellvar < 5)
                spellShopInside.getChildren().add(hbox);
            else
                spellShopInside2.getChildren().add(hbox);

            addItemToShop(spell.getName(), spell.getDescription(), spell.getCost(), hbox, "Spell");
            spellvar++;
        }

        int skillvar = 0;
        for (SkillInfo skill : economyEngine.getSkillsAvailableToBuy()) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            if (skillvar < 5)
                skillShopInside.getChildren().add(hbox);
            else
                skillShopInside2.getChildren().add(hbox);

            addItemToShop(skill.getName(), skill.getDescription(), skill.getCost(), hbox, "Skill");
            skillvar++;
        }

        int artvar = 0;
        for (ArtifactInfo artifact : economyEngine.getArtifactsAvailableToBuy()) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            if (artvar < 5)
                artifactsShopInside.getChildren().add(hbox);
            else
                artifactsShopInside2.getChildren().add(hbox);

            addItemToShop(artifact.getName(), artifact.getDescription(), artifact.getCost(), hbox, "Artifact");
            artvar++;
        }

        int creaturevar = 0;
        for (CreatureStack creature : economyEngine.getCreaturesAvailableToBuy()) {
            HBox hbox = new HBox();
            hbox.setSpacing(0);
            if (creaturevar < 5)
                creaturesShopInside.getChildren().add(hbox);
            else
                creaturesShopInside2.getChildren().add(hbox);

            Button btn = new Button();
            btn.setId(creature.getName());
            btn.setText(creature.getName());
            btn.setMinSize(170, 19);
            btn.setOnAction(this::handleBuyCreature);

            TextField amount = new TextField(Integer.toString(creature.getCreaturesCount()));
            amount.setEditable(false);
            amount.setMaxWidth(35);
            amount.setMinSize(25, 19);
            amount.setId("amount:"+creature.getName());

            TextField text = new TextField(creature.getCost() +"G");
            text.setMaxWidth(48);
            text.setMinSize(35, 19);
            hbox.getChildren().add(btn);
            hbox.getChildren().add(amount);
            hbox.getChildren().add(text);
            creaturevar++;
            if(creature.getCreaturesCount() == 0)
                btn.setDisable(true);
        }
        initializeEq();
    }


    public void initializeEq() {
        heroSpellsInside.getChildren().clear();
        heroSpellsInside2.getChildren().clear();
        int spellvarhero = 0;
        for (SpellInfo spell : economyEngine.activeHero.getSpells()) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            if (spellvarhero < 5)
                heroSpellsInside.getChildren().add(hbox);
            else
                heroSpellsInside2.getChildren().add(hbox);
            addItemToEq(spell.getName(), spell.getCost(), hbox, "Spell");
            spellvarhero++;
        }

        heroArtifactsInside.getChildren().clear();
        heroArtifactsInside2.getChildren().clear();
        int artvarhero = 0;
        for (ArtifactInfo artifact : economyEngine.activeHero.getArtifacts()) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            if (artvarhero < 5)
                heroArtifactsInside.getChildren().add(hbox);
            else
                heroArtifactsInside2.getChildren().add(hbox);

            addItemToEq(artifact.getName(), artifact.getCost(), hbox, "Artifact");
            artvarhero++;
        }

        heroSkillInside.getChildren().clear();
        heroSkillInside2.getChildren().clear();
        int skillvarhero = 0;
        for (SkillInfo skill : economyEngine.activeHero.getSkills()) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            if (skillvarhero < 5)
                heroSkillInside.getChildren().add(hbox);
            else
                heroSkillInside2.getChildren().add(hbox);

            addItemToEq(skill.getName(), skill.getCost(),hbox, "Skill");
            skillvarhero++;

        }
        heroCreaturesInside.getChildren().clear();
        heroCreaturesInside2.getChildren().clear();
        int creaturevarhero = 0;
        for (CreatureStack creature : economyEngine.activeHero.getCreatures()) {
            HBox hbox = new HBox();
            hbox.setSpacing(0);
            if (creaturevarhero < 5) {
                heroCreaturesInside.getChildren().add(hbox);
            } else {
                heroCreaturesInside2.getChildren().add(hbox);
            }
            Button btn = new Button();
            btn.setId(creature.getName());
            btn.setText(creature.getName());
            btn.setMinSize(170, 19);
            btn.setOnAction(this::handleSellCreature);

            TextField amount = new TextField(Integer.toString(creature.getCreaturesCount()));
            amount.setEditable(false);
            amount.setMaxWidth(35);
            amount.setMinSize(25, 19);
            amount.setId("amount:"+creature.getName());

            TextField text = new TextField((int) (creature.getCost() * 0.75) +"G");
            text.setMaxWidth(48);
            text.setMinSize(35, 19);
            hbox.getChildren().add(btn);
            hbox.getChildren().add(amount);
            hbox.getChildren().add(text);
            creaturevarhero++;

        }
    }

    public void addItemToEq(String name, int cost, HBox hbox, String type) {
        Button btn = new Button();
        btn.setId(name);
        btn.setText(name);
        btn.setMinSize(170, 19);
        hbox.getChildren().add(btn);
        TextField text = new TextField((int) (cost * 0.75) +"G");
        text.setEditable(false);
        text.setMaxWidth(70);
        text.setMinSize(50, 19);
        text.setId(name);


        switch(type) {
            case "Spell":
                btn.setOnAction(this::handleSellSpell);
                hbox.getChildren().add(text);
                break;

            case "Artifact":
                btn.setOnAction(this::handleSellArtifact);
                hbox.getChildren().add(text);
                break;
        }
    }



    public void handleSellArtifact(ActionEvent actionEvent) {
        handleSell(actionEvent, "Artifact");
    }

    public void handleSellSpell(ActionEvent actionEvent) {
        handleSell(actionEvent, "Spell");
    }

    public void handleSellCreature(ActionEvent actionEvent) {


        CreatureInfo creatureInfo = economyEngine.activeHero.getHeroInfo().getFractionFactory().getCreature(((Button) actionEvent.getSource()).getId());
        CreatureStack stackFromHero = null;
        for(CreatureStack c: economyEngine.activeHero.getCreatures()){
            if(c.getCreatureInfo().equals(creatureInfo))
                stackFromHero = c;
        }

        if(stackFromHero != null) {

            Optional<Integer> result = showDialogToSellCreatures(stackFromHero.getName(), stackFromHero.getCreaturesCount() );
            if (result.isPresent()) {
                economyEngine.activeHero.sellCreature(stackFromHero.getCreatureInfo(), result.get());
                refreshGui();
            }
        }
    }


    public void handleSell(ActionEvent actionEvent, String type) {
        economyEngine.sellItem(((Button) actionEvent.getSource()).getId(), type);
        refreshGui();

    }

    public void refreshGui(){
        clearAll();
        initialize();
        initializeEq();
    }
    public void handlePassTurn(ActionEvent actionEvent) {
        economyEngine.endTurn();
        refreshGui();
        if(economyEngine.activeHero == economyHero1){
            try {


                FXMLLoader loader = new FXMLLoader();
                URL fxmlLocation = getClass().getResource("/main-battle.fxml");
                loader.setLocation(fxmlLocation);
                MainBattleController mainBattleController = new MainBattleController(economyHero1, economyHero2);
                loader.setController(mainBattleController);
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);;
                stage.setTitle("Heroes 3");

                stage.showAndWait();

            } catch (Exception e) {
                if (e.getMessage() == "No value present") {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("DRAW!!!");
                    alert.show();
                }
            }
        }
        refreshGui();
    }



    public void clearAll(){
        List<VBox> allVBoxes = new ArrayList<>();
        allVBoxes.add(heroSpellsInside);
        allVBoxes.add(heroSpellsInside2);
        allVBoxes.add(heroSkillInside);
        allVBoxes.add(heroSkillInside2);
        allVBoxes.add(heroArtifactsInside);
        allVBoxes.add(heroArtifactsInside2);
        allVBoxes.add(heroCreaturesInside);
        allVBoxes.add(heroCreaturesInside2);
        allVBoxes.add(spellShopInside);
        allVBoxes.add(spellShopInside2);
        allVBoxes.add(skillShopInside);
        allVBoxes.add(skillShopInside2);
        allVBoxes.add(artifactsShopInside);
        allVBoxes.add(artifactsShopInside2);
        allVBoxes.add(creaturesShopInside);
        allVBoxes.add(creaturesShopInside2);
        for(VBox v: allVBoxes){
            v.getChildren().clear();
        }
    }

    public void showAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("You don't have enough money!");
        alert.show();
    }

    public void hendleBuy(ActionEvent actionEvent, String type){

        switch(type) {
            case "Spell":
                String spellName = ((Button) actionEvent.getSource()).getId();
                SpellInfo spell = SpellBookInfoFactory.getSpell(spellName);

                if (economyEngine.activeHero.buySpell(spell)) {
                    ((Button) actionEvent.getSource()).setDisable(true);
                } else {
                    showAlert();
                }
                break;

            case "Artifact":
                String artifactName = ((Button) actionEvent.getSource()).getId();
                ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(artifactName);

                if (economyEngine.activeHero.buyArtifact(artifact)) {
                    ((Button) actionEvent.getSource()).setDisable(true);
                }

                break;
            case "Skill":
                String skillName = ((Button) actionEvent.getSource()).getId();
                SkillInfo skill = SkillInfoFactory.getSkill(skillName);

                if (economyEngine.activeHero.buySkill(skill)) {
                    ((Button) actionEvent.getSource()).setDisable(true);
                } else {
                    showAlert();
                }
                break;
        }

        initializeEq();
        gold.setText(Integer.toString(economyEngine.activeHero.getGold()));
    }


    public void handleBuySpell(ActionEvent actionEvent) {
        hendleBuy(actionEvent, "Spell");
    }


    public void handleBuyArtifact(ActionEvent actionEvent) {
        hendleBuy(actionEvent, "Artifact");
    }


    public void handleBuySpecialSkill(ActionEvent actionEvent) {
        hendleBuy(actionEvent, "Skill");
    }

    private void handleBuyCreature(ActionEvent actionEvent) {

        FractionsInfoAbstractFactory creatureFactory = economyEngine.activeHero.getHeroInfo().getFractionFactory();
        String creatureName = ((Button) actionEvent.getSource()).getId();
        CreatureInfo creature = creatureFactory.getCreature(creatureName);
        CreatureStack creatureStack = null;
        for (CreatureStack c : economyEngine.getCreaturesAvailableToBuy()) {
            if (c.getCreatureInfo().equals(creature))
                creatureStack = c;
        }
        if (creatureStack != null){
            Optional<Integer> result = showDialogToBuyCreatures(creatureStack.getName(), creatureStack.getCreaturesCount());

            if (result.isPresent()) {

                if (economyEngine.activeHero.buyCreature(creature, result.get())) {
                    creatureStack.setCreaturesCount(creatureStack.getCreaturesCount() - result.get());
                    refreshGui();
                } else {
                    showAlert();
                }
            }
        }
    }
    private Optional<Integer> showDialogToBuyCreatures(String name, int max){
        return showDialogToCreatures(name, max, "buy");
    }

    private Optional<Integer> showDialogToSellCreatures(String name, int max){
        return showDialogToCreatures(name, max, "sell");
    }

    private Optional<Integer> showDialogToCreatures(String name, int max, String type){
        List<Integer> choices = new ArrayList<>();
            for(int i=1; i<=max; i++)
                choices.add(i);

        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(1, choices);
        dialog.setTitle("");
        dialog.setHeaderText("How much "+name+" you want to "+type+"?");
        dialog.setContentText("Choose number:");


        Optional<Integer> result = dialog.showAndWait();
        return result;
    }

}
