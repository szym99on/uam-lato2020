package pl.psi.game.spellbook;

import java.util.ArrayList;
import java.util.List;

public class SpellBook {
    private int heroPower;
    private int additionalDuration=0;
    private SpellFactory factory;
    private List<Spell> spellList;

    public SpellBook (int aHeroPower, int aHeroMana, List<Spell> aHeroSpells){
        heroPower = aHeroPower;
        factory = new SpellFactory();
        spellList = aHeroSpells;
    }


    public List<Spell> getHeroSpells() {
        return spellList;
    }
}
