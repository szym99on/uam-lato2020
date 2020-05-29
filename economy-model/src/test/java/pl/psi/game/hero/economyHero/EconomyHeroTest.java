package pl.psi.game.hero.economyHero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EconomyHeroTest {


    @BeforeAll
    static void initializeFactories(){
        new HeroInfoFactory();
    }

    @Test
    void CreateEconomyHero()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();

        assertEquals(economyHero.getAttack(),2);
    }

}
