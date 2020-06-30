package pl.psi.game.converter;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
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
        new SpellFactory();
        new SpellBookInfoFactory();
        new ArtifactsInfoFactory();
    }

    private boolean CreatureEquals(Creature c1,Creature c2)
    {
        return c1.getDisplayName().equals(c2.getDisplayName());
    }
    private boolean SpellEquals(Spell s1,Spell s2)
    {
        return (s1.getCost()==s2.getCost()) && s1.getDescription().equals(s2.getDescription()) &&
        (s1.getDuration()==s2.getDuration()) && (s1.getLevel()==s2.getLevel()) &&
        s1.getName().equals(s2.getName()) && s1.getType().equals(s2.getType());
    }


    void InitializeEconomyHero()
    {
        economyHero = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();//2 attack 2 defence 1 power 1 knowledge
    }
    @Test
    void ConvertOneEconomyCreatureToBattleCreature() throws Exception
    {
        InitializeEconomyHero();
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        economyHero.buyCreature(creatureInfo, 1);

        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        Creature creature = creatureAbstractFactory.getCreature(economyHero.getCreatureStack(creatureInfo));

        assertTrue(CreatureEquals(creature,hero.getCreatures().get(0)));
    }
    @Test
    @Disabled
    //Wait for amount change method
    void ConvertStackEconomyCreatureToBattleCreature() throws Exception
    {
        InitializeEconomyHero();
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        economyHero.buyCreature(creatureInfo, 1);

        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        Creature creature = creatureAbstractFactory.getCreature(economyHero.getCreatureStack(creatureInfo));

        assertEquals(creature,hero.getCreatures().get(0));
    }
    @Test
    void ConvertEconomySpellToBattleSpell() throws Exception
    {
        InitializeEconomyHero();
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        economyHero.buySpell(spellInfo);
        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        SpellFactory spellFactory = new SpellFactory();
        Spell spell = spellFactory.createSpell(spellInfo,hero.getPower());

        assertTrue(SpellEquals(spell,hero.getSpellBook().getSpells().get(0)));
    }
    @Test
    void AppliedArtifactOnHeroChangeHeroStats()
    {
        InitializeEconomyHero();// 1 knowledge
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);// +1 knowledge
        economyHero.buyArtifact(artifactInfo);
        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        assertEquals(hero.getKnowledge(),2);
    }
    @Test
    void AppliedArtifactOnHeroChangeSpell()
    {
        InitializeEconomyHero();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.CAPE_OF_CONJURING);// +3 spell duration
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE);// 1 spell duration
        economyHero.buyArtifact(artifactInfo);
        economyHero.buySpell(spellInfo);
        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        assertEquals(hero.getSpellBook().getSpells().get(0).getDuration(),4);
    }
    @Test
    void AppliedArtifactOnHeroChangeCreatureStats()
    {
        InitializeEconomyHero();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.CAPE_OF_VELOCITY);// +2 move range
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);// 5 move range
        economyHero.buyArtifact(artifactInfo);
        economyHero.buyCreature(creatureInfo, 1);
        Hero hero = HeroEcoBattleConverter.convert(economyHero);
        assertEquals(hero.getCreatures().get(0).getMoveRange(),7);
    }
    @Test
    @Disabled
    void AppliedArtifactOnHeroChangeSkill()
    {
        //later if exist
    }
}
