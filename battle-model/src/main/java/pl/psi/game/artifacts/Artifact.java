package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

public abstract class Artifact{

    public abstract void apply(Hero aHero);

    public abstract int getAttack();
    public abstract int getDefence();
    public abstract int getPower();
    public abstract int getKnowledge();
    public abstract int getSpeed();
    public abstract int getHealth();
    public abstract int getMagicResistance();
    public abstract int getDuration();

    public abstract boolean affectsHeroStats();
}
