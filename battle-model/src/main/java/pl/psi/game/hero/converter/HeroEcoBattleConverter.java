package pl.psi.game.hero.converter;

import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.EconomyHero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroEcoBattleConverter {

    public Hero convertEconomyHeroToBattleHero(EconomyHero aHero) {
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

//        EconomyHero a = new EconomyHero();
//        CreatureAbstractFactory factory = new CreatureAbstractFactory();
//        List<Creature> covertedCretures = a.getCreatures().stream().map(factory::getCreature).collect(Collectors.toList());
//        Hero hero = Hero.builder().aCreatures(covertedCretures).build();
//        heroEco.getArtifacts().forEach(a -> a.apply(heroEco));
//        return hero;
        return null;
    }

}
