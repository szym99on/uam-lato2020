package pl.psi.game.fractions;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ArtifactsRequest {

    @Disabled
    @Test
    void shouldReturnCreatureStats(){
        Creature creature = Creature.builder().aAttack(Range.closed(2, 2)).aMaxHp(10).aArmor(5).aMoveRange(2).build();

//        assertEquals(Range.closed(2, 2), creature.getAttack());
//        assertEquals(10, creature.getMaxHP());
//        assertEquals(10, creature.getCurrentHP());
//        assertEquals(5, creature.getArmor());
//        assertEquals(2, creature.getMoveRange());
    }

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
    void shouldIncreaseMoveRange(){
        Creature creature = Creature.builder().aMoveRange(2).build();

//        creature.increaseMoveRange(2);

//        assertEquals(4,creature.getMoveRange());
    }

    @Disabled
    @Test
    void shouldIncreaseHP(){
        Creature dummyCreature = Creature.builder().aMaxHp(10).build();
        Creature attacker = Creature.builder().aAttack(Range.closed(1,1)).build();
        attacker.attack(dummyCreature); //reducing dummy's current HP for test purposes

//        dummyCreature.increaseHP(2); //increasing HP should affect both max and current HP. It should also not allow current HP to exceed max HP.

//        assertEquals(12, dummyCreature.getMaxHP());
//        assertEquals(11, dummyCreature.getCurrentHP());
    }

}
