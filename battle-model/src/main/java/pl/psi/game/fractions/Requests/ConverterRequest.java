package pl.psi.game.fractions.Requests;

import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.converter.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConverterRequest {
    /*@Test
    void ApplyIncreaseCreatureAttackByHeroAttack()
    {
        Hero hero=Hero.builder().build();
        hero.increaseAttack(2);
        CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
        Creature baseCreature = creatureAbstractFactory.getCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1));
        Creature changedCreature = creatureAbstractFactory.getCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1));
        changedCreature.apply(hero);
        assertNotEquals(changedCreature,baseCreature);
    }*/
}
