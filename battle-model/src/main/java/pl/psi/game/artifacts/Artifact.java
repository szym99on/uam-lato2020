package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

import java.util.HashMap;

public abstract class Artifact{
    public final static int DEFAULT = 0;
    public final static boolean DEFAULT_HERO_AFFECTION = false;
    public final static String DEFAULT_IMMUNITY = "NONE";
    public final static String HERO_ATTACK = "heroAttack";
    public final static String HERO_DEFENCE = "heroDefence";
    public final static String HERO_POWER = "heroPower";
    public final static String HERO_KNOWLEDGE = "heroKnowledge";
    public final static String CREATURE_SPEED = "creatureSpeed";
    public final static String CREATURE_HEALTH = "creatureHealth";
    public final static String CREATURE_MAGIC_RESISTANCE = "creatureMagicResistance";
    public final static String SPELL_DURATION = "spellDuration";
    protected static String CREATURE_IMMUNITY = "";

    protected HashMap<String, Integer> statisticsBuffs = new HashMap<>();

    public Artifact(){
        statisticsBuffs.put(HERO_ATTACK, DEFAULT);
        statisticsBuffs.put(HERO_DEFENCE, DEFAULT);
        statisticsBuffs.put(HERO_POWER, DEFAULT);
        statisticsBuffs.put(HERO_KNOWLEDGE, DEFAULT);
        statisticsBuffs.put(CREATURE_SPEED, DEFAULT);
        statisticsBuffs.put(CREATURE_HEALTH, DEFAULT);
        statisticsBuffs.put(CREATURE_MAGIC_RESISTANCE, DEFAULT);
        statisticsBuffs.put(SPELL_DURATION, DEFAULT);
    }

    public int showStatisticsBuff(String statisticsName)
    {
        try{
            return statisticsBuffs.get(statisticsName);
        }
        catch(NullPointerException e){
            throw new RuntimeException("This key is invalid", e);
        }
    }

    public String getSpellImmunityName() {
        return CREATURE_IMMUNITY = DEFAULT_IMMUNITY;
    }

    public abstract void apply(Hero aHero);

    public boolean affectsHeroStats() {
        return DEFAULT_HERO_AFFECTION;
    }

}
