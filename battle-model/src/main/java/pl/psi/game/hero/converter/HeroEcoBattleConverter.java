package pl.psi.game.hero.converter;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.EconomyHero;

import java.util.ArrayList;
import java.util.List;

public class HeroEcoBattleConverter {

    public Hero convertEconomyHeroToBattleHero(EconomyHero aHero) {
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = Hero.builder().aCreatures(creatures).build();
        //build hero using ecohero
        //apply skills
        //apply artifacts
        return hero;
    }
}
