package pl.psi.game.hero;

import lombok.Builder;

public class HeroInfo {
    private final int attack;
    private final int defense;
    private final int knowledge;
    private final int power;
    private final String name;
    private final String fraction;

    @Builder
    public HeroInfo(int aAttack, int aDefense, int aPower, int aKnowledge, String aName, String aFraction){
        attack = aAttack;
        defense = aDefense;
        power = aPower;
        knowledge = aKnowledge;
        name = aName;
        fraction = aFraction;
    }

    public String getFraction() {
        return fraction;
    }

    public String getName() {
        return name;
    }
}
