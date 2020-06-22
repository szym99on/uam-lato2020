package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

public class DamageSpell extends Spell{

    private int spellDamage;
    private Creature creature;

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
            creature.dealSpealDamage(spellDamage);
        }
        if(name.equals(SpellBookInfoFactory.LIGHTNING_BOLT)){
            creature.dealSpealDamage(spellDamage);
        }
        if(name.equals(SpellBookInfoFactory.DESTROY_UNDEAD)){

            creature.dealSpealDamage(spellDamage);
        }
        if(name.equals(SpellBookInfoFactory.FIRE_BALL)){

            creature.dealSpealDamage(spellDamage);
            // + dmg dla okolicznych jednostek
        }
        if(name.equals(SpellBookInfoFactory.METEOR_SHOWER)){
            creature.dealSpealDamage(spellDamage);
            // + dmg dla okolicznych jednostek
        }
        if(name.equals(SpellBookInfoFactory.IMPLOSION)){
            creature.dealSpealDamage(spellDamage);
        }
    }
}
