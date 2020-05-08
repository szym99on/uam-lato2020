package pl.psi.game.hero.artifacts;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactTest {
//    @Test
//    @Disabled
//    void artifactShouldIncreaseKnowledgeBy2Points() {
//        Hero hero = Hero.builder().aKnowledge(7).build();
//        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Skull helmet");
//        ArtifactsFactory factory = new ArtifactsFactory();
//        Artifact artifact = factory.getArtifact(artifactInfo);
//
//        artifact.buffSkill(hero);
//
//        assertEquals(9, hero.getKnowledge());
//    }
//
//    @Test
//    @Disabled
//    void removedArtifactShouldDebuff(){
//
//        Hero hero = Hero.builder().aKnowledge(7).build();
//        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Skull helmet");
//        ArtifactsFactory factory = new ArtifactsFactory();
//        Artifact artifact = factory.getArtifact(artifactInfo);
//
//        artifact.buffSkill(hero);
//
//        //hero puts artifact off
//        artifact.debuffSkill(hero);
//
//        assertEquals(7, hero.getKnowledge());
//    }
//
//    @Test
//    @Disabled
//    void artifactShouldIncreaseSpellDurationBy1Point() {
//        Spell spell = Spell.builder().aDuration(2).build();
//        Artifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Collar of Conjurin"));
//
//        artifact.buffSpell(spell);
//
//        assertEquals(3, spell.getDuration());
//    }
//
//    @Test
//    @Disabled
//    void artifactShouldIncreaseCreatureMoveRangeBy2Points() {
//        Creature creature = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(0).aMoveRange(5).build();
//        Artifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Cape of Velocity"));
//
//        artifact.buffCreature(creature);
//
//        assertEquals(7, creature.getMoveRange());
//    }
//
//    @Test
//    @Disabled
//    void artifactShouldIgnoreUsingSpell() {
//        //Renders your units immune to the death ripple spell
//
//        Spell spell = new Spell(SpellBookInfoFactory.getSpell("Death ripple"));
//        Creature creature = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(0).aMoveRange(5).build();
//        Artifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Pendant of Life"));
//
//        artifact.buffCreature(creature);
//        spell.cast(creature);
//
//        assertEquals(100, creature.getMaxHp());
//    }
//
//    @Test
//    @Disabled
//    void artifactShouldPreventCastingSpellsOfLevel3() {
//        //prevent == remove from opponent's spellbook?
//        Artifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Recanter's Cloak"));
//
//        Spell s1 = Spell.builder().aTier(1).build();
//        Spell s2 = Spell.builder().aTier(2).build();
//        Spell s3 = Spell.builder().aTier(3).build();
//        List<Spell> spells = new ArrayList<>();
//        spells.add(s1);
//        spells.add(s2);
//        spells.add(s3);
//
//        Hero hero = new Hero(spells);
//
//        Hero heroWithArtifact = Hero.builder().build();
//        artifact.buffSkill(heroWithArtifact);
//
//        List<Spell> expected = new ArrayList<>();
//        expected.add(s1);
//        expected.add(s2);
//
//        assertEquals(expected, hero.getSpells());
//    }

}
