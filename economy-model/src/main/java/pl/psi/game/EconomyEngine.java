package pl.psi.game;

import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.hero.shops.ArtifactsShop;
import pl.psi.game.hero.shops.CreaturesShop;
import pl.psi.game.hero.shops.SpecialSkillsShop;
import pl.psi.game.hero.shops.SpellShop;
import pl.psi.game.spellbook.SpellInfo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
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
        this.activeHero = economyHero1;
        this.spellShop1 = new SpellShop();
        this.spellShop2 = new SpellShop();
        this.artifactsShop1 = new ArtifactsShop();
        this.artifactsShop2 = new ArtifactsShop();
        this.specialSkillsShop1 = new SpecialSkillsShop();
        this.specialSkillsShop2 = new SpecialSkillsShop();
        this.creaturesShop1 = new CreaturesShop();
        this.creaturesShop2 = new CreaturesShop();

        spellShop1.generateSpellsAvailableToBuy();
        spellShop2.generateSpellsAvailableToBuy();

        artifactsShop1.generateArtifactsAvailableToBuy();
        artifactsShop2.generateArtifactsAvailableToBuy();

        specialSkillsShop1.generateSkillsAvailableToBuy();
        specialSkillsShop2.generateSkillsAvailableToBuy();

//        creaturesShop1.generateCreaturesAvailableToBuy();
//        creaturesShop2.generateCreaturesAvailableToBuy();
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
    }


    public List<SpellInfo> getSpellsAvailableToBuy() {
        List<SpellInfo> spells = new ArrayList<>();
        if (this.activeHero == economyHero1) {
            spells = spellShop1.getSpellsAvailableToBuy();
        } else {
            spells = spellShop2.getSpellsAvailableToBuy();
        }
        return spells;
    }

}
