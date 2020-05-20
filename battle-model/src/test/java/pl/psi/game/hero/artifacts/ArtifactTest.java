package pl.psi.game.hero.artifacts;

import com.google.common.base.Converter;
import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.artifacts.ArtifactForSpells;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.EconomyHero;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactTest {
    @Test
    @Disabled
    void artifactShouldIncreaseKnowledgeBy2Points() {
        //EconomyHero hero = EconomyHero.builder().aKnowledge(7).build();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Skull helmet");
        //hero.equip(artifactInfo);
        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();
       // Hero battleHero = converter.convertEconomyHeroToBattleHero(hero);

        //assertEquals(90, battleHero.getMana());
    }

    @Test
    @Disabled
    void artifactShouldIncreaseSpellDurationBy1Point() {
//        Spell spell = new Spell(SpellBookInfoFactory.getSpell("Fortune"));
//        ArtifactForSpells artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Collar of Conjurin"));

//        we will make request for spellbook team about method: increase spell duration (and use it inside artifact)
//        artifact.buff(spell);

//        assertEquals(3, spell.getDuration());
    }

    @Test
    @Disabled
    void artifactShouldIncreaseCreatureMoveRangeBy2Points() {
        EconomyHero hero = EconomyHero.builder().build();
        Creature creature = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(0).aMoveRange(5).build();
//        hero.addCreature(creature);

        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Cape of Velocity");
        ArtifactFactory factory = new ArtifactFactory();
        Artifact artifact = factory.createArtifact(artifactInfo);

        artifact.apply(hero);

        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();
        Hero battleHero = converter.convertEconomyHeroToBattleHero(hero);

        assertEquals(7, battleHero.getCreatures().get(0).getMoveRange());
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
