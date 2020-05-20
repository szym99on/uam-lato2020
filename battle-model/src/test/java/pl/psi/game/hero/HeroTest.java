package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.converter.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {
    @Test
    @Disabled
    void shouldIncreaseHeroStatsBy2() {
        /*Hero hero = Hero.builder().aAttack(1).aDefense(1).aPower(1).aKnowledge(1);

        hero.increaseAttack(2);
        hero.increaseDefense(2);
        hero.increaseKnowledge(2);
        hero.increasePower(2);

        assertEquals(3, hero.getAttack());
        assertEquals(3,hero.getDefense());
        assertEquals(3,hero.getKnowledge());
        assertEquals(3,hero.getPower());
        */
    }
    @Test
    @Disabled
    void shouldDecreaseHeroStatsTo1() {
        /*
        Hero hero = Hero.builder().aAttack(4).aDefense(4).aPower(4).aKnowledge(4);

        hero.increaseAttack(-4);
        hero.increasePower(-4);
        hero.increaseDefense(-4);
        hero.increaseKnowledge(-4);

        assertEquals(1, hero.getAttack());
        assertEquals(1,hero.getDefense());
        assertEquals(1,hero.getKnowledge());
        assertEquals(1,hero.getPower());
        */
    }

}
