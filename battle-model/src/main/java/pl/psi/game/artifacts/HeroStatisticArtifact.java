package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

class HeroStatisticArtifact extends Artifact {
    private final int attack;
    private final int defence;
    private final int power;
    private final int knowledge;


    HeroStatisticArtifact(int aAttack, int aDefence, int aPower, int aKnowledge){
        attack = aAttack;
        defence = aDefence;
        power = aPower;
        knowledge = aKnowledge;

        statisticsBuffs.replace(HERO_ATTACK, attack);
        statisticsBuffs.replace(HERO_DEFENCE, defence);
        statisticsBuffs.replace(HERO_POWER, power);
        statisticsBuffs.replace(HERO_KNOWLEDGE, knowledge);
    }

    @Override
    public boolean affectsHeroStats(){ return true; }

    @Override
    public void apply(Hero aHero) {
        aHero.increaseAttack(attack);
        aHero.increaseDefence(defence);
        aHero.increasePower(power);
        aHero.increaseKnowledge(knowledge);
    }


    @Override
    public String getSpellImmunityName() { return "NONE"; }
}
