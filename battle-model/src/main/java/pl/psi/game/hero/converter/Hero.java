package pl.psi.game.hero.converter;

import lombok.Builder;
import pl.psi.game.fractions.Creature;
import pl.psi.game.skills.Skill;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBook;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private List<Creature> creatures;
    private Skill skill;
    private SpellBook spellBook;
    private int attack;
    private int defence;
    private int power;
    private int knowledge;

    @Builder
    public Hero(List<Creature> aCreatures,Skill aSkill) {

        creatures = aCreatures;
        skill = aSkill;
        attack = 0;
        defence = 0;
        power = 0;
        knowledge = 0;
        spellBook = SpellBook.builder().build();
    }

    public List<Creature> getCreatures() {
        return creatures;
    }
    public SpellBook getSpellBook() {
        return spellBook;
    }
    public void setMana() {
        //spellBook.setMana(knowledge*10);
    }
    public void increaseDuration(int aAmount){
        //spellBook.increaseDuration(aAmount);
    }
    public void increaseSpellPower() {
        spellBook.increaseHeroPower(power);
    }
    public void addSpells(List<Spell> aSpells) {
        //spellBook.addSpells(aSpells);
    }

    public void increaseAttack(int aAmount) {
        if (attack + aAmount < 0){
            attack = 0;
        }
        else{
            attack += aAmount;
        }
    }
    public void increaseDefence(int aAmount) {
        if (defence + aAmount < 0){
            defence = 0;
        }
        else{
            defence += aAmount;
        }
    }
    public void increasePower(int aAmount) {
        if (power + aAmount < 0){
            power = 0;
        }
        else{
            power += aAmount;
        }
        //spellBook.increasePower(aAmount);
    }
    public void increaseKnowledge(int aAmount) {
        if (knowledge + aAmount < 0){
            knowledge = 0;
        }
        else{
            knowledge += aAmount;
        }
        //spellBook.increaseMana(aAmount*10);
    }

    public Integer getAttack() {
        return attack;
    }
    public Integer getDefence() {
        return defence;
    }
    public Integer getPower() {
        return power;
    }
    public Integer getKnowledge() {
        return knowledge;
    }


}
