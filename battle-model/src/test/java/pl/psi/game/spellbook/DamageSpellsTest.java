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
    @Disabled
    void shouldDealDamageToCreature() {
        Creature creature = Creature.builder().aMaxHp(10).aArmor(100).build();

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Magic arrow");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

        spell.cast(creature);
        assertEquals(0, creature.getCurrentHp());
        //DMG przechodzący na pozostałe jednostki w przypadku stackowania ?
        //PW tak
    }
}
