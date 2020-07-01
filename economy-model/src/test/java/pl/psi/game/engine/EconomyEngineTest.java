package pl.psi.game.engine;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.EconomyEngine;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EconomyEngineTest {

    @BeforeAll
    static void initializeFactories(){
        new HeroInfoFactory();
    }

    EconomyEngine prepareEconomyEngine(){
        HeroInfo heroInfo1 = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero1 = EconomyHero.builder().aHeroInfo(heroInfo1).build();

        HeroInfo heroInfo2 = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.ADELA);
        EconomyHero economyHero2 = EconomyHero.builder().aHeroInfo(heroInfo2).build();
        EconomyEngine economyEngine = new EconomyEngine(economyHero1, economyHero2);
        return economyEngine;
    }

    @Test
    @Disabled
    void changeHeroShouldSwitchHero()
    {
        EconomyEngine economyEngine = prepareEconomyEngine();
        assertEquals(economyEngine.activeHero, economyEngine.economyHero1);
        economyEngine.changeHero();
        assertEquals(economyEngine.activeHero, economyEngine.economyHero2);
    }
}
