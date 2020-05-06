package pl.psi.game.hero.artifacts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArtifactsInfoFactory {

    private final static String HELM_OF_THE_ALABASTER_UNICORN = "Helm of the Alabaster Unicorn";
    private final static String SKULL_HELMET = "Skull Helmet";
    private final static String HELM_OF_CHAOS = "Helm of Chaos";
    private final static String CROWN_OF_THE_SUPREME_MAGI = "Crown of the Supreme Magi";
    private final static String HELLSTORM_HELMET = "Hellstorm Helmet";
    private final static String NECKLACE_OF_DRAGONTEETH = "Necklace of Dragonteeth";
    private final static String CELESTIAL_NECKLACE_OF_BLISS = "Celestial Necklace of Bliss";
    private final static String COLLAR_OF_CONJURING = "Collar of Conjuring";
    private final static String PENDANT_OF_DISPASSION = "Pendant of Dispassion";
    private final static String PENDANT_OF_LIFE = "Pendant of Life";
    private final static String BREASTPLATE_OF_PETRIFIED_WOOD = "Breastplate of Petrified Wood";
    private final static String RIB_CAGE = "Rib Cage";
    private final static String DRAGON_SCALE_ARMOR = "Dragon Scale Armor";
    private final static String ARMOR_OF_WONDER = "Armor of Wonder";
    private final static String TITANS_CUIRAS = "Titan's Cuiras";
    private final static String CAPE_OF_CONJURING = "Cape of Conjuring";
    private final static String DRAGON_WING_TABARD = "Dragon Wing Tabard";
    private final static String SURCOAT_OF_COUNTERPOISE = "Surcoat of Counterpoise";
    private final static String RECANTERS_CLOAK = "Recanter's Cloak";
    private final static String CAPE_OF_VELOCITY = "Cape of Velocity";
    private final static String CENTAURS_AX = "Centaur's Ax";
    private final static String BLACKSHARD_OF_THE_DEAD_KNIGHT = "Blackshard of the Dead Knight";
    private final static String GREATER_GNOLLS_FLAIL = "Greater Gnoll's Flail";
    private final static String OGRES_CLUB_OF_HAVOC = "Ogre's Club of Havoc";
    private final static String TITANS_GLADIUS = "Titan's Gladius";
    private final static String SHIELD_OF_THE_DWARVEN_LORDS = "Shield of the Dwarven Lords";
    private final static String SHIELD_OF_THE_YAWNING_DEAD = "Shield of the Yawning Dead";
    private final static String BUCKLER_OF_THE_GNOLL_KING = "Buckler of the Gnoll King";
    private final static String TARG_OF_THE_RAMPAGING_OGRE = "Targ of the Rampaging Ogre";
    private final static String SENTINELS_SHIELD = "Sentinel's Shield";
    private final static String RING_OF_VITALITY = "Ring of Vitality";
    private final static String RING_OF_LIFE = "Ring of Life";
    private final static String RING_OF_CONJURING = "Ring of Conjuring";
    private final static String RING_OF_THE_WAYFARER = "Ring of the Wayfarer";
    private final static String QUIET_EYE_OF_THE_DRAGON = "Quiet Eye of the Dragon";
    private final static String SANDALS_OF_THE_SAINT = "Sandals of the Saint";
    private final static String DRAGONBONE_GREAVES = "Dragonbone Greaves";
    private final static String BOOTS_OF_POLARITY = "Boots of Polarity";
    private final static String GUARDIANS_BOOTS = "Guardian’s Boots";
    private final static String MAGISTERS_SANDALS = "Magister’s Sandals";


    private final static List<ArtifactInfo> artifactList = new ArrayList<>();
    {
        artifactList.add(ArtifactInfo.builder().aCost(1000).aDescription("+1 knowledge").aName(HELM_OF_THE_ALABASTER_UNICORN).aLocation(ArtifactInfo.Location.HEAD).build());
        artifactList.add(ArtifactInfo.builder().aCost(3000).aDescription("+2 knowledge").aName(SKULL_HELMET).aLocation(ArtifactInfo.Location.HEAD).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+3 knowledge").aName(HELM_OF_CHAOS).aLocation(ArtifactInfo.Location.HEAD).build());
        artifactList.add(ArtifactInfo.builder().aCost(5000).aDescription("+4 knowledge").aName(CROWN_OF_THE_SUPREME_MAGI).aLocation(ArtifactInfo.Location.HEAD).build());
        artifactList.add(ArtifactInfo.builder().aCost(6000).aDescription("+5 knowledge").aName(HELLSTORM_HELMET).aLocation(ArtifactInfo.Location.HEAD).build());
        artifactList.add(ArtifactInfo.builder().aCost(6000).aDescription("+3 spell power, +3 knowledge").aName(NECKLACE_OF_DRAGONTEETH).aLocation(ArtifactInfo.Location.NECK).build());
        artifactList.add(ArtifactInfo.builder().aCost(12000).aDescription("+3 to all 4 primary skills").aName(CELESTIAL_NECKLACE_OF_BLISS).aLocation(ArtifactInfo.Location.NECK).build());
        artifactList.add(ArtifactInfo.builder().aCost(500).aDescription("+1 spells duration").aName(COLLAR_OF_CONJURING).aLocation(ArtifactInfo.Location.NECK).build());
        artifactList.add(ArtifactInfo.builder().aCost(1000).aDescription("Renders your units immune to the berserk spell (4 level in the School of fire magic)").aName(PENDANT_OF_DISPASSION).aLocation(ArtifactInfo.Location.NECK).build());
        artifactList.add(ArtifactInfo.builder().aCost(2500).aDescription("Renders your units immune to the death ripple spell (2nd level spell in the School of Earth Magic)\n").aName(PENDANT_OF_LIFE).aLocation(ArtifactInfo.Location.NECK).build());
        artifactList.add(ArtifactInfo.builder().aCost(1000).aDescription("+1 spell power").aName(BREASTPLATE_OF_PETRIFIED_WOOD).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(3000).aDescription("+2 spell power").aName(RIB_CAGE).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(8000).aDescription("+4 to attack, +4 defence ").aName(DRAGON_SCALE_ARMOR).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+1 to all 4 primary skills").aName(ARMOR_OF_WONDER).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(10000).aDescription("+10 spell power, -2 knowledge").aName(TITANS_CUIRAS).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(1500).aDescription("+3 spells duration").aName(CAPE_OF_CONJURING).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+2 spell power, +2 knowledge ").aName(DRAGON_WING_TABARD).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+10% to magic resistance").aName(SURCOAT_OF_COUNTERPOISE).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(8000).aDescription("Prevents casting spells of level 3 and higher in combat").aName(RECANTERS_CLOAK).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(10000).aDescription("+2 units speed").aName(CAPE_OF_VELOCITY).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(2000).aDescription("+2 attack skill").aName(CENTAURS_AX).aLocation(ArtifactInfo.Location.RIGHT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(3000).aDescription("+3 attack skill").aName(BLACKSHARD_OF_THE_DEAD_KNIGHT).aLocation(ArtifactInfo.Location.RIGHT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+4 attack skill").aName(GREATER_GNOLLS_FLAIL).aLocation(ArtifactInfo.Location.RIGHT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(5000).aDescription("+5 attack skill").aName(OGRES_CLUB_OF_HAVOC).aLocation(ArtifactInfo.Location.RIGHT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(10000).aDescription("+12 attack skill, -3 defence skill").aName(TITANS_GLADIUS).aLocation(ArtifactInfo.Location.RIGHT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(2000).aDescription("+2 defence skill").aName(SHIELD_OF_THE_DWARVEN_LORDS).aLocation(ArtifactInfo.Location.LEFT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(3000).aDescription("+3 defence skill").aName(SHIELD_OF_THE_YAWNING_DEAD).aLocation(ArtifactInfo.Location.LEFT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+4 defence skill").aName(BUCKLER_OF_THE_GNOLL_KING).aLocation(ArtifactInfo.Location.LEFT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(5000).aDescription("+5 defence skill").aName(TARG_OF_THE_RAMPAGING_OGRE).aLocation(ArtifactInfo.Location.LEFT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(10000).aDescription("+12 defence skill, -3 attack skill").aName(SENTINELS_SHIELD).aLocation(ArtifactInfo.Location.LEFT_HAND).build());
        artifactList.add(ArtifactInfo.builder().aCost(5000).aDescription("+1 untis health").aName(RING_OF_VITALITY).aLocation(ArtifactInfo.Location.FINGERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(7000).aDescription("+2 untis health").aName(RING_OF_LIFE).aLocation(ArtifactInfo.Location.FINGERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(1000).aDescription("+2 spells duration").aName(RING_OF_CONJURING).aLocation(ArtifactInfo.Location.FINGERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(5000).aDescription("+1 units speed").aName(RING_OF_THE_WAYFARER).aLocation(ArtifactInfo.Location.FINGERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(2000).aDescription("+1 to attack, +1 defence").aName(QUIET_EYE_OF_THE_DRAGON).aLocation(ArtifactInfo.Location.FINGERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(8000).aDescription("+2 to all 4 primary skills").aName(SANDALS_OF_THE_SAINT).aLocation(ArtifactInfo.Location.FEET).build());
        artifactList.add(ArtifactInfo.builder().aCost(2000).aDescription("+1 spell power,+1 knowledge").aName(DRAGONBONE_GREAVES).aLocation(ArtifactInfo.Location.FEET).build());
        artifactList.add(ArtifactInfo.builder().aCost(6000).aDescription("+15% to magic resistance").aName(BOOTS_OF_POLARITY).aLocation(ArtifactInfo.Location.FEET).build());
        artifactList.add(ArtifactInfo.builder().aCost(3000).aDescription("+3 defence skill").aName(GUARDIANS_BOOTS).aLocation(ArtifactInfo.Location.FEET).build());
        artifactList.add(ArtifactInfo.builder().aCost(3000).aDescription("+2 spell power").aName(MAGISTERS_SANDALS).aLocation(ArtifactInfo.Location.FEET).build());
    }

    public static ArtifactInfo getArtifact(String aName){
        return artifactList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }

    public static List<ArtifactInfo> getByLocation(ArtifactInfo.Location aLocation){
        return artifactList.stream().filter(s -> s.getLocation() == aLocation).collect(Collectors.toList());
    }

    public static List<ArtifactInfo> getByCost(int aCost){
        return artifactList.stream().filter(s -> s.getCost() == aCost).collect(Collectors.toList());
    }


}
