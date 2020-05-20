package pl.psi.game.hero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroInfoFactory {
    public final static String STRONGHOLD = "Stronghold";
    public final static String NECROPOLIS = "Necropolis";
    public final static String RAMPART = "Rampart";
    //more fractions to come...

    public final static String CHARNA = "Charna";
    public final static String ISRA = "Isra";
    // more heroes names to come...

    private final static List<HeroInfo> heroList = new ArrayList<>();
    {
        heroList.add(HeroInfo.builder().aName(ISRA).aFraction(NECROPOLIS).aAttack(1).aDefense(2).aPower(2).aKnowledge(1).build());
    }

    public final static HeroInfo getHeroInfoByName(String aName){
        return heroList.stream().filter(h -> h.getName().endsWith(aName)).findAny().orElseThrow();
    }
    public final static List<HeroInfo> getHeroListByFraction(String aFraction){
        return heroList.stream().filter(h -> h.getFraction()==aFraction).collect(Collectors.toList());
    }
}
