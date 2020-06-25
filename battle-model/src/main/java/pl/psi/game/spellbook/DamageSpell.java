package pl.psi.game.spellbook;

//import javafx.scene.control.Alert;
import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

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
    public void cast(int x, int y) {

        try {
            cast(Board.getBoard().getCreature(x,y));
        } catch (NullPointerException e) {
            //e.printStackTrace();
            //alert();
        }

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
//        switch (name) {
//            case SpellBookInfoFactory.MAGIC_ARROW:
//            case SpellBookInfoFactory.LIGHTNING_BOLT:
//            case SpellBookInfoFactory.IMPLOSION:
//            case SpellBookInfoFactory.FIRE_BALL:
//            case SpellBookInfoFactory.METEOR_SHOWER:
//                magicImmunityDamage();
//                break;
//            case SpellBookInfoFactory.DESTROY_UNDEAD:
//                //TODO isUndead
//                creature.takePureDamage(spellDamage);
//                break;
//        }
        if(isNotImmuneToType(SpellBookInfoFactory.getSpell(name).getType()) && isNotImmuneToSpell(name)){
            creature.takePureDamage((int) (spellDamage * percentageSpellImmunity()));
        }
    }


//    void alert(){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("You have to choose a creature to use this spell");
//        alert.showAndWait();
//    }

    //TODO do poprawy equals(ENUMS)
    private boolean isNotImmuneToType(Enum spellType){
        return !creature.getMagicResistance().getGroupImmunityType().toString().startsWith(spellType.toString());
    }

    private boolean isNotImmuneToSpell(String spellName){
        return !creature.getMagicResistance().isImmuneToSpell(spellName);
    }

    private double percentageSpellImmunity(){
        return (1-(0.01*creature.getMagicResistance().getAllSpellsResistancePercentage()));
    }
}
