package pl.psi.game.fractions;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    private final static int NOT_IMPORTANT_1 = 1;
    private final static Range<Integer> NOT_IMPORTANT_RANGE = Range.closed(1, 1);
    private final static int NOT_IMPORTANT_0 = 0;
    private final static boolean NOT_IMPORTANT_FALSE = false;

    @Test
    void creatureOneShouldLostTwoHp() {
        Creature c1 = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        Creature c2 = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);

        c2.attack(c1);

        assertEquals(8, c1.getCurrentHp());
    }

    @Test
    void creatureShouldLostOneHpBecauseHasOneDefence() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, 1, "", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(NOT_IMPORTANT_1, Range.closed(2, 2), NOT_IMPORTANT_1, "", 0, NOT_IMPORTANT_FALSE);

        attacker.attack(defender);

        assertEquals(9, defender.getCurrentHp());
    }

    @Test
    void creatureShouldNotHealAfterDefendWeakerCreature() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(NOT_IMPORTANT_RANGE).aArmor(100).build();
        Creature attacker = new Creature(NOT_IMPORTANT_1, Range.closed(50, 50), NOT_IMPORTANT_1, "", 0, NOT_IMPORTANT_FALSE);

        attacker.attack(defender);

        assertEquals(9, defender.getCurrentHp());
    }

    @Test
    void creatureShouldCounterAttack() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).build();
        Creature attacker = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).build();

        attacker.attack(defender);

        assertEquals(9, attacker.getCurrentHp());
    }

    @Test
    void defenderCreatureShouldCounterAttackOnlyOncePerTurn() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).build();
        Creature attacker = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).build();

        attacker.attack(defender);
        attacker.attack(defender);

        assertEquals(9, attacker.getCurrentHp());
    }

    @Test
    void polimorphismExample() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(Range.closed(1, 1)).aArmor(1).build();
        Creature attacker = Creature.builder().aMaxHp(10).aAttack(Range.closed(1, 1)).aArmor(1).build();
        ShootingCreature attackerShooter = new ShootingCreature(10, Range.closed(1, 1), 1, "", 0, NOT_IMPORTANT_FALSE);

        List<Creature> creatureList = new ArrayList<>();
        creatureList.add(attackerShooter);
        creatureList.add(attacker);

        creatureList.forEach(c -> c.attack(defender));
        assertEquals(8, defender.getCurrentHp());
        assertEquals(10, attackerShooter.getCurrentHp());
        assertEquals(9, attacker.getCurrentHp());
    }

    @Test
    @Disabled
    void checkRandomWithMock() {
        Creature defender = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(0).build();
        Creature attacker = new Creature(10, Range.closed(1, 100), 0);

        attacker.attack(defender);

        assertEquals(89, defender.getCurrentHp());
    }

    @Test
    void creatureShouldIgnoreArmorWithCorrectStrategy(){
        Creature defender = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(50).build();
        Creature attacker = new Creature(10, Range.closed(100, 100), 0);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithIgnoreArmorStrategy());

        attacker.attack(defender);

        assertEquals(0, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToAirElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Storm Elemental", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToAirElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToEarthElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Magma Elemental", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToEarthElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToFireElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Energy Elemental", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToFireElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToWaterElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Ice Elemental", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToWaterElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamage() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldHealAfterAttack() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(10, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithHealStrategy());
        attacker.setCurrentHp(5);
        defender.setCanCounterAttacked(false);

        attacker.attack(defender);

        assertEquals(7, attacker.getCurrentHp());
    }
    
    @Test
    void creatureShouldIgnore80PercentArmor() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, 10, "", 0, NOT_IMPORTANT_FALSE);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(10, 10), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithIgnore80PercentArmorStrategy());

        attacker.attack(defender);

        assertEquals(2, defender.getCurrentHp());
    }

}