package pl.psi.game.hero.artifacts;

import com.google.common.base.Converter;
import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.EconomyHero;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactTest {
    @Test
    @Disabled
    void artifactShouldIncreaseKnowledgeBy2Points() {
        EconomyHero hero = EconomyHero.builder().aKnowledge(7).build();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Skull helmet");
        hero.equip(artifactInfo);
        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();
        Hero battleHero = converter.convertEconomyHeroToBattleHero(hero);

        assertEquals(90, battleHero.getMana());
    }
//
//    @Test
//    @Disabled
    //TODO: you should check artifact head location is empty after unequip helmet.
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
    // TODO: You should use some spell factory, not spell builder (builder should be encapsulated in spell package), you should make request for spellbook team about method: increase spell duration (and use it inside your artifact)
//    void artifactShouldIncreaseSpellDurationBy1Point() {
//        Spell spell = Spell.builder().aDuration(2).build();
//        Artifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Collar of Conjurin"));
//
//        artifact.buffSpell(spell);
//
//        assertEquals(3, spell.getDuration());
//    }
//
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
//
//    @Test
//    @Disabled

    //TODO: looks fine
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
    //TODO: hard to explain what is wrong :). In short too many things in application is not encapsulated, but it's not your mistake. prevent means that opponent cannot cast it, not remove from spellbook
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
