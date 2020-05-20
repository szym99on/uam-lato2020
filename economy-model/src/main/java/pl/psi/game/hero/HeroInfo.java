package pl.psi.game.hero;

import lombok.Builder;

public class HeroInfo {
    private final int heroAttack;
    private final int heroDefense;
    private final int heroPower;
    private final int heroKnowledge;
    private final String name;
    private final Fraction fraction;
    public enum Fraction{
        STRONGHOLD,
        NECROPOLIS,
        RAMPART
    }
    private final FractionClass fractionClass;
    public enum FractionClass{
        Knight(2,2,1,1),
        Cleric(1,0,2,2),
        Ranger(1,3,1,1),
        Druid(0,2,1,2),
        Alchemist(1,1,2,2),
        Wizard(0,0,2,3),
        Demoniac(2,2,1,1),
        Heretic(1,1,2,1),
        DeathKnight(1,2,2,1),
        Necromancer(1,0,2,2),
        Overlord(2,2,1,1),
        Warlock(0,0,3,2),
        Barbarian(4,0,1,1),
        BattleMage(2,1,1,1),
        Beastmaster(0,4,1,1),
        Witch(0,1,2,2),
        Planeswalker(3,1,1,1),
        Elementalis(0,0,3,3);
        final int attack;
        final int defense;
        final int power;
        final int knowledge;
        private FractionClass(int aAttack, int aDefense, int aPower, int aKnowledge)
        {
            attack=aAttack;
            defense=aDefense;
            power=aPower;
            knowledge=aKnowledge;
        }
    }

    @Builder
    public HeroInfo(String aName, Fraction aFraction, FractionClass aFractionClass){
        heroAttack = aFractionClass.attack;
        heroDefense = aFractionClass.defense;
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
    public int getDefense() {
        return heroDefense;
    }
    public int getPower() {
        return heroPower;
    }
    public int getKnowledge() {
        return heroKnowledge;
    }
}
