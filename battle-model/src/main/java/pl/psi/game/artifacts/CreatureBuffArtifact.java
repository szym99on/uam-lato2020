package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

abstract class CreatureBuffArtifact extends Artifact {

    @Override
    public void apply(Hero aHero) {
        aHero.getCreatures().forEach(c -> buffCreature(c));
    }

    abstract void buffCreature(Creature c);

    @Override
    public int getAttack() { return 0; }

    @Override
    public int getDefence() { return 0; }

    @Override
    public int getPower() { return 0; }

    @Override
    public int getKnowledge() { return 0; }

}
