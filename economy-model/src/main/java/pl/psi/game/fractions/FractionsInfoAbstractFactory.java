package pl.psi.game.fractions;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class FractionsInfoAbstractFactory {

    public enum Fractions {
        NECROPOLIS,
        RAMPART,
        STRONGHOLD;
    }

    protected final List<CreatureInfo> creatureList = new ArrayList<>();

    public static FractionsInfoAbstractFactory getFactory(Fractions aFraction) {
        switch (aFraction){
            case NECROPOLIS:
                return new NecropolisInfoFactory();
            case RAMPART:
                return new RampartInfoFactory();
            case STRONGHOLD:
                return new StrongholdInfoFactory();
            default: throw new UnsupportedOperationException("Fracction not recognized");
        }
    }

    public CreatureInfo getCreature(String aName) {
        return creatureList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }

    public CreatureInfo getCreatureByTier(int aTier){
        Preconditions.checkArgument(aTier >= 1 && aTier <= 7, "We support tiers 1-7");
        return creatureList.get(aTier - 1);
    }
}