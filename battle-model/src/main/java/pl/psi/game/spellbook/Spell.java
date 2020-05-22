package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

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
        //creature.acceptSpell();
    }
}
