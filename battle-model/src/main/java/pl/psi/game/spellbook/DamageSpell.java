package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

public class DamageSpell extends Spell{

    private int spellDamage;
    private Creature creature;
    private Hero hero;

    @Builder
    public DamageSpell(String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, int aDuration, int aSpellDamage) {
        super(aName, aDescription, aCost, aLevel, aManaCost, aType, aDuration);
        spellDamage = aSpellDamage;
    }

    @Override
    public Object clone()
    {
        return new DamageSpell(this.getName(),this.getDescription(),this.getCost(),this.getLevel(),this.getManaCost(),this.getType(),this.getDuration(),this.spellDamage);
    }

    @Override
    public void cast(int x, int y) { cast(Board.getBoard().getCreature(x,y)); }

    @Override
    public void cast(Creature aCreature) {

        creature = aCreature;
        if(name.equals(SpellBookInfoFactory.MAGIC_ARROW)){
            //aCreature.attack(aCreature);
        }
        if(name.equals(SpellBookInfoFactory.LIGHTNING_BOLT)){
            //damage
        }
        if(name.equals(SpellBookInfoFactory.DESTROY_UNDEAD)){
            //damage
        }
        if(name.equals(SpellBookInfoFactory.FIRE_BALL)){
            //damage
        }
        if(name.equals(SpellBookInfoFactory.METEOR_SHOWER)){
            //damage
        }
        if(name.equals(SpellBookInfoFactory.IMPLOSION)){
            //damage
        }
    }
}
