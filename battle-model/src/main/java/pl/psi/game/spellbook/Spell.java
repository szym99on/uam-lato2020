package pl.psi.game.spellbook;

import lombok.Builder;
import lombok.Getter;
import pl.psi.game.fractions.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
//PW Spell should be abstract and make new class DamageSpell instead of.
//Make abstract method cast here, so your child like Buff or Damage will have to implement this and you can use POLIMORPHISM then.
//cast point against creature will be better (easier to implement integration with board and make some splash damage)

@Getter
public abstract class Spell implements PropertyChangeListener, Cloneable {

    protected final  String name;
    private final String description;
    private final int level;
    protected int duration;
    private int cost;
    private int manaCost;
    private SpellInfo.Type type;
    private final SpellInfo.Target target;

    //@Builder
    public Spell (String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, int aDuration, SpellInfo.Target aTarget) {
        name = aName;
        description = aDescription;
        level = aLevel;
        duration = aDuration;
        cost = aCost;
        manaCost = aManaCost;
        type = aType;
        target = aTarget;
    }

    abstract public Object clone();

    public String getSpellName(){
        return name;
    }

    abstract public void cast (int x, int y);

    abstract public void cast (Creature creature);

    public void increaseDuration(int aAdditionalDuration)
    {
//        Implementation only in Buff and Debuf sells
    }

    public boolean needObserver() {
        return false;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent)
    {
//        Implementation only in Buff and Debuf sells
    }
}
