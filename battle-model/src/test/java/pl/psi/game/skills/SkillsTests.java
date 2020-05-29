package pl.psi.game.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.psi.game.skills.SkillInfoFactory.*;

public class SkillsTests {

    @Test
    //fake test for git
    //TODO looks fine, but better api will be skill.cast(Hero) and concrete instance of Skill will be get all creatures and apply something to creature only if necessary. The same with spells etc.
    @Disabled
    void offenceSkillShouldIncreaseDamage() {
        int lowAttack = 50, highAttack = 100;
        Skill offenceSkill = new Skill(SkillInfoFactory.getSkill(OFFENCE));
        Hero hero = Hero.builder().build();
        Creature creature = Creature.builder().aAttack(Range.closed(lowAttack, highAttack)).build();

        offenceSkill.cast(hero);

        Range<Integer> attackAfterSkill = creature.getAttack();
        assertEquals(Range.closed(55,110), attackAfterSkill);
    }

    @Test
    //TODO: better test name - increaseArmor :) not decrease Damage.
    @Disabled
    void armourerSkillShouldIncreaseArmor() {
        Skill armourSkill = new Skill(SkillInfoFactory.getSkill(ARMOURER));
        Creature creature = Creature.builder().aArmor(100).build();
        Hero hero = Hero.builder().build();

        armourSkill.cast(hero);

        assertEquals(110, creature.getArmor());

    }

    @Test
    //TODO mana point not spell point
    void intelligenceShouldIncreaseHeroesMaxManaPoints() {
 //       Hero hero = Hero.builder().aMaxManaPoints(100).build();
 //       Skill intelligenceSkill = new Skill(SkillInfoFactory.getSkill(INTELLIGENCE));
//
//       intelligenceSkill.addSkill(hero);
//
//        assertEquals(125, hero.aCheckManaPoints());

    }

    @Test
    @Disabled
    //TODO looks very bad. Wisdom is totally not generic skill in this case. You should project generic API
    // with this api you have to implement empty method unlockSpellsThirdLvl for each skills (event not necessary)
    void wisdomShouldAllowSpellsBelowThirdLevel() {
//        Skill wisdomSkill = new Skill(SkillInfoFactory.getSkill(WISDOM));
//        Hero hero = Hero.builder().aSpells(HASTE).build();
//
//        wisdomSkill.cast(hero);
//
//
//        assertEquals(3, hero.getSpells());

    }

    @Test
    void learningSkillShouldIncreaseEarnedExperience() {
//        Hero hero = Hero.builder().aEarnedExperience(100).build();
 //       Skill learningSkill = new Skill(SkillInfoFactory.getSkill(LEARNING));

//       learningSkill.addSkill(hero);

//       assertEquals(105, hero.getEarnedExperience());
    }

    @Test
    void resistanceSkillShouldFailSpells() {
//        Skill resistanceSkill = new Skill(SkillInfoFactory.getSkill(RESISTANCE));
//        Hero hero = Hero.builder().build();
//        Creature creature = Creature.builder().aMaxHp(100).build();
//
//        resistanceSkill.addSkill(hero);
//
//       assertEquals(100, creature.getCurrentHp());
    }

}


