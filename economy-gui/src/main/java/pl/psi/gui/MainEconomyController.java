package pl.psi.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pl.psi.game.EconomyEngine;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.skills.SkillInfo;
import pl.psi.game.skills.SkillInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.net.URL;
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
    public VBox creatureShopInside;
    @FXML
    public VBox creatureShopInside2;
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

    public MainEconomyController() {
        economyHero1 = EconomyHero.builder().aGold(3000).build();
        economyHero2 = EconomyHero.builder().aGold(3000).build();
        economyEngine = new EconomyEngine(economyHero1, economyHero2);
    }


    public void addItemToShop(String itemName, int cost, HBox hbox, String type) {
        String buying = "handleBuy" + type;
        Button btn = new Button();
        btn.setId(itemName);
        btn.setText(itemName);
        btn.setMinSize(170, 30);
        switch (type) {
            case "Spell":
                btn.setOnAction(this::handleBuySpell);
                break;
            case "Artifact":
                btn.setOnAction(this::handleBuyArtifact);
                break;
            case "Skill":
                btn.setOnAction(this::handleBuySpecialSkill);

                break;
            case "Creature":
                btn.setOnAction(this::handleBuyCreature);

                break;
        }

        hbox.getChildren().add(btn);
        TextField text = new TextField(Integer.toString(cost));
        text.setEditable(false);
        text.setMaxWidth(70);
        text.setMinSize(50, 30);
        text.setId(itemName);
        hbox.getChildren().add(text);
    }

    @FXML
    private void initialize() {

        gold.setText(Integer.toString(economyEngine.activeHero.getGold()));
        int spellvar = 0;
        List<SpellInfo> spells = economyEngine.getSpellsAvailableToBuy();
        for (SpellInfo spell : spells) {

            if (spellvar < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                spellShopInside.getChildren().add(hbox);
                addItemToShop(spell.getName(), spell.getCost(), hbox, "Spell");
                spellvar++;

            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                spellShopInside2.getChildren().add(hbox);
                addItemToShop(spell.getName(), spell.getCost(), hbox, "Spell");
            }

        }
        int skillvar = 0;
        List<SkillInfo> skills = economyEngine.getSkillsAvailableToBuy();
        for (SkillInfo skill : skills) {
            if (skillvar < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                skillShopInside.getChildren().add(hbox);
                addItemToShop(skill.getName(), skill.getCost(), hbox, "Skill");
                skillvar++;
            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                skillShopInside2.getChildren().add(hbox);
                addItemToShop(skill.getName(), skill.getCost(), hbox, "Skill");
            }


        }
        int artvar = 0;
        List<ArtifactInfo> artifacts = economyEngine.getArtifactsAvailableToBuy();
        for (ArtifactInfo artifact : artifacts) {
            if (artvar < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                artifactsShopInside.getChildren().add(hbox);
                addItemToShop(artifact.getName(), artifact.getCost(), hbox, "Artifact");
                artvar++;
            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                artifactsShopInside2.getChildren().add(hbox);
                addItemToShop(artifact.getName(), artifact.getCost(), hbox, "Artifact");
            }
        }

        int creaturevar = 0;
        List<CreatureInfo> creatures = economyEngine.getCreaturesAvailableToBuy();
        for (CreatureInfo creature : creatures) {
            if (creaturevar < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                creatureShopInside.getChildren().add(hbox);
                addItemToShop(creature.getName(), creature.getCost(), hbox, "Creature");
                creaturevar++;
            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                creatureShopInside2.getChildren().add(hbox);
                addItemToShop(creature.getName(), creature.getCost(), hbox, "Creature");
            }
        }
        initializeEq();


    }


    public void initializeEq() {
        heroSpellsInside.getChildren().clear();
        heroSpellsInside2.getChildren().clear();
        int spellvarhero = 0;
        List<SpellInfo> herospells = economyEngine.activeHero.getSpells();
        for (SpellInfo spell : herospells) {
            if (spellvarhero < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroSpellsInside.getChildren().add(hbox);
                addItemToEq(spell.getName(), spell.getCost(), hbox);
                spellvarhero++;

            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroSpellsInside2.getChildren().add(hbox);
                addItemToEq(spell.getName(), spell.getCost(), hbox);
            }

        }
        heroArtifactsInside.getChildren().clear();
        heroArtifactsInside2.getChildren().clear();
        int artvarhero = 0;
        List<ArtifactInfo> heroartifacts = economyEngine.activeHero.getArtifacts();
        for (ArtifactInfo artifact : heroartifacts) {
            if (artvarhero < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroArtifactsInside.getChildren().add(hbox);
                addItemToEq(artifact.getName(), artifact.getCost(), hbox);
                artvarhero++;

            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroArtifactsInside2.getChildren().add(hbox);
                addItemToEq(artifact.getName(), artifact.getCost(), hbox);
            }

        }
        heroSkillInside.getChildren().clear();
        heroSkillInside2.getChildren().clear();
        int skillvarhero = 0;
        List<SkillInfo> heroskills= economyEngine.activeHero.getSkills();
        for (SkillInfo skill : heroskills) {
            if (skillvarhero < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroSkillInside.getChildren().add(hbox);
                addItemToEq(skill.getName(), skill.getCost(),hbox);
                skillvarhero++;

            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroSkillInside2.getChildren().add(hbox);
                addItemToEq(skill.getName(), skill.getCost(),hbox);
            }

        }
        heroCreaturesInside.getChildren().clear();
        heroCreaturesInside.getChildren().clear();
        int creaturevarhero = 0;
        List<CreatureInfo> herocreatures = economyEngine.activeHero.getCreatures();
        for (CreatureInfo creature : herocreatures) {
            if (creaturevarhero < 5) {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroSkillInside.getChildren().add(hbox);
                addItemToEq(creature.getName(), creature.getCost(), hbox);
                creaturevarhero++;

            } else {
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                heroSkillInside2.getChildren().add(hbox);
                addItemToEq(creature.getName(), creature.getCost(), hbox);
            }

        }
    }

    public void handleBuySpell(ActionEvent actionEvent) {
        System.out.println("Clicked buy spell button;");
        System.out.println("ID is: ");
        System.out.println(((Button) actionEvent.getSource()).getId());
        String spellName = ((Button) actionEvent.getSource()).getId();
        SpellInfo spell = SpellBookInfoFactory.getSpell(spellName);
        System.out.println("Spell is:");
        System.out.println(spell.getName());

        if (economyEngine.activeHero.buySpell(spell)) {

            System.out.println("Spell bought");
            //gold.setText(String.valueOf(Integer.parseInt(gold.getText()) - spell.getCost()));
            spellShopInside.getChildren().remove(buySpellButton);
            spellShopInside2.getChildren().remove(buySpellButton);
            System.out.println(economyEngine.activeHero.getGold());
            System.out.println(economyEngine.activeHero.getSpells());
            initializeEq();
            gold.setText(Integer.toString(economyEngine.activeHero.getGold()));
        } else {
            System.out.println("Couldn't buy spell");

        }

    }

    public void addItemToEq(String name, int cost, HBox hbox) {
        Button btn = new Button();
        btn.setId(name);
        btn.setText(name);
        btn.setMinSize(170, 30);
        hbox.getChildren().add(btn);
        TextField text = new TextField(String.valueOf(cost));
        text.setEditable(false);
        text.setMaxWidth(70);
        text.setMinSize(50, 30);
        text.setId(name);
        hbox.getChildren().add(text);
    }


    public void handleBuyArtifact(ActionEvent actionEvent) {
        System.out.println("Clicked buy artifact button;");
        System.out.println("ID is: ");
        System.out.println(((Button) actionEvent.getSource()).getId());
        String artifactName = ((Button) actionEvent.getSource()).getId();
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(artifactName);
        System.out.println("Artifact is:");
        System.out.println(artifact.getName());

        if (economyEngine.activeHero.buyArtifact(artifact)) {

            System.out.println("Artifact bought");
            //gold.setText(String.valueOf(Integer.parseInt(gold.getText()) - spell.getCost()));
            artifactsShopInside.getChildren().remove(buyArtifactButton);
            artifactsShopInside2.getChildren().remove(buyArtifactButton);
            initializeEq();
            gold.setText(Integer.toString(economyEngine.activeHero.getGold()));
        } else {
            System.out.println("Couldn't buy artifact");

        }
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


    public void handlePassTurn(ActionEvent actionEvent) {
        economyEngine.changeHero();
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
//        creatureShopInside.getChildren().clear();
//        creatureShopInside2.getChildren().clear();

    }

    public void handleBuySpecialSkill(ActionEvent actionEvent) {


        System.out.println("Clicked buy skill button;");
        System.out.println("ID is: ");
        System.out.println(((Button) actionEvent.getSource()).getId());
        String skillName = ((Button) actionEvent.getSource()).getId();
        SkillInfo skill = SkillInfoFactory.getSkill(skillName);
        System.out.println("Skill is:");
        System.out.println(skill.getName());

        if (economyEngine.activeHero.buySkill(skill)) {

            System.out.println("skill bought");
            //gold.setText(String.valueOf(Integer.parseInt(gold.getText()) - spell.getCost()));
            skillShopInside.getChildren().remove(buySpecialSkillButton);
            skillShopInside2.getChildren().remove(buySpecialSkillButton);
            //System.out.println(economyHero1.getGold());
            //System.out.println(economyHero1.getSpells());
            initializeEq();
            gold.setText(Integer.toString(economyEngine.activeHero.getGold()));
        } else {
            System.out.println("Couldn't buy spell");

        }
    }

}
