package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

public class Spell {
    @Builder
    public Spell (String aName) {

    }

    //TODO: cast(Point) zaklęcia będą rzucane na pole.
    void cast(Creature creature){
        //creature.acceptSpell();
    }
}
