package pl.psi.game.hero.converter;

import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.EconomyHero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroEcoBattleConverter {

    public Hero convertEconomyHeroToBattleHero(EconomyHero aEconomyHero) {
        //build hero using ecohero
        //
        //apply skills
        //aHero.getSkills().map(skillInfo -> ???).foreach(skill -> skill.apply(hero);
        //apply artifacts
        //aHero.getArtifacts().map(artifactInfo -> ???).foreach(artifact -> artifact.apply(hero);
        //get spells
        //hero.addSpells(aHero.getSpells().map(spellInfo -> ???))
        //get creatures
        //
        //convert knowledge to manapoints
        //
        //apply attack and defense on creatures
        //
        //apply power on spells


        //initialize factories
        CreatureAbstractFactory creatureFactory = new CreatureAbstractFactory();
        List<Creature> covertedCreatures = aEconomyHero.getCreatures().stream().map(creatureFactory::getCreature).collect(Collectors.toList());

        Hero hero = Hero.builder().aCreatures(covertedCreatures).build();
        //hero.increaseAttack(aEconomyHero.getAttack());
        //hero.increaseDefence(aEconomyHero.getDefence());
        //hero.increasePower(aEconomyHero.getPower());
        //hero.increaseKnowledge(aEconomyHero.getKnowledge());
        //aEconomyHero.getArtifacts().forEach(a -> a.apply(heroEco));
        return hero;
    }

}
