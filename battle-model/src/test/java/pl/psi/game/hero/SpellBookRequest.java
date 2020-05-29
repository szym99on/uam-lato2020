package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

import java.util.List;

public class SpellBookRequest {
    
/*
    @Test
    void shouldDealDamageToAllEnemyTroops(){

        Hero activeHero = ...;
        List<Creature> creatures = activeHero.getCreatures();
        Spell spell = Spell.builder().build();

        creatures.forEach(a -> spell.cast(a));

    }*/

    @Test
    @Disabled
    void heroShouldReturnPower()
    {
        Hero hero = Hero.builder().build();

        int power = hero.getPower();
    }
}
