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
        } catch (Exception e) {
//            alert();
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
        if(name.equals(SpellBookInfoFactory.MAGIC_ARROW)){ creature.takePureDamage(spellDamage); }
        if(name.equals(SpellBookInfoFactory.LIGHTNING_BOLT)){ creature.takePureDamage(spellDamage); }
        if(name.equals(SpellBookInfoFactory.IMPLOSION)){ creature.takePureDamage(spellDamage); }
        if(name.equals(SpellBookInfoFactory.FIRE_BALL)){ creature.takePureDamage(spellDamage); }
        if(name.equals(SpellBookInfoFactory.METEOR_SHOWER)){ creature.takePureDamage(spellDamage); }

        if(name.equals(SpellBookInfoFactory.DESTROY_UNDEAD)){
            //TODO isUndead
            creature.takePureDamage(spellDamage);
        }

    }

//    void alert(){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("You have to choose a creature to use this spell");
//        alert.showAndWait();
//    }
}
