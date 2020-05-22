package pl.psi.game.fractions;

import java.util.ArrayList;
import java.util.List;

public class FractionsInfoAbstractFactory {

    private final static List<CreatureInfo> creatureList = new ArrayList<>();
    
    public static CreatureInfo getCreature(String aName){
        return creatureList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }
    
    public static FractionsInfoAbstractFactory getFactory(String aName) {
    	switch (aName) {
			case "Necropolis":
				return new NecropolisInfoFactory();
			case "Rampart":
				return new RampartInfoFactory();
			case "Stronghold":
				return new StrongholdInfoFactory();
			case "Elemental":
				return new ElementalInfoFactory();
			default:
				throw new IllegalArgumentException("No factory with name " + aName + " was found.");
		}
    }
    
    public CreatureInfo getByTier(int aTier) {
    	return creatureList.get(aTier-1);
    }
}