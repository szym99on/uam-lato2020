package pl.psi.game.hero.converter;

import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroEcoBattleConverter {

    public static Hero convert(EconomyHero aEconomyHero) {
        //initialize factories
        CreatureAbstractFactory creatureFactory = new CreatureAbstractFactory();
        SpellFactory spellFactory = new SpellFactory();
        List<Creature> convertedCreatures = aEconomyHero.getCreatures().stream().map(creatureFactory::getCreature).collect(Collectors.toList());
        List<Artifact> convertedArtifacts = aEconomyHero.getArtifacts().stream().map(ArtifactFactory::createArtifact).collect(Collectors.toList());
        List<Spell> convertedSpells = aEconomyHero.getSpells().stream().map(spellFactory::createSpell).collect(Collectors.toList());

        Hero hero = Hero.builder().aCreatures(convertedCreatures).build();
        hero.increaseAttack(aEconomyHero.getAttack());
        hero.increaseDefence(aEconomyHero.getDefence());
        hero.increasePower(aEconomyHero.getPower());
        hero.increaseKnowledge(aEconomyHero.getKnowledge());

        //convertedArtifacts.stream().filter(a -> a.changeHeroStats()).forEach(a -> a.apply(hero));
        hero.addSpells(convertedSpells);
        hero.increaseSpellPower();
        hero.getCreatures().forEach(c -> c.apply(hero));
        //convertedArtifacts.stream().filter(a -> !a.changeHeroStats()).forEach(a -> a.apply(hero));
        return hero;
    }

}
