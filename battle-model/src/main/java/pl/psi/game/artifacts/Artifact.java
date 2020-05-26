package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

public abstract class Artifact{

    public abstract void apply(Hero aHero);

    public abstract int getAttack();
}
