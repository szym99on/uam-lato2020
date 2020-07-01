package pl.psi.game.hero.economyHero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.skills.SkillInfo;
import pl.psi.game.skills.SkillInfoFactory;

import static org.junit.jupiter.api.Assertions.*;

public class EconomyHeroSpecialSkillsManagementTests {

    @BeforeAll
    static void initializeFactories(){
        new SkillInfoFactory();
    }

    @Test
    void buyArcherShouldTakeGoldAndAddSkill(){
        SkillInfo skillInfo = SkillInfoFactory.getSkill(SkillInfoFactory.ARCHERY);
        EconomyHero hero = EconomyHero.builder().aGold(3000).build();

        hero.buySkill(skillInfo);

        assertEquals(hero.getGold(),2000);
        assertTrue(hero.getSkills().contains(skillInfo));
        assertEquals(hero.getSkills().size(),1);
    }

    @Test
    void buySorceryShouldTakeGoldAndAddSkill(){
        SkillInfo skillInfo = SkillInfoFactory.getSkill(SkillInfoFactory.SORCERY);
        EconomyHero hero = EconomyHero.builder().aGold(10000).build();

        hero.buySkill(skillInfo);

        assertEquals(hero.getGold(),2000);
        assertTrue(hero.getSkills().contains(skillInfo));
        assertEquals(hero.getSkills().size(),1);
    }

    @Test
    void buyArcherAndDiplomacyShouldTakeGoldAndAddSkill(){
        SkillInfo skillInfo1 = SkillInfoFactory.getSkill(SkillInfoFactory.ARCHERY);
        SkillInfo skillInfo2 = SkillInfoFactory.getSkill(SkillInfoFactory.DIPLOMACY);
        EconomyHero hero = EconomyHero.builder().aGold(3000).build();

        hero.buySkill(skillInfo1);
        assertEquals(hero.getGold(),2000);
        assertTrue(hero.getSkills().contains(skillInfo1));
        assertEquals(hero.getSkills().size(),1);

        hero.buySkill(skillInfo2);
        assertEquals(hero.getGold(),1000);
        assertTrue(hero.getSkills().contains(skillInfo2));
        assertEquals(hero.getSkills().size(),2);
    }

    @Test
    void buyArcherAndDiplomacyAndSorceryShouldTakeGoldAndAddSkill(){
        SkillInfo skillInfo1 = SkillInfoFactory.getSkill(SkillInfoFactory.ARCHERY);
        SkillInfo skillInfo2 = SkillInfoFactory.getSkill(SkillInfoFactory.DIPLOMACY);
        SkillInfo skillInfo3 = SkillInfoFactory.getSkill(SkillInfoFactory.SORCERY);
        EconomyHero hero = EconomyHero.builder().aGold(12000).build();

        hero.buySkill(skillInfo1);
        assertEquals(hero.getGold(),11000);
        assertTrue(hero.getSkills().contains(skillInfo1));
        assertEquals(hero.getSkills().size(),1);

        hero.buySkill(skillInfo2);
        assertEquals(hero.getGold(),10000);
        assertTrue(hero.getSkills().contains(skillInfo2));
        assertEquals(hero.getSkills().size(),2);

        hero.buySkill(skillInfo3);
        assertEquals(hero.getGold(),2000);
        assertTrue(hero.getSkills().contains(skillInfo3));
        assertEquals(hero.getSkills().size(),3);
    }

}
