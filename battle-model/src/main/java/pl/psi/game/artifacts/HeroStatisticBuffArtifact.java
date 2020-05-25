package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

class HeroStatisticBuffArtifact extends Artifact {
    private final int attack;
    private final int defence;
    private final int power;
    private final int knowledge;


    HeroStatisticBuffArtifact(int aAttack, int aDefence, int aPower, int aKnowledge){
        attack = aAttack;
        defence = aDefence;
        power = aPower;
        knowledge = aKnowledge;
    }

    @Override
    public void apply(Hero aHero) {

    }
}
