package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.converter.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {
    @Test
    void shouldIncreaseHeroStatsBy2() {
        Hero hero = Hero.builder().build();

        hero.increaseAttack(2);
        hero.increaseDefence(2);
        hero.increaseKnowledge(2);
        hero.increasePower(2);

        assertEquals(2,hero.getAttack());
        assertEquals(2,hero.getDefence());
        assertEquals(2,hero.getKnowledge());
        assertEquals(2,hero.getPower());

    }
    @Test
    void shouldDecreaseHeroStatsTo0() {
        Hero hero = Hero.builder().build();

        hero.increaseAttack(-4);
        hero.increasePower(-4);
        hero.increaseDefence(-4);
        hero.increaseKnowledge(-4);

        assertEquals(0,hero.getAttack());
        assertEquals(0,hero.getDefence());
        assertEquals(0,hero.getKnowledge());
        assertEquals(0,hero.getPower());
    }

}
