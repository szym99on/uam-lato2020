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
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefence() { return defence; }

    @Override
    public int getPower() { return power; }

    @Override
    public int getKnowledge() { return knowledge; }

    @Override
    public int getSpeed() { return 0; }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }

    @Override
    public int getDuration() { return 0; }

    @Override
    public String getSpellImmunityName() { return "NONE"; }
}
