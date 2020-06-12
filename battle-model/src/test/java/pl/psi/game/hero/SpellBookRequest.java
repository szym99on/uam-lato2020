package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellBookRequest {

    /*@Test
    void shouldDealDamageToAllEnemyTroops(){
        CreatureAbstractFactory creatureAbstractFactory= new CreatureAbstractFactory();
        List<Creature> creatures= new ArrayList<>();
        creatures.add(creatureAbstractFactory.getCreature(
                FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1)));
        Hero hero = Hero.builder().aCreatures(creatures).build();
        List<Creature> heroCreatures = hero.getCreatures();
        Spell spell = Spell.builder().build();  //----------no builder------------//
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
