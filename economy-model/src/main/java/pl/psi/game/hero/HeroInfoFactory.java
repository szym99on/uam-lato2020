package pl.psi.game.hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HeroInfoFactory {
    //public final static String STRONGHOLD = "Stronghold";
    //public final static String NECROPOLIS = "Necropolis";
    //public final static String RAMPART = "Rampart";
    //more fractions to come...

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
    // more heroes names to come...

    private final static List<HeroInfo> heroList = new ArrayList<>();
    {
        //CASTLE
        heroList.add(HeroInfo.builder().aName(EDRIC).aFraction(HeroInfo.Fraction.CASTLE).aFractionClass(HeroInfo.FractionClass.KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(SORSHA).aFraction(HeroInfo.Fraction.CASTLE).aFractionClass(HeroInfo.FractionClass.KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(INGHAM).aFraction(HeroInfo.Fraction.CASTLE).aFractionClass(HeroInfo.FractionClass.CLERIC).build());
        heroList.add(HeroInfo.builder().aName(ADELA).aFraction(HeroInfo.Fraction.CASTLE).aFractionClass(HeroInfo.FractionClass.CLERIC).build());
        //TOWER
        heroList.add(HeroInfo.builder().aName(FAFNER).aFraction(HeroInfo.Fraction.TOWER).aFractionClass(HeroInfo.FractionClass.ALCHEMIST).build());
        heroList.add(HeroInfo.builder().aName(IONA).aFraction(HeroInfo.Fraction.TOWER).aFractionClass(HeroInfo.FractionClass.ALCHEMIST).build());
        heroList.add(HeroInfo.builder().aName(ASTRAL).aFraction(HeroInfo.Fraction.TOWER).aFractionClass(HeroInfo.FractionClass.WIZARD).build());
        heroList.add(HeroInfo.builder().aName(AINE).aFraction(HeroInfo.Fraction.TOWER).aFractionClass(HeroInfo.FractionClass.WIZARD).build());
        //INFERNO
        heroList.add(HeroInfo.builder().aName(CALH).aFraction(HeroInfo.Fraction.INFERNO).aFractionClass(HeroInfo.FractionClass.DEMONIAC).build());
        heroList.add(HeroInfo.builder().aName(FIONA).aFraction(HeroInfo.Fraction.INFERNO).aFractionClass(HeroInfo.FractionClass.DEMONIAC).build());
        heroList.add(HeroInfo.builder().aName(AXSIS).aFraction(HeroInfo.Fraction.INFERNO).aFractionClass(HeroInfo.FractionClass.HERETIC).build());
        heroList.add(HeroInfo.builder().aName(ASH).aFraction(HeroInfo.Fraction.INFERNO).aFractionClass(HeroInfo.FractionClass.HERETIC).build());
        //FORTRESS
        heroList.add(HeroInfo.builder().aName(ALKIN).aFraction(HeroInfo.Fraction.FORTRESS).aFractionClass(HeroInfo.FractionClass.BEASTMASTER).build());
        heroList.add(HeroInfo.builder().aName(BROGHILD).aFraction(HeroInfo.Fraction.FORTRESS).aFractionClass(HeroInfo.FractionClass.BEASTMASTER).build());
        heroList.add(HeroInfo.builder().aName(VERDISH).aFraction(HeroInfo.Fraction.FORTRESS).aFractionClass(HeroInfo.FractionClass.WITCH).build());
        heroList.add(HeroInfo.builder().aName(VOY).aFraction(HeroInfo.Fraction.FORTRESS).aFractionClass(HeroInfo.FractionClass.WITCH).build());
        //RAMPART
        heroList.add(HeroInfo.builder().aName(IVOR).aFraction(HeroInfo.Fraction.RAMPART).aFractionClass(HeroInfo.FractionClass.RANGER).build());
        heroList.add(HeroInfo.builder().aName(JENOVA).aFraction(HeroInfo.Fraction.RAMPART).aFractionClass(HeroInfo.FractionClass.RANGER).build());
        heroList.add(HeroInfo.builder().aName(AERIS).aFraction(HeroInfo.Fraction.RAMPART).aFractionClass(HeroInfo.FractionClass.DRUID).build());
        heroList.add(HeroInfo.builder().aName(GEM).aFraction(HeroInfo.Fraction.RAMPART).aFractionClass(HeroInfo.FractionClass.DRUID).build());
        //DUNGEON
        heroList.add(HeroInfo.builder().aName(AJIT).aFraction(HeroInfo.Fraction.DUNGEON).aFractionClass(HeroInfo.FractionClass.OVERLORD).build());
        heroList.add(HeroInfo.builder().aName(LORELEI).aFraction(HeroInfo.Fraction.DUNGEON).aFractionClass(HeroInfo.FractionClass.OVERLORD).build());
        heroList.add(HeroInfo.builder().aName(ALAMAR).aFraction(HeroInfo.Fraction.DUNGEON).aFractionClass(HeroInfo.FractionClass.WARLOCK).build());
        heroList.add(HeroInfo.builder().aName(SEPHINROTH).aFraction(HeroInfo.Fraction.DUNGEON).aFractionClass(HeroInfo.FractionClass.WARLOCK).build());
        //STRONGHOLD
        heroList.add(HeroInfo.builder().aName(CRAG_HACK).aFraction(HeroInfo.Fraction.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BARBARIAN).build());
        heroList.add(HeroInfo.builder().aName(SHIVA).aFraction(HeroInfo.Fraction.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BARBARIAN).build());
        heroList.add(HeroInfo.builder().aName(DESSA).aFraction(HeroInfo.Fraction.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BATTLE_MAGE).build());
        heroList.add(HeroInfo.builder().aName(ORIS).aFraction(HeroInfo.Fraction.STRONGHOLD).aFractionClass(HeroInfo.FractionClass.BATTLE_MAGE).build());
        //NECROPOLIS
        heroList.add(HeroInfo.builder().aName(CLAVIUS).aFraction(HeroInfo.Fraction.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.DEATH_KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(CHARNA).aFraction(HeroInfo.Fraction.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.DEATH_KNIGHT).build());
        heroList.add(HeroInfo.builder().aName(SANDRO).aFraction(HeroInfo.Fraction.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.NECROMANCER).build());
        heroList.add(HeroInfo.builder().aName(SEPTIENNA).aFraction(HeroInfo.Fraction.NECROPOLIS).aFractionClass(HeroInfo.FractionClass.NECROMANCER).build());
        //CONFLUX
        heroList.add(HeroInfo.builder().aName(FIUR).aFraction(HeroInfo.Fraction.CONFLUX).aFractionClass(HeroInfo.FractionClass.PLANESWALKER).build());
        heroList.add(HeroInfo.builder().aName(IGNISSA).aFraction(HeroInfo.Fraction.CONFLUX).aFractionClass(HeroInfo.FractionClass.PLANESWALKER).build());
        heroList.add(HeroInfo.builder().aName(AENAIN).aFraction(HeroInfo.Fraction.CONFLUX).aFractionClass(HeroInfo.FractionClass.ELEMENTALIS).build());
        heroList.add(HeroInfo.builder().aName(BRISSA).aFraction(HeroInfo.Fraction.CONFLUX).aFractionClass(HeroInfo.FractionClass.ELEMENTALIS).build());
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
