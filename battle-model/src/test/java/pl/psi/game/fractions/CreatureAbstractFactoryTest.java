package pl.psi.game.fractions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Range;

public class CreatureAbstractFactoryTest {
	
	private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
	
    @Test
    void shouldCreateSkeletonWarrior() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(6, creature.getMaxHp());
        assertEquals(Range.closed(1,3), creature.getAttack());
        assertEquals("Skeleton Warrior", creature.getName());
        assertEquals(6, creature.getArmor());
        assertEquals(5, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateZombie() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(2);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(20, creature.getMaxHp());
        assertEquals(Range.closed(2,3), creature.getAttack());
        assertEquals("Zombie", creature.getName());
        assertEquals(5, creature.getArmor());
        assertEquals(4, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateWraith() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(3);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(18, creature.getMaxHp());
        assertEquals(Range.closed(3,5), creature.getAttack());
        assertEquals("Wraith", creature.getName());
        assertEquals(7, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
        assertEquals(true, creature.isCanFly());
    }

    @Test
    void shouldCreateVampireLord() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(4);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(40, creature.getMaxHp());
        assertEquals(Range.closed(5,8), creature.getAttack());
        assertEquals("Vampire Lord", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
        assertEquals(true, creature.isCanFly());
    }

    @Test
    void shouldCreatePowerLich() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(5);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(40, creature.getMaxHp());
        assertEquals(Range.closed(11,15), creature.getAttack());
        assertEquals("Power Lich", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateDreadKnight() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(6);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(120, creature.getMaxHp());
        assertEquals(Range.closed(15,30), creature.getAttack());
        assertEquals("Dread Knight", creature.getName());
        assertEquals(18, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateGhostDragon() {
    	CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(200, creature.getMaxHp());
        assertEquals(Range.closed(25,50), creature.getAttack());
        assertEquals("Ghost Dragon", creature.getName());
        assertEquals(17, creature.getArmor());
        assertEquals(14, creature.getMoveRange());
        assertEquals(true, creature.isCanFly());
    }

    @Test
    void shouldCreateCentaurCaptain() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(1);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(10, creature.getMaxHp());
        assertEquals(Range.closed(2,3), creature.getAttack());
        assertEquals("Centaur Captain", creature.getName());
        assertEquals(3, creature.getArmor());
        assertEquals(8, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateBattleDwarf() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(2);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(20, creature.getMaxHp());
        assertEquals(Range.closed(2,4), creature.getAttack());
        assertEquals("Battle Dwarf", creature.getName());
        assertEquals(7, creature.getArmor());
        assertEquals(5, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateGrandElf() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(3);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(15, creature.getMaxHp());
        assertEquals(Range.closed(3,5), creature.getAttack());
        assertEquals("Grand Elf", creature.getName());
        assertEquals(5, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateSilverPegasus() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(4);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(30, creature.getMaxHp());
        assertEquals(Range.closed(5,9), creature.getAttack());
        assertEquals("Silver Pegasus", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(12, creature.getMoveRange());
        assertEquals(true, creature.isCanFly());
    }

    @Test
    void shouldCreateDendroidSoldier() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(5);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(65, creature.getMaxHp());
        assertEquals(Range.closed(10,14), creature.getAttack());
        assertEquals("Dendroid Soldier", creature.getName());
        assertEquals(12, creature.getArmor());
        assertEquals(4, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateWarUnicorn() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(6);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(110, creature.getMaxHp());
        assertEquals(Range.closed(18,22), creature.getAttack());
        assertEquals("War Unicorn", creature.getName());
        assertEquals(14, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateGoldDragon() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(7);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(250, creature.getMaxHp());
        assertEquals(Range.closed(40,50), creature.getAttack());
        assertEquals("Gold Dragon", creature.getName());
        assertEquals(27, creature.getArmor());
        assertEquals(16, creature.getMoveRange());
        assertEquals(true, creature.isCanFly());
    }
    
    @Test
    void shouldCreateHobgoblin() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(1);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(5, creature.getMaxHp());
        assertEquals(Range.closed(1,2), creature.getAttack());
        assertEquals("Hobgoblin", creature.getName());
        assertEquals(3, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateWolfRaider() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(2);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(10, creature.getMaxHp());
        assertEquals(Range.closed(3,4), creature.getAttack());
        assertEquals("Wolf Raider", creature.getName());
        assertEquals(5, creature.getArmor());
        assertEquals(8, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateOrcChieftain() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(3);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(20, creature.getMaxHp());
        assertEquals(Range.closed(2,5), creature.getAttack());
        assertEquals("Orc Chieftain", creature.getName());
        assertEquals(4, creature.getArmor());
        assertEquals(5, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateOgreMagi() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(4);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(60, creature.getMaxHp());
        assertEquals(Range.closed(6,12), creature.getAttack());
        assertEquals("Ogre Magi", creature.getName());
        assertEquals(7, creature.getArmor());
        assertEquals(5, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateThunderbird() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(5);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(60, creature.getMaxHp());
        assertEquals(Range.closed(11,15), creature.getAttack());
        assertEquals("Thunderbird", creature.getName());
        assertEquals(11, creature.getArmor());
        assertEquals(11, creature.getMoveRange());
        assertEquals(true, creature.isCanFly());
    }

    @Test
    void shouldCreateCyclopsKing() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(6);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(70, creature.getMaxHp());
        assertEquals(Range.closed(16,20), creature.getAttack());
        assertEquals("Cyclops King", creature.getName());
        assertEquals(13, creature.getArmor());
        assertEquals(8, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateAncientBehemoth() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(7);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(300, creature.getMaxHp());
        assertEquals(Range.closed(30,50), creature.getAttack());
        assertEquals("Ancient Behemoth", creature.getName());
        assertEquals(19, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }
    
    @Test
    void shouldCreateStormElemental() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(1);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(25, creature.getMaxHp());
        assertEquals(Range.closed(2,8), creature.getAttack());
        assertEquals("Storm Elemental", creature.getName());
        assertEquals(9, creature.getArmor());
        assertEquals(8, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateIceElemental() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(2);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(30, creature.getMaxHp());
        assertEquals(Range.closed(3,7), creature.getAttack());
        assertEquals("Ice Elemental", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(6, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }

    @Test
    void shouldCreateEnergyElemental() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(3);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(35, creature.getMaxHp());
        assertEquals(Range.closed(4,6), creature.getAttack());
        assertEquals("Energy Elemental", creature.getName());
        assertEquals(8, creature.getArmor());
        assertEquals(8, creature.getMoveRange());
        assertEquals(true, creature.isCanFly());
    }

    @Test
    void shouldCreateMagmaElemental() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(4);
        Creature creature = creatureAbstractFactory.getCreature(new CreatureStack(creatureInfo, 1));
        assertEquals(40, creature.getMaxHp());
        assertEquals(Range.closed(6,10), creature.getAttack());
        assertEquals("Magma Elemental", creature.getName());
        assertEquals(11, creature.getArmor());
        assertEquals(6, creature.getMoveRange());
        assertEquals(false, creature.isCanFly());
    }
    
}