package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

public class DamageSpell extends Spell{

    private int spellDamage;
    private Creature creature;

    @Builder
    public DamageSpell(String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, SpellInfo.Target aTarget, int aDuration, int aSpellDamage) {
        super(aName, aDescription, aCost, aLevel, aManaCost, aType, aDuration,aTarget);
        spellDamage = aSpellDamage;
    }

    @Override
    public Object clone()
    {
        return new DamageSpell(this.getName(),this.getDescription(),this.getCost(),this.getLevel(),this.getManaCost(),this.getType(),this.getTarget(),this.getDuration(),this.spellDamage);
    }

    @Override
    public void cast(int x, int y) {

        cast(Board.getBoard().getCreature(x,y));
        if(name.equals(SpellBookInfoFactory.FIRE_BALL)  || name.equals(SpellBookInfoFactory.METEOR_SHOWER)){
//             1 2 3
//           1 . c .
//           2 . T .
//           3 . . .
            if(Board.getBoard().getCreature(x,y-1) != null)
                cast(Board.getBoard().getCreature(x,y-1));
//             1 2 3
//           1 . . .
//           2 . T .
//           3 . c .
//           y
            if(Board.getBoard().getCreature(x,y+1) != null)
                cast(Board.getBoard().getCreature(x,y+1));
//             1 2 3
//           1 . . .
//           2 c T .
//           3 . . .
            if(Board.getBoard().getCreature(x-1,y) != null)
                cast(Board.getBoard().getCreature(x-1,y));
//             1 2 3 x
//           1 . . .
//           2 . T c
//           3 . . .
//           y
            if(Board.getBoard().getCreature(x+1,y) != null)
                cast(Board.getBoard().getCreature(x+1,y));
        }
    }


    @Override
    public void cast(Creature aCreature) {

        creature = aCreature;
        switch (getName()){
            case SpellBookInfoFactory.MAGIC_ARROW:
            case SpellBookInfoFactory.LIGHTNING_BOLT:
            case SpellBookInfoFactory.FIRE_BALL:
            case SpellBookInfoFactory.METEOR_SHOWER:
            case SpellBookInfoFactory.IMPLOSION:
                if(isNotImmuneToType() && isNotImmuneToSpell()){
                    creature.takePureDamage((int) (spellDamage * percentageSpellImmunity()));
                }
                break;
            //TODO isUndead (no implementation from Fractions)
            case SpellBookInfoFactory.DESTROY_UNDEAD:
//                for (Creature c: gameEngine.getActiveHero().getCreatures()) {
//                    if(c.isUndead()){
//                        c.takePureDamage((int) (spellDamage * percentageSpellImmunity()));
//                    }
//                }
                if(creature.isUndead()){
                    if(isNotImmuneToType()){
                        creature.takePureDamage((int) (spellDamage * percentageSpellImmunity()));
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("This spell doesn't exist");
        }
    }


    //TODO do poprawy equals(ENUMS)
    private boolean isNotImmuneToType(){

        return !creature.getMagicResistance().getGroupImmunityType().toString().startsWith(SpellBookInfoFactory.getSpell(name).getType().toString());
    }

    private boolean isNotImmuneToSpell(){
        return !creature.getMagicResistance().isImmuneToSpell(name);
    }

    private double percentageSpellImmunity(){
        return (1-(0.01*creature.getMagicResistance().getAllSpellsResistancePercentage()));
    }
}
