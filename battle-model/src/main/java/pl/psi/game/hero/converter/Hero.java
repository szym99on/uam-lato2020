package pl.psi.game.hero.converter;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private List<Creature> creatures;
    //private List<Spell> spells;
    private Integer manaPoints;

    @Builder
    public Hero(List<Creature> aCreatures,/*List<Spell> aSpells,*/ Integer aManaPoints) {

        creatures = aCreatures;
        //spells = aSpells;
        manaPoints = aManaPoints;
    }

    public List<Creature> getCreatures() {
        return new ArrayList<>(creatures);
    }
    /*public List<Spell> getSpells() {
        return new ArrayList<>(spells);
    }*/

    public Integer getManaPoints() {
        return manaPoints;
    }
}
