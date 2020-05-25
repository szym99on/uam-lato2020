package pl.psi.game.hero.converter;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.economyHero.EconomyHero;

import java.util.ArrayList;
import java.util.List;

public class HeroEcoBattleConverter {

    public Hero convertEconomyHeroToBattleHero(EconomyHero aHero) {
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = Hero.builder().aCreatures(creatures).build();
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
        return hero;
    }
}
