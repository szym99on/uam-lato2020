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
        Creature c1 = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature c2 = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);

        c2.attack(c1);

        assertEquals(8, c1.getCurrentHp());
    }

    @Test
    void creatureShouldLostOneHpBecauseHasOneDefence() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, 1, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(NOT_IMPORTANT_1, Range.closed(2, 2), NOT_IMPORTANT_1, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);

        attacker.attack(defender);

        assertEquals(9, defender.getCurrentHp());
    }

    @Test
    void creatureShouldNotHealAfterDefendWeakerCreature() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(NOT_IMPORTANT_RANGE).aAmount(1).aArmor(100).build();
        Creature attacker = new Creature(NOT_IMPORTANT_1, Range.closed(50, 50), NOT_IMPORTANT_1, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);

        attacker.attack(defender);

        assertEquals(9, defender.getCurrentHp());
    }

    @Test
    void creatureShouldCounterAttack() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).aAmount(1).build();
        Creature attacker = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).aAmount(1).build();

        attacker.attack(defender);

        assertEquals(9, attacker.getCurrentHp());
    }

    @Test
    void defenderCreatureShouldCounterAttackOnlyOncePerTurn() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).aAmount(1).build();
        Creature attacker = Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 2)).aArmor(1).aAmount(1).build();

        attacker.attack(defender);
        attacker.attack(defender);

        assertEquals(9, attacker.getCurrentHp());
    }

    @Test
    void polimorphismExample() {
        Creature defender = Creature.builder().aMaxHp(10).aAttack(Range.closed(1, 1)).aArmor(1).aAmount(1).build();
        Creature attacker = Creature.builder().aMaxHp(10).aAttack(Range.closed(1, 1)).aArmor(1).aAmount(1).build();
        ShootingCreature attackerShooter = new ShootingCreature(10, Range.closed(1, 1), 1, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);

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
        Creature defender = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(0).aAmount(1).build();
        Creature attacker = new Creature(10, Range.closed(1, 100), 0);

        attacker.attack(defender);

        assertEquals(89, defender.getCurrentHp());
    }

    @Test
    void creatureShouldIgnoreArmorWithCorrectStrategy(){
        Creature defender = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(50).aAmount(1).build();
        Creature attacker = new Creature(10, Range.closed(100, 100), 0);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithIgnoreArmorStrategy());

        attacker.attack(defender);

        assertEquals(0, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToAirElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Storm Elemental", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToAirElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToEarthElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Magma Elemental", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToEarthElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToFireElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Energy Elemental", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToFireElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamageToWaterElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Ice Elemental", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToWaterElementalStrategy());

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
    }
    
    @Test
    void creatureShouldDealDoubleDamage() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(10, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setAttackStrategyIf(new DoubleAttackStrategy(attacker));

        attacker.attack(defender);

        assertEquals(6, defender.getCurrentHp());
        assertEquals(9, attacker.getCurrentHp());
    }
    
    @Test
    void creatureShouldHealAfterAttack() {
        Creature defender = new Creature(100, Range.closed(5, 5), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(10, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithHealStrategy());
        defender.setCanCounterAttacked(false);

        defender.attack(attacker);

        assertEquals(7, attacker.getCurrentHp());
    }
    
    @Test
    void creatureShouldIgnore80PercentArmor() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, 10, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(10, 10), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithIgnore80PercentArmorStrategy());

        attacker.attack(defender);

        assertEquals(2, defender.getCurrentHp());
    }

    @Test
    void creatureShouldBlockCounterAttack() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        Creature attacker = new Creature(10, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,NOT_IMPORTANT_1);
        attacker.setAttackStrategyIf(new AttackWithCounterBlockedStrategy(attacker));

        attacker.attack(defender);

        assertEquals(8, defender.getCurrentHp());
        assertEquals(10, attacker.getCurrentHp());
    }

    @Test
    void MoreThenOneCreatureShouldIgnoreArmorWithCorrectStrategy(){
        Creature defender = Creature.builder().aMaxHp(100).aAttack(Range.closed(2, 2)).aArmor(50).aAmount(5).build();
        Creature attacker = new Creature(10, Range.closed(100, 100), 0);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithIgnoreArmorStrategy());

        attacker.attack(defender);

        assertEquals(100, defender.getCurrentHp());
        assertEquals(4, defender.getAmount());
    }
    @Test
    void MoreThenOneCreatureShouldDealDoubleDamageToAirElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Storm Elemental", 0, NOT_IMPORTANT_FALSE,4);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToAirElementalStrategy());

        attacker.attack(defender);//(2*2)*4=16 damage

        assertEquals(4, defender.getCurrentHp());
        assertEquals(3, defender.getAmount());
    }
    @Test
    void MoreThenOneCreatureShouldDealDoubleDamageToEarthElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Magma Elemental", 0, NOT_IMPORTANT_FALSE,4);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToEarthElementalStrategy());

        attacker.attack(defender);//(2*2)*4=16 damage

        assertEquals(4, defender.getCurrentHp());
        assertEquals(3, defender.getAmount());
    }
    @Test
    void MoreThenOneCreatureShouldDealDoubleDamageToFireElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Energy Elemental", 0, NOT_IMPORTANT_FALSE,4);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToFireElementalStrategy());

        attacker.attack(defender);//(2*2)*4=16 damage

        assertEquals(4, defender.getCurrentHp());
        assertEquals(3, defender.getAmount());
    }
    @Test
    void MoreThenOneCreatureShouldDealDoubleDamageToWaterElemental() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "Ice Elemental", 0, NOT_IMPORTANT_FALSE,4);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterDoubleToWaterElementalStrategy());

        attacker.attack(defender);//(2*2)*4=16 damage

        assertEquals(4, defender.getCurrentHp());
        assertEquals(3, defender.getAmount());
    }
    @Test
    void MoreThenOneCreatureShouldDealDoubleDamage() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        Creature attacker = new Creature(10, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        attacker.setAttackStrategyIf(new DoubleAttackStrategy(attacker));

        attacker.attack(defender);

        assertEquals(4, defender.getCurrentHp());
        assertEquals(3, defender.getAmount());
        assertEquals(6, attacker.getCurrentHp());
        assertEquals(4, attacker.getAmount());
    }
    @Test
    void MoreThenOneCreatureShouldHealAfterAttack() {
        Creature defender = new Creature(100, Range.closed(5, 5), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,3);
        Creature attacker = new Creature(10, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,2);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithHealStrategy());
        defender.setCanCounterAttacked(false);

        defender.attack(attacker);

        assertEquals(7, attacker.getCurrentHp());
        assertEquals(1, attacker.getAmount());
        assertEquals(98, defender.getCurrentHp());
    }
    @Test
    void MoreThenOneCreatureShouldIgnore80PercentArmor() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, 10, "", 0, NOT_IMPORTANT_FALSE,5);
        Creature attacker = new Creature(NOT_IMPORTANT_0, Range.closed(10, 10), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        attacker.setDealDamageCounterStrategy(new DealDamageCounterWithIgnore80PercentArmorStrategy());

        attacker.attack(defender);//10hp*5 - ((80% of 10 armor = 8)*4 = 32) = 50-32=18 -> 2 creature one with 8 hp

        assertEquals(8, defender.getCurrentHp());
        assertEquals(2, defender.getAmount());
    }
    @Test
    void MoreThenOneCreatureShouldBlockCounterAttack() {
        Creature defender = new Creature(10, NOT_IMPORTANT_RANGE, NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        Creature attacker = new Creature(10, Range.closed(2, 2), NOT_IMPORTANT_0, "", 0, NOT_IMPORTANT_FALSE,4);
        attacker.setAttackStrategyIf(new AttackWithCounterBlockedStrategy(attacker));

        attacker.attack(defender);

        assertEquals(2, defender.getCurrentHp());
        assertEquals(4, defender.getAmount());
        assertEquals(10, attacker.getCurrentHp());
    }
}