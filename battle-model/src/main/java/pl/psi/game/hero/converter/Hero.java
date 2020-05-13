package pl.psi.game.hero.converter;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private List<Creature> creatures;
    //private List<Spell> spells;
    //private Integer manaPoints;
    //private Integer attack;
    //private Integer defense;
    //private Integer power;
    //private Integer knowledge;

    @Builder
    public Hero(List<Creature> aCreatures /*,List<Spell> aSpells, Integer aManaPoints, Integer aAttack, Integer aDefense, Integer aPower, Integer aKnowledge*/) {

        creatures = aCreatures;
        //spells = aSpells;
        //manaPoints = aManaPoints;
        //attack = aAttack;
        //defense = aDefense;
        //power = aPower;
        //knowledge = aKnowledge;
    }

    public List<Creature> getCreatures() {
        return new ArrayList<>(creatures);
    }
    /*public List<Spell> getSpells() {
        return new ArrayList<>(spells);
    }*/

//    public Integer getManaPoints() {
//        return manaPoints;
//    }

/*
    public void increaseAttack(int aAmount) {
    }

    public void increaseDefense(int aAmount) {
    }

    public void increasePower(int aAmount) {
    }

    public void increaseKnowledge(int aAmount) {
    }
    */
}
