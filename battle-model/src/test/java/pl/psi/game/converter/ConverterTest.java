package pl.psi.game.converter;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.*;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.CAPE_OF_VELOCITY;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.RING_OF_LIFE;

public class ConverterTest {

    private EconomyHero economyHero;
    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();

    @BeforeAll
    static void InitializeFactories(){
        new HeroInfoFactory();
    }

    void InitializeEconomyHero()
    {
        economyHero = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
    }
    @Test
    @Disabled
    void ConvertOneEconomyCreatureToBattleCreature() throws Exception
    {
        InitializeEconomyHero();
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        economyHero.buyCreature(creatureInfo);

        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);

        assertEquals(creature,hero.getCreatures().get(0));
    }
    @Test
    @Disabled
    //Wait for amount change method
    void ConvertStackEconomyCreatureToBattleCreature() throws Exception
    {
        InitializeEconomyHero();
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        economyHero.buyCreature(creatureInfo);

        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);

        assertEquals(creature,hero.getCreatures().get(0));
    }
    @Test
    @Disabled
    void ConvertEconomySpellToBattleSpell() throws Exception
    {
        InitializeEconomyHero();
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        economyHero.buySpell(spellInfo);
        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        SpellFactory spellFactory = new SpellFactory();
        Spell spell = spellFactory.createSpell(spellInfo);

        assertEquals(spell,hero.getSpellBook().getSpells().get(0));
    }
    @Test
    @Disabled
    void AppliedArtifactOnHeroChangeHeroStats()
    {
        InitializeEconomyHero();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);

        Hero hero = HeroEcoBattleConverter.convert(economyHero);

        assertEquals(hero.getKnowledge(),2);
    }
    @Test
    @Disabled
    void AppliedArtifactOnHeroChangeCreatureStats()
    {
        //change later
    }
    @Test
    @Disabled
    void AppliedArtifactOnHeroChangeSpell()
    {
        //later if exist
    }
}
