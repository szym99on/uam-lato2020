package pl.psi.game.fractions;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.spellbook.Spell;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellBookRequest {
/*
    @Test
    void creatureShouldReturnActiveEffects(){
        Collection<Spell> activeEffects = Creature.getActiveEffects();

    }

    @Test
    void creatureShouldAcceptSpell(){
        Creature creature = Creature.builder().build();
        Spell spell = Spell.builder().build();

        Creature.addEffect(spell);
    }

    Jest kilka czarów które działają na klikniętą jednostkę oraz na jednostki okoliczne
    Nie mam obecnie pomysłu jak można by to rozwiązać ...
*/
    @Test
    @Disabled
    void creatureShouldIncreaseMoveRange(){
        Creature creature = Creature.builder().aMoveRange(3).build();

//        creature.increaseMoveRange(3);

        assertEquals(6,creature.getMoveRange());
    }

    @Test
    @Disabled
    void creatureShouldDecreaseMoveRange(){
        Creature creature = Creature.builder().aMoveRange(6).build();

//        creature.decreaseMoveRange(3);

        assertEquals(3,creature.getMoveRange());
    }

    @Test
    @Disabled
    void creatureShouldIncreaseArmor(){
        Creature creature = Creature.builder().aArmor(3).build();

//        creature.increaseArmor(3);

        assertEquals(6,creature.getArmor());
    }

    @Test
    @Disabled
    void creatureShouldDecreaseArmor(){
        Creature creature = Creature.builder().aArmor(6).build();

//        creature.decreaseArmor(3);

        assertEquals(3,creature.getArmor());
    }
    @Test
    @Disabled
    void creatureShouldIncreaseAttack(){
        Creature creature = Creature.builder().aAttack(Range.closed(3,3)).build();

//        creature.increaseAttack(3);

        assertEquals(Range.closed(6,6),creature.getAttack());
    }

    @Test
    @Disabled
    void creatureShouldDecreaseAttack(){
        Creature creature = Creature.builder().aAttack(Range.closed(6,6)).build();

//        creature.increaseMoveRange(3);

        assertEquals(Range.closed(3,3),creature.getAttack());
    }


}
