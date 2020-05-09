package pl.psi.game.fractions;

import java.util.ArrayList;
import java.util.List;

public class FractionsInfoAbstractFactory {

    private final static List<CreatureInfo> creatureList = new ArrayList<>();
    public static CreatureInfo getCreature(String aName){
        return creatureList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }
}