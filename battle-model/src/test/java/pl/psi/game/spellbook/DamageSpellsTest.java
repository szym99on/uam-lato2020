package pl.psi.game.spellbook;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.fractions.MagicResistance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellsTest {


    @BeforeAll
    static void initializeSpellBookInfoFactory(){ new SpellBookInfoFactory(); }

    @BeforeAll
    static void initializeFractionsInfoAbstractFactory(){
        new FractionsInfoAbstractFactory();
    }

    private Board board = Board.getBoard();
    private SpellFactory factory = new SpellFactory();


    @Test
    void factoryShouldCreateMagicArrowSpell(){
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));

        assertEquals("Magic arrow",spell.getName());
        assertEquals(SpellInfo.Type.ALL,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateLightningBoltSpell(){
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));

        assertEquals("Lightning bolt",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(2,spell.getLevel());
        assertEquals(10,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateDestroyUndeadSpell(){
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DESTROY_UNDEAD));

        assertEquals("Destroy undead",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(3,spell.getLevel());
        assertEquals(15,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateFireBallSpell(){
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));

        assertEquals("Fire ball",spell.getName());
        assertEquals(SpellInfo.Type.FIRE,spell.getType());
        assertEquals(3,spell.getLevel());
        assertEquals(15,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateMeteorShowerSpell(){
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));

        assertEquals("Meteor shower",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(4,spell.getLevel());
        assertEquals(16,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }
    @Test
    void factoryShouldCreateImplosionSpell(){
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));

        assertEquals("Implosion",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(5,spell.getLevel());
        assertEquals(30,spell.getManaCost());
        assertEquals(0,spell.getDuration());
    }

    @Test
    void spellCastedOnBoardShouldDealDamageToCreatureOnThisSquare() {
        Creature creature = Creature.builder().aMaxHp(100).build();
        board.putCreature(1,1,creature);

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));
        spell.cast(1,1);

        assertEquals(80, creature.getCurrentHp());
    }

    @Test
    void airSpellsShouldNotDealDamageToCreatureImmuneToAirSpells() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        creature.setMagicResistance(new MagicResistance(40, MagicResistance.GroupImmunityType.AIR_SPELLS));

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }
    @Test
    void fireSpellsShouldNotDealDamageToCreatureImmuneToFireSpells() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        creature.setMagicResistance(new MagicResistance(40, MagicResistance.GroupImmunityType.FIRE_SPELLS));

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }
    @Test
    void earthSpellsShouldNotDealDamageToCreatureImmuneToEarthSpells() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        creature.setMagicResistance(new MagicResistance(40, MagicResistance.GroupImmunityType.EARTH_SPELLS));

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
        spell.cast(creature);
        Spell spell2 = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);
        spell2.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }

    @Test
    void lightningBoltShouldNotDealDamageToCreatureImmuneToLightningBolt() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        creature.getMagicResistance().addImmunitySpell(SpellBookInfoFactory.LIGHTNING_BOLT);

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }
    @Test
    void fireBallShouldNotDealDamageToCreatureImmuneToFireBall() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        creature.getMagicResistance().addImmunitySpell(SpellBookInfoFactory.FIRE_BALL);

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }
    @Test
    void meteorShowerShouldNotDealDamageToCreatureImmuneToMeteorShower() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        creature.getMagicResistance().addImmunitySpell(SpellBookInfoFactory.METEOR_SHOWER);

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }
    @Test
    void implosionShouldNotDealDamageToCreatureImmuneToImplosion() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        creature.getMagicResistance().addImmunitySpell(SpellBookInfoFactory.IMPLOSION);

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }

    @Test
    void magicArrowShouldDealDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));
        spell.cast(creature);

        assertEquals(80, creature.getCurrentHp());
    }
    @Test
    void magicArrowShouldDealDeadlyDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(19).build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }
    @Test
    void lightningBoltShouldDealDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
        spell.cast(creature);

        assertEquals(65, creature.getCurrentHp());
    }
    @Test
    void lightningBoltShouldDealDeadlyDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(34).build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }
    @Test
    void implosionShouldDealDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(1000).build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);

        assertEquals(825, creature.getCurrentHp());
    }
    @Test
    void implosionShouldDealDeadlyDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(100).build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
        spell.cast(creature);

        assertEquals(0, creature.getCurrentHp());
    }
    @Test
    void fireBallShouldDealDamageToTargetedCreatureAndAdjacentCreatures() {
        board.clearBoard();

        Creature c1 = Creature.builder().aMaxHp(100).build();
        Creature c2 = Creature.builder().aMaxHp(100).build();
        Creature c3 = Creature.builder().aMaxHp(100).build();
        Creature c4 = Creature.builder().aMaxHp(100).build();
        Creature c5 = Creature.builder().aMaxHp(100).build();

        board.putCreature(2,2,c1);
        board.putCreature(2,1,c2);
        board.putCreature(2,3,c3);
        board.putCreature(3,2,c4);
        board.putCreature(1,2,c5);


        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));
        spell.cast(2,2);


        assertEquals(75, c1.getCurrentHp());
        assertEquals(75, c2.getCurrentHp());
        assertEquals(75, c3.getCurrentHp());
        assertEquals(75, c4.getCurrentHp());
        assertEquals(75, c5.getCurrentHp());
    }
    @Test
    void fireBallShouldDealDeadlyDamageToTargetedCreatureAndAdjacentCreatures() {
        board.clearBoard();

        Creature c1 = Creature.builder().aMaxHp(24).build();
        Creature c2 = Creature.builder().aMaxHp(24).build();
        Creature c3 = Creature.builder().aMaxHp(24).build();
        Creature c4 = Creature.builder().aMaxHp(24).build();
        Creature c5 = Creature.builder().aMaxHp(24).build();

        board.putCreature(2,2,c1);
        board.putCreature(2,1,c2);
        board.putCreature(2,3,c3);
        board.putCreature(3,2,c4);
        board.putCreature(1,2,c5);


        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));
        spell.cast(2,2);


        assertEquals(0, c1.getCurrentHp());
        assertEquals(0, c2.getCurrentHp());
        assertEquals(0, c3.getCurrentHp());
        assertEquals(0, c4.getCurrentHp());
        assertEquals(0, c5.getCurrentHp());
    }
    @Test
    void meteorShowerShouldDealDamageToTargetedCreatureAndAdjacentCreatures() {
        board.clearBoard();

        Creature c1 = Creature.builder().aMaxHp(100).build();
        Creature c2 = Creature.builder().aMaxHp(100).build();
        Creature c3 = Creature.builder().aMaxHp(100).build();
        Creature c4 = Creature.builder().aMaxHp(100).build();
        Creature c5 = Creature.builder().aMaxHp(100).build();

        board.putCreature(2,2,c1);
        board.putCreature(2,1,c2);
        board.putCreature(2,3,c3);
        board.putCreature(3,2,c4);
        board.putCreature(1,2,c5);


        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
        spell.cast(2,2);


        assertEquals(50, c1.getCurrentHp());
        assertEquals(50, c2.getCurrentHp());
        assertEquals(50, c3.getCurrentHp());
        assertEquals(50, c4.getCurrentHp());
        assertEquals(50, c5.getCurrentHp());
    }
    @Test
    void meteorShowerShouldDealDeadlyDamageToTargetedCreatureAndAdjacentCreatures() {
        board.clearBoard();

        Creature c1 = Creature.builder().aMaxHp(49).build();
        Creature c2 = Creature.builder().aMaxHp(49).build();
        Creature c3 = Creature.builder().aMaxHp(49).build();
        Creature c4 = Creature.builder().aMaxHp(49).build();
        Creature c5 = Creature.builder().aMaxHp(49).build();

        board.putCreature(2,2,c1);
        board.putCreature(2,1,c2);
        board.putCreature(2,3,c3);
        board.putCreature(3,2,c4);
        board.putCreature(1,2,c5);


        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
        spell.cast(2,2);


        assertEquals(0, c1.getCurrentHp());
        assertEquals(0, c2.getCurrentHp());
        assertEquals(0, c3.getCurrentHp());
        assertEquals(0, c4.getCurrentHp());
        assertEquals(0, c5.getCurrentHp());
    }

    @Test
    void meteorShowerCornerTest() {
        board.clearBoard();

        Creature c1 = Creature.builder().aMaxHp(49).build();
        Creature c2 = Creature.builder().aMaxHp(49).build();
        Creature c3 = Creature.builder().aMaxHp(49).build();
        Creature c4 = Creature.builder().aMaxHp(49).build();
        Creature c5 = Creature.builder().aMaxHp(49).build();

        board.putCreature(1,1,c1);
        board.putCreature(2,1,c2);
        board.putCreature(1,2,c3);
        board.putCreature(2,2,c4);


        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
        spell.cast(1,1);


        assertEquals(0, c1.getCurrentHp());
        assertEquals(0, c2.getCurrentHp());
        assertEquals(0, c3.getCurrentHp());
        assertEquals(49, c4.getCurrentHp());

    }
    @Test
    void fireBallCornerTest() {
        board.clearBoard();

        Creature c1 = Creature.builder().aMaxHp(49).build();
        Creature c2 = Creature.builder().aMaxHp(49).build();
        Creature c3 = Creature.builder().aMaxHp(49).build();
        Creature c4 = Creature.builder().aMaxHp(49).build();
        Creature c5 = Creature.builder().aMaxHp(49).build();

        board.putCreature(1,1,c1);
        board.putCreature(2,1,c2);
        board.putCreature(1,2,c3);
        board.putCreature(2,2,c4);


        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));
        spell.cast(1,1);


        assertEquals(24, c1.getCurrentHp());
        assertEquals(24, c2.getCurrentHp());
        assertEquals(24, c3.getCurrentHp());
        assertEquals(49, c4.getCurrentHp());

    }

    @Test
    void destroyUndeadShouldDealDamageOnyToUndeadCreature() {
        Creature creature = Creature.builder().aMaxHp(100).aName("Ghost Dragon").build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DESTROY_UNDEAD));
        spell.cast(creature);

        assertEquals(80, creature.getCurrentHp());
    }
    @Test
    void destroyUndeadShouldNotDealAnyDamageToNotUndeadCreature() {
        Creature creature = Creature.builder().aMaxHp(100).aName("Gold Dragon").build();

        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DESTROY_UNDEAD));
        spell.cast(creature);

        assertEquals(100, creature.getCurrentHp());
    }


}
