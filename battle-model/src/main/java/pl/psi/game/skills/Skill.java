package pl.psi.game.skills;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

public class Skill {

    private SkillInfo skillInfo;

    public Skill(SkillInfo skillInfo) {
        this.skillInfo = skillInfo;
    }

    public void addSkill(Hero hero) {};

    public void cast(Creature creature) {};

    public void unlockSpellsThirdLvl(Hero hero) {};

}
