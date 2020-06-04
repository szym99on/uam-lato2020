package pl.psi.game.converter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.hero.economyHero.EconomyHero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConverterThrowTest {

    private EconomyHero economyHero;
    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    void InitializeEconomyHero()
    {
        economyHero = EconomyHero.builder().aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
    }
    @Test
    @Disabled
    //TODO: assertThrow method.
    void ConvertEconomyHeroToBattleHero()
    {
        try{
            InitializeEconomyHero();
            Hero hero = Hero.builder().build();
            hero = HeroEcoBattleConverter.convert(economyHero);
            assertTrue(false);
        }
        catch (Exception e)
        {
            assertTrue(true);
        }
    }
}
