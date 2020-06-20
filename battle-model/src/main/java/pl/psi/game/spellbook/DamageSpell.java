package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

public class DamageSpell extends Spell{

    private int damageToDeal;
    private Creature creature;
    private Hero hero;
    private String name;


    @Builder
    public DamageSpell(String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, int aDuration, int aDamageToDeal) {
        super(aName, aDescription, aCost, aLevel, aManaCost, aType, aDuration);
        //damageToDeal = aDamageToDeal;
        name = aName;
    }

    @Override
    public Object clone()
    {
        return new DamageSpell(this.getName(),this.getDescription(),this.getCost(),this.getLevel(),this.getManaCost(),this.getType(),this.getDuration(),this.damageToDeal);
    }

    @Override
    public void cast(int x, int y) { cast(Board.getBoard().getCreature(x,y)); }

    @Override
    public void cast(Creature aCreature) {

        creature = aCreature;
        if(name.equals(SpellBookInfoFactory.MAGIC_ARROW)){
            //damageToDeal;
        }
        if(name.equals(SpellBookInfoFactory.LIGHTNING_BOLT)){ }
        if(name.equals(SpellBookInfoFactory.DESTROY_UNDEAD)){ }
        if(name.equals(SpellBookInfoFactory.FIRE_BALL)){ }
        if(name.equals(SpellBookInfoFactory.METEOR_SHOWER)){ }
        if(name.equals(SpellBookInfoFactory.IMPLOSION)){ }
    }
}
