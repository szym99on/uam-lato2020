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
    public boolean affectsHeroStats(){ return false; }

    @Override
    public int getDuration() { return 0; }
}
