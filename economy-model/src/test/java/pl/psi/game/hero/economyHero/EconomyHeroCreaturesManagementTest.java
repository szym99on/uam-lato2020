package pl.psi.game.hero.economyHero;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.fractions.NecropolisInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import static org.junit.jupiter.api.Assertions.*;

public class EconomyHeroCreaturesManagementTest {

    static FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);

    @BeforeAll
    static void initializeFactories() {
        new FractionsInfoAbstractFactory();
    }

    @Test
    void buyCreatureShouldTakeGold () throws Exception {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        hero.buyCreature(creature);

        assertEquals(hero.getGold(), 930);

    }

    @Test
    void buyCreatureShouldAddCreature () throws Exception {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.VAMPIRE_LORD);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        hero.buyCreature(creature);

        assertTrue(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 1);
    }

    @Test
    //PW not throw just exception use something more specyfic in this case IllegalStateException is better
    void buyCreatureShouldNotBuyCreatureWhenNotEnoughGold () throws Exception {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.GHOST_DRAGON);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        assertThrows(Exception.class, () ->
                hero.buyCreature(creature)
        );

        assertEquals(hero.getGold(), 1000);

    }

    @Test
    void sellSkeletonWarriorShouldReturn75PercentOfOriginalPrice() throws Exception {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(creature);

        hero.sellCreature(creature);

        assertEquals(hero.getGold(), 2052);
    }
    @Test
    void sellDreadKnightShouldReturn75PercentOfOriginalPrice() throws Exception {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.DREAD_KNIGHT);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(creature);

        hero.sellCreature(creature);

        assertEquals(hero.getGold(), 3125);
    }

    @Test
    void sellSkeletonWarriorShouldRemoveHimFromHeroesCreatures() throws Exception {
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(creature);

        hero.sellCreature(creature);

        assertFalse(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 0);
    }

}
