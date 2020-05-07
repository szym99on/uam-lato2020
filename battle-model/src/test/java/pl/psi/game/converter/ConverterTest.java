package pl.psi.game.converter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.fractions.NecropolisCreatureFactory;
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
    void ApplyEconomyCreaturesToBattleCreatures()
    {
        //Economy creatures list
        ////EconomyFactory economyfactory = new EconomyFactory();
        ////economyHero = economyfactory.createHero();
        FractionsInfoAbstractFactory fractionsInfoAbstractFactory = new FractionsInfoAbstractFactory();
        ////CreatureInfo creatureInfo = fractionsInfoAbstractFactory.getByType(FractionsInfo.Type.NECROPOLIS).createCreature(1);
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
    void AppliedEconomyArtifactCreatureNotEqualToBattleCreature()
    {
        //Economy creatures list
        ////EconomyFactory economyfactory = new EconomyFactory();
        ////economyHero = economyfactory.createHero();
        FractionsInfoAbstractFactory fractionsInfoAbstractFactory = new FractionsInfoAbstractFactory();
        ////CreatureInfo creatureInfo = fractionsInfoAbstractFactory.getByType(FractionsInfo.Type.NECROPOLIS).createCreature(1);
        ////economyHero.addCreatureInfo(creatureInfo,1);
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
    void AppliedEconomyArtifactSpellNotEqualToBattleSpell()
    {
        //Economy spell list
        ////EconomyFactory economyfactory = new EconomyFactory();
        ////economyHero = economyfactory.createHero();
        FractionsInfoAbstractFactory fractionsInfoAbstractFactory = new FractionsInfoAbstractFactory();
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
}
