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
        spells = aHeroSpells;
    }


    public List<Spell> getSpells() {
        return spells;
    }

    public void increaseHeroPower(int amount)
    {
        heroPower+=amount;
    }

    public void createSpell(SpellInfo s)
    {
        spells.add(factory.createSpell(s));
    }
}
