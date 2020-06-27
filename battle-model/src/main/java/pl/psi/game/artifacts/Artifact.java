package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

import java.util.HashMap;

public abstract class Artifact{
    public final static int DEFAULT = 0;
    public HashMap<String, Integer> statisticsBuffs = new HashMap<>();

    public Artifact(){
        statisticsBuffs.put("heroAttack", DEFAULT);
    }

    public abstract void apply(Hero aHero);
    public abstract int getAttack();
    public abstract int getDefence();
    public abstract int getPower();
    public abstract int getKnowledge();
    public abstract int getSpeed();
    public abstract int getHealth();
    public abstract int getMagicResistance();
    public abstract int getDuration();
    public abstract String getSpellImmunityName();
    public abstract boolean affectsHeroStats();

}
