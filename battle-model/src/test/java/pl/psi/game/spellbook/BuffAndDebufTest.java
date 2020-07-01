package pl.psi.game.spellbook;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.DealDamageCounterWithHealStrategy;
import pl.psi.game.fractions.ShootingCreature;
import pl.psi.game.hero.converter.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuffAndDebufTest {

    private final static int NOT_IMPORTANT_HP =100;
    private final static int NOT_IMPORTANT_0 = 0;

    @BeforeAll
    static void initializeFactories(){
        new SpellBookInfoFactory();
    }

    @Test
    void factoryShouldCreateHasteSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE));

        assertEquals("Haste",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(6,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    @Disabled
    void factoryShouldCreateAirShieldSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.AIR_SHIELD));

        assertEquals("Air shield",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(3,spell.getLevel());
        assertEquals(12,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    void factoryShouldCreateBloodlustSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.BLOODLUST));

        assertEquals("Bloodlust",spell.getName());
        assertEquals(SpellInfo.Type.FIRE,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    @Disabled
    void factoryShouldCreateFireShieldSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_SHIELD));

        assertEquals("Fire shield",spell.getName());
        assertEquals(SpellInfo.Type.FIRE,spell.getType());
        assertEquals(4,spell.getLevel());
        assertEquals(16,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    void factoryShouldCreateSlowSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.SLOW));

        assertEquals("Slow",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(6,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    void factoryShouldCreateStoneskinSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STONESKIN));

        assertEquals("Stoneskin",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(1,spell.getLevel());
        assertEquals(5,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    void factoryShouldCreateWeaknessSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.WEAKNESS));

        assertEquals("Weakness",spell.getName());
        assertEquals(SpellInfo.Type.WATER,spell.getType());
        assertEquals(2,spell.getLevel());
        assertEquals(8,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    void factoryShouldCreatePrayerSpell() {
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.PRAYER));

        assertEquals("Prayer",spell.getName());
        assertEquals(SpellInfo.Type.WATER,spell.getType());
        assertEquals(4,spell.getLevel());
        assertEquals(16,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    void factoryShouldCreateAntyMagicSpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.ANTY_MAGIC));

        assertEquals("Anty magic",spell.getName());
        assertEquals(SpellInfo.Type.EARTH,spell.getType());
        assertEquals(3,spell.getLevel());
        assertEquals(15,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }
    @Test
    void factoryShouldCreateDisruptingRaySpell(){
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DISRUPTING_RAY));

        assertEquals("Disrupting ray",spell.getName());
        assertEquals(SpellInfo.Type.AIR,spell.getType());
        assertEquals(2,spell.getLevel());
        assertEquals(10,spell.getManaCost());
        assertEquals(1,spell.getDuration());
    }

    @Test
//    @Disabled
    void shouldIncreasedCreatureMoveRange() {
        Creature creature = Creature.builder().aMoveRange(3).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE));

        spell.cast(creature);

        assertEquals(6, creature.getMoveRange());
    }

    @Test
    @Disabled
    void shouldDecreaseDamageFromRangedAttacks(){
        Creature defender1 = Creature.builder().aArmor(0).aMaxHp(10).build();
        Creature defender2 = Creature.builder().aArmor(0).aMaxHp(10).build();
        Creature attacker1 = ShootingCreature.builder().aAttack(Range.closed(8,8)).aMaxHp(NOT_IMPORTANT_HP).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.AIR_SHIELD));

        spell.cast(defender2);
        attacker1.attack(defender1);
        attacker1.attack(defender2);

        assertEquals(2,defender1.getCurrentHp());
        assertEquals(4,defender2.getCurrentHp());
    }

    @Test
    @Disabled
    void shouldIncreasedHandToHandAttackDMG(){
        Creature defender1 = Creature.builder().aArmor(NOT_IMPORTANT_0).aMaxHp(10).build();
        Creature defender2 = Creature.builder().aArmor(NOT_IMPORTANT_0).aMaxHp(10).build();
        Creature attacker1 = Creature.builder().aAttack(Range.closed(5,5)).aMaxHp(NOT_IMPORTANT_HP).build();
        Creature attacker2 = Creature.builder().aAttack(Range.closed(5,5)).aMaxHp(NOT_IMPORTANT_HP).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.BLOODLUST));

        spell.cast(attacker2);
        attacker1.attack(defender1);
        attacker2.attack(defender2);

        assertEquals(5,defender1.getCurrentHp());
        assertEquals(2,defender2.getCurrentHp());
    }

    @Test
    @Disabled
    void attakerShouldReciveDMG(){
        Creature defender = Creature.builder().aArmor(NOT_IMPORTANT_0).aAttack(Range.closed(0,0)).aMaxHp(20).build();
        Creature attacker = Creature.builder().aAttack(Range.closed(10,10)).aMaxHp(20).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_SHIELD));

        spell.cast(defender);
        attacker.attack(defender);

        assertEquals(18,attacker.getCurrentHp());
    }

    @Test
    @Disabled
    void shouldDecreaseCreatureMoveRange() {
        Creature c = Creature.builder().aMoveRange(8).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.SLOW));

        spell.cast(c);

        assertEquals(5,c.getMoveRange());
    }

    @Test
//    @Disabled
    void shouldIncreaseArmor(){
        Creature c = Creature.builder().aArmor(5).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STONESKIN));

        spell.cast(c);

        assertEquals(8,c.getArmor());
    }

    @Test
    @Disabled
    void shouldDecreaseAttack(){
        Creature attacker = Creature.builder().aAttack(Range.closed(9,9)).aMaxHp(NOT_IMPORTANT_HP).aAmount(1).build();
        Creature defender1 = Creature.builder().aArmor(NOT_IMPORTANT_0).aMaxHp(10).aAmount(1).build();
        Creature defender2 = Creature.builder().aArmor(NOT_IMPORTANT_0).aMaxHp(10).aAmount(1).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.WEAKNESS));

        attacker.attack(defender1);
        spell.cast(attacker);
        attacker.attack(defender2);

        assertEquals(1,defender1.getCurrentHp());
        assertEquals(4,defender2.getCurrentHp());
    }

    @Test
//    @Disabled
    void shouldIncreaseAttackArmorMoveRange(){
        Creature creature = Creature.builder().aAttack(Range.closed(5,5)).aArmor(5).aMoveRange(5).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.PRAYER));

        spell.cast(creature);

        assertEquals(Range.closed(7,7),creature.getAttack());
        assertEquals(7,creature.getArmor());
        assertEquals(7,creature.getMoveRange());
    }

    @Test
    void shouldDecreaseArmor(){
        Creature creature = Creature.builder().aArmor(5).build();
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DISRUPTING_RAY));

        spell.cast(creature);

        assertEquals(2, creature.getArmor());
    }




    @Test
    @Disabled
    void buffShouldLastOneRound(){
//        Board board = Board.getBoard();
//        board.clearBoard();
//        List<Creature> creatures = new ArrayList<>();
//        Creature c1 = Creature.builder().aMoveRange(5).build();
//        creatures.add(c1);
//        List<Creature> creatures2 = new ArrayList<>();
//        Creature c2_1 = Creature.builder().aMoveRange(11).build();
//        creatures2.add(c2_1);
//        Hero hero1 = Hero.builder().aCreatures(creatures).build();
//        Hero hero2 = Hero.builder().aCreatures(creatures2).build();
//
//        GameEngine gameEngine = new GameEngine(hero1, hero2);
//
//        SpellFactory factory = new SpellFactory();
//        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE));
//
//        gameEngine.castSpell(c1,spell);
//        assertEquals(8,c1.getMoveRange());
//        gameEngine.pass();
//        gameEngine.pass();
//        assertEquals(5,c1.getMoveRange());
    }

    @Test
    void shouldCloneSpell(){
        SpellFactory spellFactory = new SpellFactory();
        Spell spell = spellFactory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE),1);
        Spell spell1 = (Spell) spell.clone();

        spell1.increaseDuration(1);

        assertEquals(1, spell.getDuration());
        assertEquals(2, spell1.getDuration());

        Creature creature = Creature.builder().aMoveRange(3).build();
        spell1.cast(creature);
        assertEquals(6,creature.getMoveRange());
    }

    //PW looks really nice, you get testing idea correctly :).
    // You should test each spell :)
}
