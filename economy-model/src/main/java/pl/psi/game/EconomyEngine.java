package pl.psi.game;

import pl.psi.game.fractions.CreatureStack;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.hero.shops.ArtifactsShop;
import pl.psi.game.hero.shops.CreaturesShop;
import pl.psi.game.hero.shops.SpecialSkillsShop;
import pl.psi.game.hero.shops.SpellShop;
import pl.psi.game.skills.SkillInfo;
import pl.psi.game.skills.SkillInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class EconomyEngine implements PropertyChangeListener {


    public static final String END_OF_TURN = "END_OF_TURN";
    public static final String ITEM_BOUGHT = "ITEM_BOUGHT";
    public static final String ACTIVE_HERO_CHANGED = "ACTIVE_HERO_CHANGED";
    public EconomyHero activeHero;
    public EconomyHero economyHero1;
    public EconomyHero economyHero2;
    public SpellShop spellShop1;
    public SpellShop spellShop2;
    public ArtifactsShop artifactsShop1;
    public ArtifactsShop artifactsShop2;
    public SpecialSkillsShop specialSkillsShop1;
    public SpecialSkillsShop specialSkillsShop2;
    public CreaturesShop creaturesShop1;
    public CreaturesShop creaturesShop2;
    private PropertyChangeSupport propertyChangeSupport;

    public EconomyEngine(EconomyHero economyHero1, EconomyHero economyHero2) {

        new FractionsInfoAbstractFactory();
        new HeroInfoFactory();
        new ArtifactsInfoFactory();
        new SpellBookInfoFactory();
        new SkillInfoFactory();


        this.economyHero1 = economyHero1;
        this.economyHero2 = economyHero2;
        this.activeHero = economyHero1;
        this.spellShop1 = new SpellShop();
        this.spellShop2 = new SpellShop();
        this.artifactsShop1 = new ArtifactsShop();
        this.artifactsShop2 = new ArtifactsShop();
        this.specialSkillsShop1 = new SpecialSkillsShop();
        this.specialSkillsShop2 = new SpecialSkillsShop();
        this.creaturesShop1 = new CreaturesShop(economyHero1.getHeroInfo().getFractionFactory());
        this.creaturesShop2 = new CreaturesShop(economyHero2.getHeroInfo().getFractionFactory());

        refreshShops(1);
        refreshShops(2);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
    }


    public List<SpellInfo> getSpellsAvailableToBuy() {
        return this.activeHero == economyHero1 ? spellShop1.getSpellsAvailableToBuy() : spellShop2.getSpellsAvailableToBuy();

    }

    public List<SkillInfo> getSkillsAvailableToBuy() {
        return this.activeHero == economyHero1 ? specialSkillsShop1.getSpecialSkillsAvailableToBuy() : specialSkillsShop2.getSpecialSkillsAvailableToBuy();

    }
    public List<ArtifactInfo> getArtifactsAvailableToBuy() {
        return this.activeHero == economyHero1 ? artifactsShop1.getArtifactsAvailableToBuy() : artifactsShop2.getArtifactsAvailableToBuy();
    }
    public List<CreatureStack> getCreaturesAvailableToBuy() {
        return this.activeHero == economyHero1 ? creaturesShop1.getCreaturesAvailableToBuy() : creaturesShop2.getCreaturesAvailableToBuy();

    }

    public void refreshShops(int i){
        if(i == 1) {
            spellShop1.generateItemsAvailableToBuy();
            artifactsShop1.generateItemsAvailableToBuy();
            specialSkillsShop1.generateItemsAvailableToBuy();
            creaturesShop1.generateItemsAvailableToBuy();
        }

        if(i == 2){
            spellShop2.generateItemsAvailableToBuy();
            artifactsShop2.generateItemsAvailableToBuy();
            specialSkillsShop2.generateItemsAvailableToBuy();
            creaturesShop2.generateItemsAvailableToBuy();
        }
    }

    public void endTurn(){
        activeHero.increaseGold(3000);
        if(activeHero == economyHero1)
            refreshShops(1);
        else
            refreshShops(2);
        changeHero();
    }

    public void changeHero(){
        if(activeHero == economyHero1)
            activeHero = economyHero2;
        else
            activeHero = economyHero1;
    }

    public void sellItem(String itemName, String type){
        switch(type) {
            case "Spell":
                activeHero.sellSpell(SpellBookInfoFactory.getSpell(itemName));
                break;

            case "Artifact":
                activeHero.sellArtifact(ArtifactsInfoFactory.getArtifact(itemName));
                break;
        }
    }



}
