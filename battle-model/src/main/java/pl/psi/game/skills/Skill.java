package pl.psi.game.skills;

import pl.psi.game.hero.converter.Hero;

public class Skill {

    private SkillInfo skillInfo;

    public Skill(SkillInfo skillInfo) {
        this.skillInfo = skillInfo;
    }

    public void addSkill(Hero hero) {};

    public void cast(Hero hero) {};

    public void unlockSpellsThirdLvl(Hero hero) {};

}
