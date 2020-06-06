package pl.psi.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pl.psi.game.EconomyEngine;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.CreatureStack;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.hero.shops.ArtifactsShop;
import pl.psi.game.skills.SkillInfo;
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
    private URL location;

    @FXML
    private ResourceBundle resources;

    private final EconomyHero economyHero1;
    private final EconomyHero economyHero2;
    private final EconomyEngine economyEngine;

    public MainEconomyController(){
        economyHero1 = EconomyHero.builder().aGold(3000).build();
        economyHero2 = EconomyHero.builder().aGold(3000).build();
        economyEngine = new EconomyEngine(economyHero1, economyHero2);
    }


    @FXML
    private void handleBuyCreature(ActionEvent event)
    {
        System.out.println("Clicked buy creature button;");
        buyCreatureButton.setText("Buy creature button clicked");
    }


    @FXML
    private void initialize()
    {
        List<SpellInfo> spells = economyEngine.getSpellsAvailableToBuy();
        for(SpellInfo spell : spells){
            Button btn = new Button();
            btn.setId(spell.getName());
            btn.setText(spell.getName());
            btn.setOnAction(this::handleBuySpell);
            spellShop.getChildren().add(btn);

        }
        List<SkillInfo> skills = economyEngine.getSkillsAvailableToBuy();
        for(SkillInfo skill : skills){
            Button btn = new Button();
            btn.setId(skill.getName());
            btn.setText(skill.getName());
            btn.setOnAction(e -> System.out.println(btn.getId()));
            skillShop.getChildren().add(btn);

        }
        List<ArtifactInfo> artifacts = economyEngine.getArtifactsAvailableToBuy();
        for(ArtifactInfo artifact : artifacts){
            Button btn = new Button();
            btn.setId(artifact.getName());
            btn.setText(artifact.getName());
            btn.setOnAction(e -> System.out.println(btn.getId()));
            artifactsShop.getChildren().add(btn);

        }
//        List<CreatureStack> creatures = economyEngine.getCreaturesAvailableToBuy();
//        for(CreatureStack creatureStack : creatures){
//            Button btn = new Button();
//        btn.setId(creatureStack.getName());
//            btn.setText(creatureStack.getName());
//        btn.setOnAction(e -> System.out.println(btn.getId()));

//            creatureShop.getChildren().add(btn);
//
//        }
    }

    public void handleBuySpell(ActionEvent actionEvent) {
        System.out.println("Clicked buy spell button;");
        System.out.println("ID is: ");
        System.out.println(((Button)actionEvent.getSource()).getId());
        String spellName = ((Button)actionEvent.getSource()).getId();
        SpellInfo spell = SpellBookInfoFactory.getSpell(spellName);
        System.out.println("Spell is:");
        System.out.println(spell.getName());

        if(economyEngine.buySpell(spell)) {
            System.out.println("Spell bought");
            gold.setText(String.valueOf(Integer.parseInt(gold.getText())-spell.getCost()));
            spellShop.getChildren().remove(buySpellButton);
        } else {
            System.out.println("Couldn't buy spell");

        }

    }

    public void handleBuyArtifact(ActionEvent actionEvent) {
        System.out.println("Clicked buy artifact button;");
        buyArtifactButton.setText("Buy artifact button clicked");
    }

    public void handlePassTurn(ActionEvent actionEvent) {
        System.out.println("Clicked pass turn  button;");
        passTurnButton.setText("Pass turn  button clicked");
    }

    public void handleBuySpecialSkill(ActionEvent actionEvent) {
        System.out.println("Clicked buy special skill button;");
        buySpecialSkillButton.setText("Buy special skill button clicked");
    }

}
