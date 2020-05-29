package pl.psi.game.spellbook;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.ShootingCreature;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuffAndDebufTest {

    private final static int NOT_IMPORTANT_HP =100;
    private final static int NOT_IMPORTANT_0 = 0;

    @Test
    @Disabled
    void shouldIncreasedCreatureMoveRange() {
        Creature creature = Creature.builder().aMoveRange(3).build();
        //PW USE STATIC NOT PURE STRING!!!!!!!!
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Haste");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

        spell.cast(creature);
        assertEquals(6, creature.getMoveRange());

    }

    @Test
    @Disabled
        void shouldDecreaseDamageFromRangedAttacks(){
        Creature defender1 = Creature.builder().aArmor(0).aMaxHp(10).build();
        Creature defender2 = Creature.builder().aArmor(0).aMaxHp(10).build();
        Creature attacker1 = ShootingCreature.builder().aAttack(Range.closed(8,8)).aMaxHp(NOT_IMPORTANT_HP).build();

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Air shield");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

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

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Bloodlust");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

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

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Fire shield");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

        spell.cast(defender);

        attacker.attack(defender);

        assertEquals(18,attacker.getCurrentHp());
    }

    @Test
    @Disabled
    void shouldDecreaseCreatureMoveRange() {
        Creature c = Creature.builder().aMoveRange(8).build();

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Slow");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

        spell.cast(c);

        assertEquals(6,c.getMoveRange());
    }

    @Test
    @Disabled
    void shouldIncreaseArmor(){
        Creature c = Creature.builder().aArmor(5).build();

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Stoneskin");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

        spell.cast(c);

        assertEquals(15,c.getArmor());

    }

    @Test
    @Disabled
    void shouldDecreaseAttack(){
        Creature attacker = Creature.builder().aAttack(Range.closed(9,9)).aMaxHp(NOT_IMPORTANT_HP).build();
        Creature defender1 = Creature.builder().aArmor(NOT_IMPORTANT_0).aMaxHp(10).build();
        Creature defender2 = Creature.builder().aArmor(NOT_IMPORTANT_0).aMaxHp(10).build();

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Weakness");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

        attacker.attack(defender1);
        spell.cast(attacker);
        attacker.attack(defender2);

        assertEquals(1,defender1.getCurrentHp());
        assertEquals(7,defender2.getCurrentHp());
    }

    @Test
    @Disabled
    void shouldIncreaseAttackArmorMoveRange(){
        Creature creature = Creature.builder().aAttack(Range.closed(5,5)).aArmor(5).aMoveRange(5).build();

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell("Prayer");
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);

        spell.cast(creature);

        assertEquals(Range.closed(10,10),creature.getAttack());
        assertEquals(10,creature.getArmor());
        assertEquals(10,creature.getMoveRange());
    }

    //PW looks really nice, you get testing idea correctly :).
    // You should test each spell :)
}
