package pl.psi.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

        heroInfo1 = showChoseDialog(1);
        economyHero1 = EconomyHero.builder().aGold(3000).aHeroInfo(heroInfo1).build();

        heroInfo2 = showChoseDialog(2);
        economyHero2 = EconomyHero.builder().aGold(3000).aHeroInfo(heroInfo2).build();

        economyEngine = new EconomyEngine(economyHero1, economyHero2);
    }

    public HeroInfo showChoseDialog(int i){
        List<HeroInfo> HeroesInfo = HeroInfoFactory.getAll();
        List<String> HeroesInfoNames = new ArrayList<>();
        for(HeroInfo hero: HeroesInfo)
            HeroesInfoNames.add(hero.getName());

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
        return  HeroInfoFactory.getHeroInfoByName(dialog.getSelectedItem().toString());
    }

    public void addItemToShop(String itemName, int cost, HBox hbox, String type) {
        Button btn = new Button();
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
            case "Creature":
                btn.setOnAction(this::handleBuyCreature);

                break;
        }

        hbox.getChildren().add(btn);
        TextField text = new TextField(Integer.toString(cost));
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

            addItemToShop(spell.getName(), spell.getCost(), hbox, "Spell");
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

            addItemToShop(skill.getName(), skill.getCost(), hbox, "Skill");
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

            addItemToShop(artifact.getName(), artifact.getCost(), hbox, "Artifact");
            artvar++;
        }

        int creaturevar = 0;
        for (CreatureStack creature : economyEngine.getCreaturesAvailableToBuy()) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            if (creaturevar < 5)
                creaturesShopInside.getChildren().add(hbox);
            else
                creaturesShopInside2.getChildren().add(hbox);

            addItemToShop(creature.getName(), creature.getCost(), hbox, "Creature");
            creaturevar++;
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
            addItemToEq(spell.getName(), spell.getCost(), hbox);
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

            addItemToEq(artifact.getName(), artifact.getCost(), hbox);
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

            addItemToEq(skill.getName(), skill.getCost(),hbox);
            skillvarhero++;

        }
//        heroCreaturesInside.getChildren().clear();
//        heroCreaturesInside.getChildren().clear();
//        int creaturevarhero = 0;
//        List<CreatureStack> herocreatures = economyEngine.activeHero.getCreatures();
//        for (CreatureStack creature : herocreatures) {
//            if (creaturevarhero < 5) {
//                HBox hbox = new HBox();
//                hbox.setSpacing(10);
//                heroSkillInside.getChildren().add(hbox);
//                addItemToEq(creature.getName(), creature.getCost(), hbox);
//                creaturevarhero++;
//
//            } else {
//                HBox hbox = new HBox();
//                hbox.setSpacing(10);
//                heroSkillInside2.getChildren().add(hbox);
//                addItemToEq(creature.getName(), creature.getCost(), hbox);
//            }
//
//        }
    }

    public void addItemToEq(String name, int cost, HBox hbox) {
        Button btn = new Button();
        btn.setId(name);
        btn.setText(name);
        btn.setMinSize(170, 19);
        hbox.getChildren().add(btn);
        TextField text = new TextField(String.valueOf(cost));
        text.setEditable(false);
        text.setMaxWidth(70);
        text.setMinSize(50, 19);
        text.setId(name);
        hbox.getChildren().add(text);
    }

    public void handlePassTurn(ActionEvent actionEvent) {
        economyEngine.endTurn();
        clearAll();
        initialize();
        initializeEq();
    }

    public void clearAll(){
        heroSpellsInside.getChildren().clear();
        heroSpellsInside2.getChildren().clear();
        heroSkillInside.getChildren().clear();
        heroSkillInside2.getChildren().clear();
        heroArtifactsInside.getChildren().clear();
        heroArtifactsInside2.getChildren().clear();
        heroCreaturesInside.getChildren().clear();
        heroCreaturesInside2.getChildren().clear();
        spellShopInside.getChildren().clear();
        spellShopInside2.getChildren().clear();
        skillShopInside.getChildren().clear();
        skillShopInside2.getChildren().clear();
        artifactsShopInside.getChildren().clear();
        artifactsShopInside2.getChildren().clear();
        creaturesShopInside.getChildren().clear();
        creaturesShopInside2.getChildren().clear();

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
//        System.out.println("Clicked buy creature button;");
//        System.out.println("ID is: ");
//        System.out.println(((Button) actionEvent.getSource()).getId());
//        String creatureName = ((Button) actionEvent.getSource()).getId();
//        CreatureInfo creature = FractionsInfoAbstractFactory.getCreature(creatureName);
//        System.out.println("Artifact is:");
//        System.out.println(creature.getName());
//
//        if (economyEngine.activeHero.buyCreature(creature)) {
//
//            System.out.println("Creature bought");
//            //gold.setText(String.valueOf(Integer.parseInt(gold.getText()) - spell.getCost()));
//            artifactsShopInside.getChildren().remove(buyArtifactButton);
//            artifactsShopInside2.getChildren().remove(buyArtifactButton);
//            initializeEq();
//            gold.setText(Integer.toString(economyEngine.activeHero.getGold()));
//        } else {
//            System.out.println("Couldn't buy artifact");
//
//        }
    }

}
