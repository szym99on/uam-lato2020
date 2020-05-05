package pl.psi.game.hero.converter;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private final List<Creature> creatures;
    private Integer manaPoints;

    @Builder
    public Hero(List<Creature> aCreatures, Integer aManaPoints) {

        creatures = aCreatures;
        manaPoints = aManaPoints;
    }

    public List<Creature> getCreatures() {
        return new ArrayList<>(creatures);
    }

    public Integer getManaPoints() {
        return manaPoints;
    }
}
