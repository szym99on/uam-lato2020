package pl.psi.game.hero.converter;

import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroEcoBattleConverter {

    public static Hero convert(EconomyHero aEconomyHero) {
        //apply attack and defense on creatures
        //initialize factories
        CreatureAbstractFactory creatureFactory = new CreatureAbstractFactory();

        List<Creature> convertedCreatures = aEconomyHero.getCreatures().stream().map(creatureFactory::getCreature).collect(Collectors.toList());
        List<Artifact> convertedArtifacts = aEconomyHero.getArtifacts().stream().map(ArtifactFactory::createArtifact).collect(Collectors.toList());

        Hero hero = Hero.builder().aCreatures(convertedCreatures).build();
        hero.increaseAttack(aEconomyHero.getAttack());
        hero.increaseDefence(aEconomyHero.getDefence());
        hero.increasePower(aEconomyHero.getPower());
        hero.increaseKnowledge(aEconomyHero.getKnowledge());
        hero.getSpellBook().increaseHeroPower(hero.getPower());

        aEconomyHero.getSpells().forEach(s -> hero.getSpellBook().createSpell(s));
        convertedArtifacts.forEach(a -> a.apply(hero));
        hero.getCreatures().forEach(c -> c.apply(hero));
        return hero;
    }

}
