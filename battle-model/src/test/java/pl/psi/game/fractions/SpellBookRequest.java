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
    void creatureShouldIncreaseMoveRange(){
        Creature creature = Creature.builder().aMoveRange(3).build();
        creature.increaseMoveRange(3);
        assertEquals(6,creature.getMoveRange());
    }

    @Test
    void creatureShouldDecreaseMoveRange(){
        Creature creature = Creature.builder().aMoveRange(6).build();
        creature.decreaseMoveRange(3);
        assertEquals(3,creature.getMoveRange());
    }

    @Test
    void creatureShouldIncreaseArmor(){
        Creature creature = Creature.builder().aArmor(3).build();
        creature.increaseArmor(3);
        assertEquals(6,creature.getArmor());
    }

    @Test
    void creatureShouldDecreaseArmor(){
        Creature creature = Creature.builder().aArmor(6).build();
        creature.decreaseArmor(3);
        assertEquals(3,creature.getArmor());
    }
    @Test
    @Disabled
    void creatureShouldIncreaseAttack(){
        Creature creature = Creature.builder().aAttack(Range.closed(3,3)).build();
        creature.increaseAttack(3);
        assertEquals(Range.closed(6,6),creature.getAttack());
    }

    @Test
    void creatureShouldDecreaseAttack(){
        Creature creature = Creature.builder().aAttack(Range.closed(6,6)).build();
        creature.decreaseAttack(3);
        assertEquals(Range.closed(3,3),creature.getAttack());
    }

    @Test
    @Disabled
    void creatureShouldReceiveLessDamageFromRangedAttacks(){
        Creature attacker = ShootingCreature.builder().aAttack(Range.closed(8,8)).build();
        Creature defender1 = Creature.builder().aArmor(0).aMaxHp(20).build();
        Creature defender2 = Creature.builder().aArmor(0).aMaxHp(20).build();

      //  defender1.setReduceRangedDamageByPercentage(25);


        attacker.attack(defender1);
        attacker.attack(defender2);

        assertEquals(14,defender1.getCurrentHp());
        assertEquals(12,defender2.getCurrentHp());

//        defender1.removeReduceRangedDamageByPercentage(25);
        attacker.attack(defender1);

        assertEquals(6,defender1.getCurrentHp());
    }


    @Test
    @Disabled
    void defenderShouldGiveBackPercentageCloseRangedDamage(){
        Creature attacker = Creature.builder().aAttack(Range.closed(10,10)).aArmor(0).aMaxHp(20).build();
        Creature defender1 = Creature.builder().aAttack(Range.closed(0,0)).aArmor(0).aMaxHp(20).build();

//        FireShield
//        defender1.setReturnPercentageDamageDealt(20);
        attacker.attack(defender1);
//        defender.removeReturnPercentageDamageDealt(20);

        assertEquals(18,attacker.getCurrentHp());
    }

    @Test
    @Disabled
    void creatureShouldBeResistantToLevelSpells (){
        Creature creature = Creature.builder().build();

//        creature.setLevelMagicResistant(1);
//        creature.setLevelMagicResistant(2);
//        creature.setLevelMagicResistant(3);

//        creature.removeLevelMagicResistant(1);
//        creature.removeLevelMagicResistant(2);
//        creature.removeLevelMagicResistant(3);
    }

}
