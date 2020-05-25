package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BuffDebufSpell extends Spell implements PropertyChangeListener {

    private int expireIn;
    private Creature creature;

//    @Builder
    public BuffDebufSpell (String aName, String aDescription, int aCost, int aTier, int aManaCost, SpellInfo.Type aType, String aDuration) {
        super(aName,aDescription,aCost,aTier,aManaCost,aType,aDuration);
    }

    @Override
    public void cast(int x, int y)
    {
        //cast(Board.getCreature(x,y));
    }

    @Override
    public void cast(Creature aCreature)
    {
        creature=aCreature;
        int power = 1; //Have to be replace by hero.getPower
        int expireIn = power;

        switch (name){
            case "Haste":
//                creature.addToBuffSet(this);
//                creature.increaseMoveRange(3);
                break;
        }
    }

    //listen END_OF_TURN
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent)
    {
        expireIn--;
        if(expireIn==0){
            removeSpell();
        }
    }

    public void removeSpell(){
        switch (name){
            case "Haste":
//                creature.decreaseMoveRange(3);
//                creature.removeFromSet(this);
                break;
        }
    }
}
