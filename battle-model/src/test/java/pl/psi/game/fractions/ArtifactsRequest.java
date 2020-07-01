package pl.psi.game.fractions;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ArtifactsRequest {

    @Disabled
    @Test
    void shouldIncreaseMagicResistance(){
        // There are artifacts that reduce incoming magic damage onto creatures by 10% or 15%.
        // There has to be a way to apply that on creatures.
        // Perhaps it could be implemented as another stat (maybe similar to armor?).
    }

    @Disabled
    @Test
    void shouldGrantImmunityToBerserkSpell(){
        // There are artifacts that target specific spells, making your creatures immune to their effects.
        // There has to be a way to apply that on creatures.
        // This immunity only relates to the specific spell - in this case the Berserk Spell.
    }

    @Disabled
    @Test
    void shouldGrantImmunityToDeathRipple(){
        // There are artifacts that target specific spells, making your creatures immune to their effects.
        // There has to be a way to apply that on creatures.
        // This immunity only relates to the specific spell - in this case the Death Ripple Spell.
    }


    @Test
    void shouldIncreaseMoveRange(){
        Creature creature = Creature.builder().aMoveRange(2).build();
        creature.increaseMoveRange(2);
        assertEquals(4,creature.getMoveRange());
    }

    @Test
    void shouldIncreaseHP(){
        Creature dummyCreature = new Creature(10, Range.closed(1, 1), 0, "", 0, false,0);
        Creature attacker = new Creature(10, Range.closed(1, 1), 0, "", 0, false,0);
        attacker.attack(dummyCreature); //reducing dummy's current HP for test purposes
        dummyCreature.increaseHP(2); //increasing HP should affect both max and current HP. It should also not allow current HP to exceed max HP.
        assertEquals(12, dummyCreature.getMaxHp());
        assertEquals(11, dummyCreature.getCurrentHp());
    }

}
