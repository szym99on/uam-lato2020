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
        assertEquals("Skeleton", creature.getName());
        assertEquals(4, creature.getArmor());
        assertEquals(4, creature.getMoveRange());
    }

    @Test
    void shouldCreateSecondTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(2);
        assertEquals(15, creature.getMaxHp());
        assertEquals(Range.closed(2,3), creature.getAttack());
        assertEquals("Walking Dead", creature.getName());
        assertEquals(5, creature.getArmor());
        assertEquals(3, creature.getMoveRange());
    }

    @Test
    void shouldCreateThirdTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(3);
        assertEquals(18, creature.getMaxHp());
        assertEquals(Range.closed(3,5), creature.getAttack());
        assertEquals("Wight", creature.getName());
        assertEquals(7, creature.getArmor());
        assertEquals(5, creature.getMoveRange());
    }

    @Test
    void shouldCreateFourthTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(4);
        assertEquals(30, creature.getMaxHp());
        assertEquals(Range.closed(5,8), creature.getAttack());
        assertEquals("Vampire", creature.getName());
        assertEquals(9, creature.getArmor());
        assertEquals(6, creature.getMoveRange());
    }

    @Test
    void shouldCreateFifthTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(5);
        assertEquals(30, creature.getMaxHp());
        assertEquals(Range.closed(11,13), creature.getAttack());
        assertEquals("Lich", creature.getName());
        assertEquals(10, creature.getArmor());
        assertEquals(6, creature.getMoveRange());
    }

    @Test
    void shouldCreateSixthTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(6);
        assertEquals(120, creature.getMaxHp());
        assertEquals(Range.closed(15,30), creature.getAttack());
        assertEquals("Black Knight", creature.getName());
        assertEquals(16, creature.getArmor());
        assertEquals(7, creature.getMoveRange());
    }

    @Test
    void shouldCreateSeventhTierCreature() {
        NecropolisCreatureFactory necropolisCreatureFactory = new NecropolisCreatureFactory();

        Creature creature = necropolisCreatureFactory.createCreature(7);
        assertEquals(150, creature.getMaxHp());
        assertEquals(Range.closed(25,50), creature.getAttack());
        assertEquals("Bone Dragon", creature.getName());
        assertEquals(15, creature.getArmor());
        assertEquals(9, creature.getMoveRange());
    }
}