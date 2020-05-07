package pl.psi.game.hero.converter;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.EconomyHero;

import java.util.ArrayList;
import java.util.List;

public class HeroEcoBattleConverter {

    public Hero convertEconomyHeroToBattleHero(EconomyHero aHero) {
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = Hero.builder().aCreatures(creatures).build();
        //aHero.getArtifacts().foreach(a -> hero.getCreatures().forEach(c -> c.applyEffectsOfArtifact(a)));
        //aHero.getArtifacts().foreach(a -> hero.getSpells().forEach(s -> s.applyEffectsOfArtifact(a)));
        return hero;
    }
}
