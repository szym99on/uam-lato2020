package pl.psi.game.hero.converter;

import lombok.Builder;
import pl.psi.game.fractions.Creature;
import pl.psi.game.skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private List<Creature> creatures;
    private Skill skill;
    //private List<Spell> spells;
    //private int manaPoints;
    private int attack;
    private int defense;
    private int power;
    private int knowledge;

    @Builder
    public Hero(List<Creature> aCreatures,Skill aSkill /*,List<Spell> aSpells, int aManaPoints, int aAttack, int aDefense, int aPower, int aKnowledge*/) {

        creatures = aCreatures;
        skill = aSkill;
        //spells = aSpells;
        //manaPoints = aManaPoints;
        attack = 0;
        defense = 0;
        power = 0;
        knowledge = 0;
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


    public void increaseAttack(int aAmount) {
        if (attack + aAmount < 0){
            attack = 0;
        }
        else{
            attack += aAmount;
        }
    }
    public void increaseDefense(int aAmount) {
        if (defense + aAmount < 0){
            defense = 0;
        }
        else{
            defense += aAmount;
        }
    }
    public void increasePower(int aAmount) {
        if (power + aAmount < 0){
            power = 0;
        }
        else{
            power += aAmount;
        }
    }
    public void increaseKnowledge(int aAmount) {
        if (knowledge + aAmount < 0){
            knowledge = 0;
        }
        else{
            knowledge += aAmount;
        }
    }

    public Integer getAttack() {
        return attack;
    }
    public Integer getDefense() {
        return defense;
    }
    public Integer getPower() {
        return power;
    }
    public Integer getKnowledge() {
        return knowledge;
    }
}
