package pl.psi.game.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import static org.junit.jupiter.api.Assertions.*;

public class SkillsTests {

    @Test
    //fake test for git
    //TODO looks fine, but better api will be skill.cast(Hero) and concrete instance of Skill will be get all creatures and apply something to creature only if necessary. The same with spells etc.
    @Disabled
    void offenceSkillShouldIncreaseDamage() {
        int lowAttack = 50, highAttack = 100;
        Skill offenceSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.OFFENCE));
        Creature creature = Creature.builder().aAttack(Range.closed(lowAttack, highAttack)).build();

        offenceSkill.cast(creature);

        Range<Integer> attackAfterSkill = creature.getAttack();
        assertEquals(Range.closed(55,110), attackAfterSkill);
    }

    @Test
    //TODO: better test name - increaseArmor :) not decrease Damage.
    @Disabled
    void armourSkillShouldDecraseDamage() {
        Skill armourSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.ARMOUR));
        Creature creature = Creature.builder().aArmor(100).build();

        armourSkill.cast(creature);

        assertEquals(110, creature.getArmor());

    }

    @Test
    //TODO mana point not spell point
    void intelligenceShouldIncreaseHeroesMaxPoints() {
//        Hero hero = Hero.builder().aMaxSpellPoints(100).build();
//        Skill intelligenceSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.INTELLIGENCE));
//
//        intelligenceSkill.addSkill(hero);
//
//        assertEquals(125, hero.aCheckSpellPoints());

    }

    @Test
    //TODO looks very bad. Wisdom is totally not generic skill in this case. You should project generic API
    // with this api you have to implement empty method unlockSpellsThirdLvl for each skills (event not necessary)
    void wisdomShouldAllowSpellsBelowThirdLevel() {
//        Skill wisdomSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.WISDOM));
//        Hero hero = Hero.builder().build();
//
//        wisdomSkill.unlockSpellsThirdLvl(hero);
//
//
//        assertEquals(3, hero.aHeroMaxSpells());

    }

}
