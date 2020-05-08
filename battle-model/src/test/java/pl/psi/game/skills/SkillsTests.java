package pl.psi.game.skills;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SkillsTests {

    @Test
    void offenceSkillShouldIncreaseDamage() {
        int lowAttack = 50, highAttack = 100;
        Skill offenceSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.OFFENCE));
        Creature creature = Creature.builder().aAttack(Range.closed(lowAttack, highAttack)).build();

        offenceSkill.cast(creature);

        Range<Integer> attackAfterSkill = creature.getAttack();
        assertThat(attackAfterSkill).isEqualTo(Range.closed(55,110));
    }

    @Test
    void armourSkillShouldDecraseDamage() {
        Skill armourSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.ARMOUR));
        Creature creature = Creature.builder().aArmor(100).build();

        armourSkill.cast(creature);

        assertEquals(110, creature.getArmor());

    }

    @Test
    void intelligenceShouldIncreaseHeroesMaxPoints() {
        Hero hero = Hero.builder().aMaxSpellPoints(100).build();
        Skill intelligenceSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.INTELLIGENCE));

        intelligenceSkill.addSkill(hero);

        assertEquals(125, hero.aCheckSpellPoints());

    }

    @Test
    void wisdomShouldAllowSpellsBelowThirdLevel() {
        Skill wisdomSkill = new Skill(SkillInfoFactory.getSkill(SkillInfo.SkillType.WISDOM));
        Hero hero = Hero.builder().build();

        wisdomSkill.unlockSpellsThirdLvl(hero);


        assertEquals(3, hero.aHeroMaxSpells());

    }

}
