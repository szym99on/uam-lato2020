package pl.psi.game.hero;

import lombok.Builder;

public class HeroInfo {
    private final int heroAttack;
    private final int heroDefence;
    private final int heroPower;
    private final int heroKnowledge;
    private final String name;
    private final Fraction fraction;
    public enum Fraction{
        CASTLE,
        TOWER,
        INFERNO,
        FORTRESS,
        RAMPART,
        DUNGEON,
        STRONGHOLD,
        NECROPOLIS,
        CONFLUX
    }
    private final FractionClass fractionClass;
    public enum FractionClass{
        KNIGHT(2,2,1,1),
        CLERIC(1,0,2,2),
        RANGER(1,3,1,1),
        DRUID(0,2,1,2),
        ALCHEMIST(1,1,2,2),
        WIZARD(0,0,2,3),
        DEMONIAC(2,2,1,1),
        HERETIC(1,1,2,1),
        DEATH_KNIGHT(1,2,2,1),
        NECROMANCER(1,0,2,2),
        OVERLORD(2,2,1,1),
        WARLOCK(0,0,3,2),
        BARBARIAN(4,0,1,1),
        BATTLE_MAGE(2,1,1,1),
        BEASTMASTER(0,4,1,1),
        WITCH(0,1,2,2),
        PLANESWALKER(3,1,1,1),
        ELEMENTALIS(0,0,3,3);
        final int attack;
        final int defence;
        final int power;
        final int knowledge;
        private FractionClass(int aAttack, int aDefence, int aPower, int aKnowledge)
        {
            attack=aAttack;
            defence=aDefence;
            power=aPower;
            knowledge=aKnowledge;
        }
    }

    @Builder
    public HeroInfo(String aName, Fraction aFraction, FractionClass aFractionClass){
        heroAttack = aFractionClass.attack;
        heroDefence = aFractionClass.defence;
        heroPower = aFractionClass.power;
        heroKnowledge = aFractionClass.knowledge;
        name = aName;
        fraction = aFraction;
        fractionClass = aFractionClass;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public String getName() {
        return name;
    }
    public int getAttack() {
        return heroAttack;
    }
    public int getDefence() {
        return heroDefence;
    }
    public int getPower() {
        return heroPower;
    }
    public int getKnowledge() {
        return heroKnowledge;
    }
}
