package pl.psi.game.fractions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Range;

public class CreatureAbstractFactoryTest {
	
	private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
	
    @Test
    void shouldCreateSkeletonWarrior() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        assertEquals(6, creature.getMaxHp());
        assertEquals(Range.closed(1,3), creature.getAttack());
        assertEquals("Skeleton Warrior", creature.getName());
        assertEquals(6, creature.getArmor());
        assertEquals(5, creature.getMoveRange());
    }

    @Test
    void shouldCreateZombie() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(2);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        assertEquals(20, creature.getMaxHp());
        assertEquals(Range.closed(2,3), creature.getAttack());
        assertEquals("Zombie", creature.getName());
        assertEquals(5, creature.getArmor());
        assertEquals(4, creature.getMoveRange());
    }

    @Test
    void shouldCreateWraith() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(3);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        assertEquals(18, creature.getMaxHp());
        assertEquals(Range.closed(3,5), creature.getAttack());
        assertEquals("Wraith", creature.getName());
        assertEquals(7, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
    }

    @Test
    void shouldCreateVampireLord() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(4);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        assertEquals(40, creature.getMaxHp());
        assertEquals(Range.closed(5,8), creature.getAttack());
        assertEquals("Vampire Lord", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
    }

    @Test
    void shouldCreatePowerLich() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(5);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        assertEquals(40, creature.getMaxHp());
        assertEquals(Range.closed(11,15), creature.getAttack());
        assertEquals("Power Lich", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
    }

    @Test
    void shouldCreateDreadKnight() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(6);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        assertEquals(120, creature.getMaxHp());
        assertEquals(Range.closed(15,30), creature.getAttack());
        assertEquals("Dread Knight", creature.getName());
        assertEquals(18, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
    }

    @Test
    void shouldCreateGhostDragon() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        assertEquals(200, creature.getMaxHp());
        assertEquals(Range.closed(25,50), creature.getAttack());
        assertEquals("Ghost Dragon", creature.getName());
        assertEquals(17, creature.getArmor());
        assertEquals(14, creature.getMoveRange());
    }
    
    
    // TODO
    @Test
    void shouldCreateCentaurCaptain() {

    }

    @Test
    void shouldCreateBattleDwarf() {

    }

    @Test
    void shouldCreateGrandElf() {
    	
    }

    @Test
    void shouldCreateSilverPegasus() {
    	
    }

    @Test
    void shouldCreateDendroidSoldier() {
    	
    }

    @Test
    void shouldCreateWarUnicorn() {
    	
    }

    @Test
    void shouldCreateGoldDragon() {
    	
    }
    
    @Test
    void shouldCreateHobgoblin() {
    	
    }

    @Test
    void shouldCreateWolfRaider() {
    	
    }

    @Test
    void shouldCreateOrcChieftain() {
    	
    }

    @Test
    void shouldCreateOgreMagi() {
    	
    }

    @Test
    void shouldCreateThunderbird() {
    	
    }

    @Test
    void shouldCreateCyclopsKing() {
    	
    }

    @Test
    void shouldCreateAncientBehemoth() {
    	
    }
    
    @Test
    void shouldCreateStormElemental() {
    	
    }

    @Test
    void shouldCreateIceElemental() {
    	
    }

    @Test
    void shouldCreateEnergyElemental() {
    	
    }

    @Test
    void shouldCreateMagmaElemental() {
    	
    }
    
}