package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellBookRequest {
    /*
    @Test
    void shouldDealDamageToAllEnemyTroops(){
        Hero hero = Hero.builder().build();
        List<Creature> creatures = hero.getCreatures();
        Spell spell = Spell.builder().build();
        creatures.forEach(a -> spell.cast(a));
    }*/

    @Test
    void heroShouldReturnPower()
    {
        Hero hero = Hero.builder().build();
        hero.increasePower(2);
        assertEquals(hero.getPower(),2);
    }
}
