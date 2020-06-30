package pl.psi.game.spellbook;

import lombok.Builder;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchyInUncheckedCode;

import java.util.ArrayList;
import java.util.List;

public class SpellBook {
    private int mana;
    private SpellFactory factory;
    private List<Spell> spells;

    @Builder
    public SpellBook (int aHeroMana){
        mana = aHeroMana;
        factory = new SpellFactory();
        spells = new ArrayList<Spell>();
    }
    public int getMana(){
        return mana;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void increaseMana(int aAmount){
        mana += aAmount;
    }

    public void increaseAllSpellsDuration(int additionalDuration){
        spells.forEach(s -> s.increaseDuration(additionalDuration));
    }

    public void addSpells(List<Spell> aSpells){
        aSpells.forEach(s -> spells.add(s));
    }

    public boolean isManaEnough(int requiredMana){
        if(mana >= requiredMana) return true;
        else return false;
    }

    public void decreaseMana(int aAmount){
        mana -= aAmount;
    }


    @Deprecated
    public void createSpell(SpellInfo s)
    {
        spells.add(factory.createSpell(s));
    }
}
