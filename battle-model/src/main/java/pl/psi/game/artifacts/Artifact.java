package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

import java.util.HashMap;

public abstract class Artifact{
    public final static int DEFAULT = 0;
    public final static String HERO_ATTACK = "heroAttack";
    public final static String HERO_DEFENCE = "heroDefence";
    public final static String HERO_POWER = "heroPower";
    public final static String HERO_KNOWLEDGE = "heroKnowledge";
    public final static String CREATURE_SPEED = "creatureSpeed";
    public final static String CREATURE_HEALTH = "creatureHealth";
    public final static String CREATURE_MAGIC_RESISTANCE = "creatureMagicResistance";

    public HashMap<String, Integer> statisticsBuffs = new HashMap<>();

    public Artifact(){
        statisticsBuffs.put(HERO_ATTACK, DEFAULT);
        statisticsBuffs.put(HERO_DEFENCE, DEFAULT);
        statisticsBuffs.put(HERO_POWER, DEFAULT);
        statisticsBuffs.put(HERO_KNOWLEDGE, DEFAULT);
        statisticsBuffs.put(CREATURE_SPEED, DEFAULT);
        statisticsBuffs.put(CREATURE_HEALTH, DEFAULT);
        statisticsBuffs.put(CREATURE_MAGIC_RESISTANCE, DEFAULT);
    }

    public abstract void apply(Hero aHero);
    public abstract int getSpeed();
    public abstract int getHealth();
    public abstract int getMagicResistance();
    public abstract int getDuration();
    public abstract String getSpellImmunityName();
    public abstract boolean affectsHeroStats();

}
