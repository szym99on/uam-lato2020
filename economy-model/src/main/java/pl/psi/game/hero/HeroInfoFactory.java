package pl.psi.game.hero;

import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HeroInfoFactory {

    //KNIGHT
    public final static String EDRIC = "Edric";
    public final static String SORSHA = "Sorsha";
    //CLERIC
    public final static String INGHAM = "Ingham";
    public final static String ADELA = "Adela";
    //ALCHEMIST
    public final static String FAFNER = "Fafner";
    public final static String IONA = "Iona";
    //WIZARD
    public final static String ASTRAL = "Astral";
    public final static String AINE = "Aine";
    //DEMONIAC
    public final static String CALH = "Calh";
    public final static String FIONA = "Fiona";
    //HERETIC
    public final static String AXSIS = "Axsis";
    public final static String ASH = "Ash";
    //BEASTMASTER
    public final static String ALKIN = "Alkin";
    public final static String BROGHILD = "Broghild";
    //WITCH
    public final static String VERDISH = "Verdish";
    public final static String VOY = "Voy";
    //RANGER
    public final static String IVOR = "Ivor";
    public final static String JENOVA = "Jenova";
    //DRUID
    public final static String AERIS = "Aeris";
    public final static String GEM = "Gem";
    //OVERLORD
    public final static String AJIT = "Ajit";
    public final static String LORELEI = "Lorelei";
    //WARLOCK
    public final static String ALAMAR = "Alamar";
    public final static String SEPHINROTH = "Sephinroth";
    //BARBARIAN
    public final static String CRAG_HACK = "Crag Hack";
    public final static String SHIVA = "Shiva";
    //BATTLE MAGE
    public final static String DESSA = "Dessa";
    public final static String ORIS = "Oris";
    //DEATH KNIGHT
    public final static String CLAVIUS = "Clavius";
    public final static String CHARNA = "Charna";
    //NECROMANCER
    public final static String SANDRO = "Sandro";
    public final static String SEPTIENNA = "Septienna";
    //PLANESWALKER
    public final static String FIUR = "Fiur";
    public final static String IGNISSA = "Ignissa";
    //ELEMENTALIST
    public final static String AENAIN = "Aenain";
    public final static String BRISSA = "Brissa";

    private final static List<HeroInfo> heroList = new ArrayList<>();
    {
        //CASTLE
        heroList.add(HeroInfo.builder().aName(EDRIC).aFraction(FractionsInfoAbstractFactory.Fractions.CASTLE).aFractionClass(HeroInfo.FractionClass.KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(SORSHA).aFraction(FractionsInfoAbstractFactory.Fractions.CASTLE).aFractionClass(HeroInfo.FractionClass.KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(INGHAM).aFraction(FractionsInfoAbstractFactory.Fractions.CASTLE).aFractionClass(HeroInfo.FractionClass.CLERIC).build());
        heroList.add(HeroInfo.builder().aName(ADELA).aFraction(FractionsInfoAbstractFactory.Fractions.CASTLE).aFractionClass(HeroInfo.FractionClass.CLERIC).build());
        //TOWER
        heroList.add(HeroInfo.builder().aName(FAFNER).aFraction(FractionsInfoAbstractFactory.Fractions.TOWER).aFractionClass(HeroInfo.FractionClass.ALCHEMIST).build());
        heroList.add(HeroInfo.builder().aName(IONA).aFraction(FractionsInfoAbstractFactory.Fractions.TOWER).aFractionClass(HeroInfo.FractionClass.ALCHEMIST).build());
        heroList.add(HeroInfo.builder().aName(ASTRAL).aFraction(FractionsInfoAbstractFactory.Fractions.TOWER).aFractionClass(HeroInfo.FractionClass.WIZARD).build());
        heroList.add(HeroInfo.builder().aName(AINE).aFraction(FractionsInfoAbstractFactory.Fractions.TOWER).aFractionClass(HeroInfo.FractionClass.WIZARD).build());
        //INFERNO
        heroList.add(HeroInfo.builder().aName(CALH).aFraction(FractionsInfoAbstractFactory.Fractions.INFERNO).aFractionClass(HeroInfo.FractionClass.DEMONIAC).build());
        heroList.add(HeroInfo.builder().aName(FIONA).aFraction(FractionsInfoAbstractFactory.Fractions.INFERNO).aFractionClass(HeroInfo.FractionClass.DEMONIAC).build());
        heroList.add(HeroInfo.builder().aName(AXSIS).aFraction(FractionsInfoAbstractFactory.Fractions.INFERNO).aFractionClass(HeroInfo.FractionClass.HERETIC).build());
        heroList.add(HeroInfo.builder().aName(ASH).aFraction(FractionsInfoAbstractFactory.Fractions.INFERNO).aFractionClass(HeroInfo.FractionClass.HERETIC).build());
        //FORTRESS
        heroList.add(HeroInfo.builder().aName(ALKIN).aFraction(FractionsInfoAbstractFactory.Fractions.FORTRESS).aFractionClass(HeroInfo.FractionClass.BEASTMASTER).build());
        heroList.add(HeroInfo.builder().aName(BROGHILD).aFraction(FractionsInfoAbstractFactory.Fractions.FORTRESS).aFractionClass(HeroInfo.FractionClass.BEASTMASTER).build());
        heroList.add(HeroInfo.builder().aName(VERDISH).aFraction(FractionsInfoAbstractFactory.Fractions.FORTRESS).aFractionClass(HeroInfo.FractionClass.WITCH).build());
        heroList.add(HeroInfo.builder().aName(VOY).aFraction(FractionsInfoAbstractFactory.Fractions.FORTRESS).aFractionClass(HeroInfo.FractionClass.WITCH).build());
        //RAMPART
        heroList.add(HeroInfo.builder().aName(IVOR).aFraction(FractionsInfoAbstractFactory.Fractions.RAMPART).aFractionClass(HeroInfo.FractionClass.RANGER).build());
        heroList.add(HeroInfo.builder().aName(JENOVA).aFraction(FractionsInfoAbstractFactory.Fractions.RAMPART).aFractionClass(HeroInfo.FractionClass.RANGER).build());
        heroList.add(HeroInfo.builder().aName(AERIS).aFraction(FractionsInfoAbstractFactory.Fractions.RAMPART).aFractionClass(HeroInfo.FractionClass.DRUID).build());
        heroList.add(HeroInfo.builder().aName(GEM).aFraction(FractionsInfoAbstractFactory.Fractions.RAMPART).aFractionClass(HeroInfo.FractionClass.DRUID).build());
        //DUNGEON
        heroList.add(HeroInfo.builder().aName(AJIT).aFraction(FractionsInfoAbstractFactory.Fractions.DUNGEON).aFractionClass(HeroInfo.FractionClass.OVERLORD).build());
        heroList.add(HeroInfo.builder().aName(LORELEI).aFraction(FractionsInfoAbstractFactory.Fractions.DUNGEON).aFractionClass(HeroInfo.FractionClass.OVERLORD).build());
        heroList.add(HeroInfo.builder().aName(ALAMAR).aFraction(FractionsInfoAbstractFactory.Fractions.DUNGEON).aFractionClass(HeroInfo.FractionClass.WARLOCK).build());
        heroList.add(HeroInfo.builder().aName(SEPHINROTH).aFraction(FractionsInfoAbstractFactory.Fractions.DUNGEON).aFractionClass(HeroInfo.FractionClass.WARLOCK).build());
        //STRONGHOLD
        heroList.add(HeroInfo.builder().aName(CRAG_HACK).aFraction(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BARBARIAN).build());
        heroList.add(HeroInfo.builder().aName(SHIVA).aFraction(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BARBARIAN).build());
        heroList.add(HeroInfo.builder().aName(DESSA).aFraction(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BATTLE_MAGE).build());
        heroList.add(HeroInfo.builder().aName(ORIS).aFraction(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BATTLE_MAGE).build());
        //NECROPOLIS
        heroList.add(HeroInfo.builder().aName(CLAVIUS).aFraction(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.DEATH_KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(CHARNA).aFraction(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.DEATH_KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(SANDRO).aFraction(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.NECROMANCER).build());
        heroList.add(HeroInfo.builder().aName(SEPTIENNA).aFraction(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.NECROMANCER).build());
        //CONFLUX
        heroList.add(HeroInfo.builder().aName(FIUR).aFraction(FractionsInfoAbstractFactory.Fractions.CONFLUX).aFractionClass(HeroInfo.FractionClass.PLANESWALKER).build());
        heroList.add(HeroInfo.builder().aName(IGNISSA).aFraction(FractionsInfoAbstractFactory.Fractions.CONFLUX).aFractionClass(HeroInfo.FractionClass.PLANESWALKER).build());
        heroList.add(HeroInfo.builder().aName(AENAIN).aFraction(FractionsInfoAbstractFactory.Fractions.CONFLUX).aFractionClass(HeroInfo.FractionClass.ELEMENTALIS).build());
        heroList.add(HeroInfo.builder().aName(BRISSA).aFraction(FractionsInfoAbstractFactory.Fractions.CONFLUX).aFractionClass(HeroInfo.FractionClass.ELEMENTALIS).build());
    }

    public static List<HeroInfo> getAll(){
        return Collections.unmodifiableList(heroList);
    }
    public static HeroInfo getHeroInfoByName(String aName){
        return heroList.stream().filter(h -> h.getName().endsWith(aName)).findAny().orElseThrow();
    }
    public static List<HeroInfo> getHeroInfoListByFraction(FractionsInfoAbstractFactory.Fractions aFraction){
        return heroList.stream().filter(h -> h.getFraction().equals(aFraction)).collect(Collectors.toList());
    }
}
