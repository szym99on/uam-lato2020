package pl.psi.game.hero.artifacts;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.SKULL_HELMET;

public class ArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
    }

    @Test
    void factoryShouldCreateArtifactBasedOnInfo() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SKULL_HELMET);
        Artifact skullHelmet = ArtifactFactory.createArtifact(artifactInfo);

        assertEquals(0, skullHelmet.getAttack());
        assertEquals(0, skullHelmet.getDefence());
        assertEquals(2, skullHelmet.getKnowledge());
        assertEquals(0, skullHelmet.getPower());
    }

    @Test
    void artifactShouldIncreaseKnowledgeBy2Points(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SKULL_HELMET);
        Artifact skullHelmet = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try{skullHelmet.apply(battleHero);}
        catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(2, battleHero.getKnowledge());
        assertEquals(0, battleHero.getAttack());
        assertEquals(0, battleHero.getDefence());
        assertEquals(0, battleHero.getPower());
    }

    @Test
    @Disabled
    void artifactShouldIncreaseSpellDurationBy1Point() {
//        Spell spell = new Spell(SpellBookInfoFactory.getSpell("Fortune"));
//        SpellBuffArtifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Collar of Conjurin"));

//        we will make request for spellbook team about method: increase spell duration (and use it inside artifact)
//        artifact.buff(spell);

//        assertEquals(3, spell.getDuration());
    }

    @Test
    @Disabled
    void artifactShouldIncreaseCreatureMoveRangeBy2Points() {
//        EconomyHero hero = EconomyHero.builder().build();
        Creature creature = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(0).aMoveRange(5).build();
//        hero.addCreature(creature);

        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Cape of Velocity");
        ArtifactFactory factory = new ArtifactFactory();
        Artifact artifact = factory.createArtifact(artifactInfo);

//        artifact.apply(hero);

        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();
//        Hero battleHero = converter.convertEconomyHeroToBattleHero(hero);

//        assertEquals(7, battleHero.getCreatures().get(0).getMoveRange());
    }

    @Test
    @Disabled
//    TODO: looks fine
    void artifactShouldIgnoreUsingSpell() {
        //Renders your units immune to the death ripple spell

//        Spell spell = new Spell(SpellBookInfoFactory.getSpell("Death ripple"));
        Creature creature = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(0).aMoveRange(5).build();
//        Artifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Pendant of Life"));

//        artifact.buffCreature(creature);
//        spell.cast(creature);

//        assertEquals(100, creature.getMaxHp());
    }
}
