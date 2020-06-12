package pl.psi.game.spellbook;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class SpellBook {
    private int heroPower;
    private int additionalDuration=0;
    private SpellFactory factory;
    private List<Spell> spells;

    @Builder
    public SpellBook (int aHeroPower, int aHeroMana, List<Spell> aHeroSpells){
        heroPower = 0;
        factory = new SpellFactory();
    }
    public void increaseSpellDuration (int aAdditionalDuration){
        if(aAdditionalDuration >= 0)
        {
            additionalDuration = additionalDuration + aAdditionalDuration;
        }
        else throw new IllegalArgumentException("You can't increase by a negative value");
    }

    public void createSpell (SpellInfo spellInfo)
    {
        spells.add(factory.createSpell(spellInfo,heroPower,additionalDuration));
    }

    public List<Spell> getSpells()
    {
        return new ArrayList<>(spells);
    }
    public void increaseHeroPower(int amount)
    {
        heroPower+=amount;
    }

}
