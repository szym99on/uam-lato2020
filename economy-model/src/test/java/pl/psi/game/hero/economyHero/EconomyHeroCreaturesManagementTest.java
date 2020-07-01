package pl.psi.game.hero.economyHero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.CreatureStack;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.fractions.NecropolisInfoFactory;

import static org.junit.jupiter.api.Assertions.*;

public class EconomyHeroCreaturesManagementTest {

    static FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);

    @BeforeAll
    static void initializeFactories() {
        new FractionsInfoAbstractFactory();
    }

    @Test
    void buyCreatureShouldTakeGold () throws IllegalStateException {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        hero.buyCreature(creature, 1);

        assertEquals(hero.getGold(), 930);

    }

    @Test
    void buyCreatureShouldAddCreature () throws IllegalStateException {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.VAMPIRE_LORD);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        boolean success = hero.buyCreature(creature, 1);

        assertTrue(success);
        assertEquals(hero.getCreatures().size(), 1);
    }

    @Test
    void buyCreatureShouldNotBuyCreatureWhenNotEnoughGold () throws IllegalStateException {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.GHOST_DRAGON);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        assertFalse(hero.buyCreature(creature, 1));

        assertEquals(hero.getGold(), 1000);

    }

    @Test
    void sellSkeletonWarriorShouldReturn75PercentOfOriginalPrice() throws IllegalStateException {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(new CreatureStack(creature, 1));

        hero.sellCreature(creature, 1);

        assertEquals(hero.getGold(), 2052);
    }
    @Test
    void sellDreadKnightShouldReturn75PercentOfOriginalPrice() throws IllegalStateException {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.DREAD_KNIGHT);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(new CreatureStack(creature, 1));

        hero.sellCreature(creature, 1);

        assertEquals(hero.getGold(), 3125);
    }

    @Test
    void sellSkeletonWarriorShouldRemoveHimFromHeroesCreatures() throws IllegalStateException {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(new CreatureStack(creature, 1));

        hero.sellCreature(creature, 1);

        assertFalse(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 0);
    }

}
