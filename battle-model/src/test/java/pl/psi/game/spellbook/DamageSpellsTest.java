package pl.psi.game.spellbook;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellsTest {


    @BeforeAll
    static void initializeFactories(){
        new SpellBookInfoFactory();
    }

    @Disabled
    @Test
    void factoryShouldCreateAirMagicArrowSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));

        assertEquals("Magic arrow",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Disabled
    @Test
    void factoryShouldCreateEarthMagicArrowSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));

        assertEquals("Magic arrow",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Disabled
    @Test
    void factoryShouldCreateFireMagicArrowSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));

        assertEquals("Magic arrow",spell.getName());
        assertEquals(SpellInfo.Type.FIRE,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Disabled
    @Test
    void factoryShouldCreateWaterMagicArrowSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));

        assertEquals("Magic arrow",spell.getName());
        assertEquals(SpellInfo.Type.WATER,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }

    @Test
    void factoryShouldCreateMagicArrowSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));

        assertEquals("Magic arrow",spell.getName());
        assertEquals(SpellInfo.Type.ALL,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateLightningBoltSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));

        assertEquals("Lightning bolt",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(2,spell.getLevel());
        assertEquals(10,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateDestroyUndeadSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DESTROY_UNDEAD));

        assertEquals("Destroy undead",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(3,spell.getLevel());
        assertEquals(15,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateFireBallSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));

        assertEquals("Fire ball",spell.getName());
        assertEquals(SpellInfo.Type.FIRE,spell.getType());
        assertEquals(3,spell.getLevel());
        assertEquals(15,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateMeteorShowerSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));

        assertEquals("Meteor shower",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(4,spell.getLevel());
        assertEquals(16,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateImplosionSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));

        assertEquals("Implosion",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(5,spell.getLevel());
        assertEquals(30,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }

    @Test
    void magicArrowShouldDealDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));
        spell.cast(creature);

        assertEquals(80, creature.getCurrentHp());
    }
    @Test
    void magicArrownShouldDealDeadlyDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(19).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }
    @Test
    void lightningBoltShouldDealDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
        spell.cast(creature);

        assertEquals(65, creature.getCurrentHp());
    }
    @Test
    void lightningBoltShouldDealDeadlyDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(34).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }
    @Test
    void implosionShouldDealDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(1000).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);

        assertEquals(825, creature.getCurrentHp());
    }


    @Test
    void implosionShouldDealDeadlyDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }

    @Test
    void destroyUndeadShouldDealDamageOnyToUndeadCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DESTROY_UNDEAD));
        spell.cast(creature);

        assertEquals(80, creature.getCurrentHp());
    }
    @Test
    @Disabled
    void destroyUndeadShouldNotDealAnyDamageNotToUndeadCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DESTROY_UNDEAD));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }

    @Test
    void fireBallShouldDealDamageToTargetedCreatureAndAdjacentCreatures() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));
        spell.cast(creature);

        assertEquals(75, creature.getCurrentHp());
    }
    @Test
    void fireBallShouldDealDeadlyDamageToTargetedCreatureAndAdjacentCreatures() {
        Creature creature = Creature.builder().aMaxHp(24).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }
    @Test
    void meteorShowerShouldDealDamageToTargetedCreatureAndAdjacentCreatures() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
        spell.cast(creature);

        assertEquals(50, creature.getCurrentHp());
    }
    @Test
    void meteorShowerShouldDealDeadlyDamageToTargetedCreatureAndAdjacentCreatures() {
        Creature creature = Creature.builder().aMaxHp(59).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }


}
