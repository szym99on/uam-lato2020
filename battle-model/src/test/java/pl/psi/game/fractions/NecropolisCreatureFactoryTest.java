package pl.psi.game.fractions;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NecropolisCreatureFactoryTest {

    @Test
    void shouldCreateFirstTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(1);
        assertEquals(6, creature.getMaxHp());
        assertEquals(Range.closed(1,3), creature.getAttack());
        assertEquals("Skeleton Warrior", creature.getName());
        assertEquals(6, creature.getArmor());
        assertEquals(5, creature.getMoveRange());
    }

    @Test
    void shouldCreateSecondTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(2);
        assertEquals(20, creature.getMaxHp());
        assertEquals(Range.closed(2,3), creature.getAttack());
        assertEquals("Zombie", creature.getName());
        assertEquals(5, creature.getArmor());
        assertEquals(4, creature.getMoveRange());
    }

    @Test
    void shouldCreateThirdTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(3);
        assertEquals(18, creature.getMaxHp());
        assertEquals(Range.closed(3,5), creature.getAttack());
        assertEquals("Wraith", creature.getName());
        assertEquals(7, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
    }

    @Test
    void shouldCreateFourthTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(4);
        assertEquals(40, creature.getMaxHp());
        assertEquals(Range.closed(5,8), creature.getAttack());
        assertEquals("Vampire Lord", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
    }

    @Test
    void shouldCreateFifthTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(5);
        assertEquals(40, creature.getMaxHp());
        assertEquals(Range.closed(11,15), creature.getAttack());
        assertEquals("Power Lich", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
    }

    @Test
    void shouldCreateSixthTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(6);
        assertEquals(120, creature.getMaxHp());
        assertEquals(Range.closed(15,30), creature.getAttack());
        assertEquals("Dread Knight", creature.getName());
        assertEquals(18, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
    }

    @Test
    void shouldCreateSeventhTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(7);
        assertEquals(200, creature.getMaxHp());
        assertEquals(Range.closed(25,50), creature.getAttack());
        assertEquals("Ghost Dragon", creature.getName());
        assertEquals(17, creature.getArmor());
        assertEquals(14, creature.getMoveRange());
    }
}