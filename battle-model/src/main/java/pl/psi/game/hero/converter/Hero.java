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
    public Hero(List<Creature> aCreatures,Skill aSkill,List<Spell> aSpells) {

        creatures = aCreatures;
        skill = aSkill;
        spellBook = new SpellBook(power,knowledge*10,aSpells);
        attack = 0;
        defence = 0;
        power = 0;
        knowledge = 0;
    }

    public List<Creature> getCreatures() {
        return new ArrayList<>(creatures);
    }
    public List<Spell> getSpells() {
        //return new spellBook.getSpells();
        return new ArrayList<Spell>();
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
