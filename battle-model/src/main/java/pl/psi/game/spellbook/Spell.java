package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.fractions.Creature;
//PW Spell should be abstract and make new class DamageSpell instead of.
//Make abstract method cast here, so your child like Buff or Damage will have to implement this and you can use POLIMORPHISM then.
//cast point against creature will be better (easier to implement integration with board and make some splash damage)
public class Spell {

    protected final String name;
    private final String description;
    private final int tier;
    private String duration;
    private int cost;
    private int manaCost;
    private SpellInfo.Type type;

    @Builder
    public Spell (String aName, String aDescription, int aCost, int aTier, int aManaCost, SpellInfo.Type aType, String aDuration) {
        name = aName;
        description = aDescription;
        tier = aTier;
        duration = aDuration;
        cost = aCost;
        manaCost = aManaCost;
        type = aType;
    }


    public void cast (int x, int y){

    }

    public void cast (Creature creature){

    }
}
