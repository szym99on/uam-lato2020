package pl.psi.game.hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HeroInfoFactory {

    public final static String CHARNA = "Charna";
    public final static String ISRA = "Isra";
    // more heroes names to come...

    private final static List<HeroInfo> heroList = new ArrayList<>();
    {
        heroList.add(HeroInfo.builder().aName(ISRA).aFraction(HeroInfo.Fraction.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.DeathKnight).build());
    }

    public static List<HeroInfo> getAll(){
        return Collections.unmodifiableList(heroList);
    }
    public static HeroInfo getHeroInfoByName(String aName){
        return heroList.stream().filter(h -> h.getName().endsWith(aName)).findAny().orElseThrow();
    }
    public static List<HeroInfo> getHeroInfoListByFraction(HeroInfo.Fraction aFraction){
        return heroList.stream().filter(h -> h.getFraction().equals(aFraction)).collect(Collectors.toList());
    }
}
