package pl.psi.game.spellbook;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageSpellsTest {

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
