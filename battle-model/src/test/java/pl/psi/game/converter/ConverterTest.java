package pl.psi.game.converter;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.*;
import pl.psi.game.hero.EconomyHero;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    @Test
    @Disabled
            //fake
    //TODO: check assertThrow method.
    void ConvertEconomyHeroToBattleHero()
    {
        try{
            //EconomyFactory economyfactory = new EconomyFactory();
            //economyHero = economyfactory.createHero();
            HeroEcoBattleConverter converter = new HeroEcoBattleConverter();
            //Hero battleHero = converter.convertEconomyHeroToBattleHero(economyHero);
            assertTrue(false);
        }
        catch (Exception e)
        {
            assertTrue(true);
        }
    }

    @Test
    @Disabled
    //TODO: you can abstain from economyFactory. Just make constructor for EconomyHero.
    //TODO: Looks fine, but you should check stacking creatures here too. creatureCount e.g. 10
    void ApplyEconomyCreaturesToBattleCreatures()
    {
        //Economy creatures list
        ////EconomyFactory economyfactory = new EconomyFactory();
        ////economyHero = economyfactory.createHero();
        FractionsInfoAbstractFactory fractionsInfoAbstractFactory = new FractionsInfoAbstractFactory();
        ////CreatureInfo creatureInfo = fractionsInfoAbstractFactory.getByType(FractionsInfo.Type.NECROPOLIS).createCreature(1);
        Integer creatureCount = 1;
        ////economyHero.addCreatureInfo(creatureInfo,creatureCount);
        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();

        ////Hero battleHero = converter.convertEconomyHeroToBattleHero(economyHero);

        //Battle creatures list
        ////FractionsAbstractFactory fractionsAbstractFactory = new FractionsAbstractFactory();
        ////Creature creature = fractionsAbstractFactory.getByType(FractionInfo.Type.NECROPOLIS).createCreature(1);
        List<Creature> creatures = new ArrayList<Creature>();
        ////creatures.add(creature);

        ////assertEquals(creatures,battleHero.getCreatures());
    }

    @Test
    @Disabled
    //TODO: Completely not understand...
    void AppliedEconomyArtifactCreatureNotEqualToBattleCreature()
    {
        //Economy creatures list
        ////EconomyFactory economyfactory = new EconomyFactory();
        ////economyHero = economyfactory.createHero();
        FractionsInfoAbstractFactory fractionsInfoAbstractFactory = new FractionsInfoAbstractFactory();
        ////CreatureInfo creatureInfo = fractionsInfoAbstractFactory.getByType(FractionsInfo.Type.NECROPOLIS).createCreature(1);
        Integer creatureCount = 1;
        ////economyHero.addCreatureInfo(creatureInfo,creatureCount);
        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();

        ArtifactsInfoFactory artifactsInfoFactory = new ArtifactsInfoFactory();
        ////ArtifactInfo artifact = artifactsInfoFactory.getByType(ArtifactInfo.Location.FINGERS).stream().findFirst();
        ////economyHero.addArtifact(artifact);

        ////Hero battleHero = converter.convertEconomyHeroToBattleHero(economyHero);

        //Battle creatures list
        ////FractionsAbstractFactory fractionsAbstractFactory = new FractionsAbstractFactory();
        ////Creature creature = fractionsAbstractFactory.getByType(FractionInfo.Type.NECROPOLIS).createCreature(1);
        List<Creature> creatures = new ArrayList<Creature>();
        ////creatures.add(creature);

        ////assertNotEquals(battleHero.getCreatures(),creatures);
    }

    @Test
    @Disabled
    void economySpellsShoulBeEqualToBattleSpells()
    {
        //Economy spell list
        ////EconomyFactory economyfactory = new EconomyFactory();
        ////economyHero = economyfactory.createHero();
        List<SpellInfo> spellsInfo = new ArrayList<SpellInfo>();
        SpellBookInfoFactory spellBookInfoFactory = new SpellBookInfoFactory();
        spellsInfo=spellBookInfoFactory.getSpellsByType(SpellInfo.Type.AIR);
        ////economyHero.addSpellsInfo(spellsInfo);
        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();


        ////Hero battleHero = converter.convertEconomyHeroToBattleHero(economyHero);

        //Battle spell list
        ////List<Spell> spells = new ArrayList<Spell>();
        ////SpellBookFactory spellBookFactory = new SpellBookFactory();
        ////spells=spellBookFactory.getSpellsByType(SpellInfo.Type.AIR);

        ////assertEquals(battleHero.getSpells(),spells);
    }


    @Test
    @Disabled
    void AppliedEconomyArtifactSpellNotEqualToBattleSpell()
    {
        //Economy spell list
        ////EconomyFactory economyfactory = new EconomyFactory();
        ////economyHero = economyfactory.createHero();
        List<SpellInfo> spellsInfo = new ArrayList<SpellInfo>();
        SpellBookInfoFactory spellBookInfoFactory = new SpellBookInfoFactory();
        spellsInfo=spellBookInfoFactory.getSpellsByType(SpellInfo.Type.AIR);
        ////economyHero.addSpellsInfo(spellsInfo);
        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();


        ArtifactsInfoFactory artifactsInfoFactory = new ArtifactsInfoFactory();
        ////ArtifactInfo artifact = artifactsInfoFactory.getByType(ArtifactInfo.Location.FINGERS).stream().findFirst();
        ////economyHero.addArtifact(artifact);

        ////Hero battleHero = converter.convertEconomyHeroToBattleHero(economyHero);

        //Battle spell list
        ////List<Spell> spells = new ArrayList<Spell>();
        ////SpellBookFactory spellBookFactory = new SpellBookFactory();
        ////spells=spellBookFactory.getSpellsByType(SpellInfo.Type.AIR);

        ////assertNotEquals(battleHero.getSpells(),spells);
    }



    @Test
    @Disabled
    //TODO: Why should have 10 mana? o.0
    //ManaPoints = Knowledge*10
    void heroShouldHave10ManaPoints() {
        //EconomyHero economyHero = EconomyHero.builder().aKnowledge(1).build();
        HeroEcoBattleConverter heroEcoBattleConverter = new HeroEcoBattleConverter();
        //Hero hero = heroEcoBattleConverter.convertEconomyHeroToBattleHero(economyHero);

        //assertEquals(10, hero.getManaPoints());
    }

    @Test
    @Disabled
    //TODO: Why should increase hp?
    ////CreatureHP += HeroDefense
    void heroShouldIncreaseCreatureMaxHpTo8() {
        //CreatureInfo creatureInfo = CreatureInfo.builder().aMaxHp(6).build();
        //List<CreatureInfo> ecoCreatureList = new ArrayList<>();
        //ecoCreatureList.add(creatureInfo);
        //EconomyHero economyHero = EconomyHero.builder().aAttack(2).build();
        Integer creatureCount = 1;
        //economyHero.addCreatureInfo(creatureInfo,creatureCount);
        HeroEcoBattleConverter heroEcoBattleConverter = new HeroEcoBattleConverter();
        //Hero hero =  heroEcoBattleConverter.convertEconomyHeroToBattleHero(economyHero);
        //List<Creature> creatureList = hero.getCreatures();
        //Creature creature = creatureList.get(0);

        //assertEquals(8, creature.getMaxHp());
    }

    @Test
    @Disabled
    //TODO: as above? why??
        // CreatureAttack += HeroAttack
    void heroShouldIncreaseCreatureAttackTo35() {
        //CreatureInfo creatureInfo = CreatureInfo.builder().aAttack(Range.closed(1,3)).build();
        //List<CreatureInfo> ecoCreatureList = new ArrayList<>();
        //ecoCreatureList.add(creatureInfo);
        //EconomyHero economyHero = EconomyHero.builder().aAttack(2).build();
        Integer creatureCount = 1;
        //economyHero.addCreatureInfo(creatureInfo,creatureCount);
        HeroEcoBattleConverter heroEcoBattleConverter = new HeroEcoBattleConverter();
        //Hero hero =  heroEcoBattleConverter.convertEconomyHeroToBattleHero(economyHero);
        //List<Creature> creatureList = hero.getCreatures();
        //Creature creature = creatureList.get(0);

        //assertEquals(5, creature.getAttack().upperEndpoint());
        //assertEquals(3, creature.getAttack().lowerEndpoint());
    }
}
