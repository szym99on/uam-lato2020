package pl.psi.game.spellbook;

import java.util.ArrayList;
import java.util.List;

public class SpellBook {
    private int heroPower;
    private int additionalDuration=0;
    private SpellFactory factory;

    public SpellBook (int aHeroPower){
        heroPower = aHeroPower;
        factory = new SpellFactory();
    }

    public void increaseSpellDuration (int aAdditionalDuration){
        if(aAdditionalDuration >= 0)
        {
            additionalDuration = additionalDuration + aAdditionalDuration;
        }
        else throw new IllegalArgumentException("You can't increase by a negative value");
    }

    public Spell createSpell (SpellInfo spellInfo)
    {
        return factory.createSpell(spellInfo,heroPower,additionalDuration);
    }

}
