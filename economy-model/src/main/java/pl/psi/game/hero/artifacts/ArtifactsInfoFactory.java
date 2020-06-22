package pl.psi.game.hero.artifacts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArtifactsInfoFactory {

    public final static String HELM_OF_THE_ALABASTER_UNICORN = "Helm of the Alabaster Unicorn";
    public final static String SKULL_HELMET = "Skull Helmet";
    public final static String HELM_OF_CHAOS = "Helm of Chaos";
    public final static String CROWN_OF_THE_SUPREME_MAGI = "Crown of the Supreme Magi";
    public final static String HELLSTORM_HELMET = "Hellstorm Helmet";
    public final static String NECKLACE_OF_DRAGONTEETH = "Necklace of Dragonteeth";
    public final static String CELESTIAL_NECKLACE_OF_BLISS = "Celestial Necklace of Bliss";
    public final static String COLLAR_OF_CONJURING = "Collar of Conjuring";
    public final static String PENDANT_OF_DISPASSION = "Pendant of Dispassion";
    public final static String PENDANT_OF_LIFE = "Pendant of Life";
    public final static String BREASTPLATE_OF_PETRIFIED_WOOD = "Breastplate of Petrified Wood";
    public final static String RIB_CAGE = "Rib Cage";
    public final static String DRAGON_SCALE_ARMOR = "Dragon Scale Armor";
    public final static String ARMOR_OF_WONDER = "Armor of Wonder";
    public final static String TITANS_CUIRAS = "Titan's Cuiras";
    public final static String CAPE_OF_CONJURING = "Cape of Conjuring";
    public final static String DRAGON_WING_TABARD = "Dragon Wing Tabard";
    public final static String SURCOAT_OF_COUNTERPOISE = "Surcoat of Counterpoise";
    public final static String RECANTERS_CLOAK = "Recanter's Cloak";
    public final static String CAPE_OF_VELOCITY = "Cape of Velocity";
    public final static String CENTAURS_AX = "Centaur's Ax";
    public final static String BLACKSHARD_OF_THE_DEAD_KNIGHT = "Blackshard of the Dead Knight";
    public final static String GREATER_GNOLLS_FLAIL = "Greater Gnoll's Flail";
    public final static String OGRES_CLUB_OF_HAVOC = "Ogre's Club of Havoc";
    public final static String TITANS_GLADIUS = "Titan's Gladius";
    public final static String SHIELD_OF_THE_DWARVEN_LORDS = "Shield of the Dwarven Lords";
    public final static String SHIELD_OF_THE_YAWNING_DEAD = "Shield of the Yawning Dead";
    public final static String BUCKLER_OF_THE_GNOLL_KING = "Buckler of the Gnoll King";
    public final static String TARG_OF_THE_RAMPAGING_OGRE = "Targ of the Rampaging Ogre";
    public final static String SENTINELS_SHIELD = "Sentinel's Shield";
    public final static String RING_OF_VITALITY = "Ring of Vitality";
    public final static String RING_OF_LIFE = "Ring of Life";
    public final static String RING_OF_CONJURING = "Ring of Conjuring";
    public final static String RING_OF_THE_WAYFARER = "Ring of the Wayfarer";
    public final static String QUIET_EYE_OF_THE_DRAGON = "Quiet Eye of the Dragon";
    public final static String SANDALS_OF_THE_SAINT = "Sandals of the Saint";
    public final static String DRAGONBONE_GREAVES = "Dragonbone Greaves";
    public final static String BOOTS_OF_POLARITY = "Boots of Polarity";
    public final static String GUARDIANS_BOOTS = "Guardian’s Boots";
    public final static String MAGISTERS_SANDALS = "Magister’s Sandals";

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
        artifactList.add(ArtifactInfo.builder().aCost(1000).aDescription("Renders your units immune to the magic arrow spell").aName(PENDANT_OF_DISPASSION).aLocation(ArtifactInfo.Location.NECK).build());
        artifactList.add(ArtifactInfo.builder().aCost(2500).aDescription("Renders your units immune to the lightning bolt spell").aName(PENDANT_OF_LIFE).aLocation(ArtifactInfo.Location.NECK).build());
        artifactList.add(ArtifactInfo.builder().aCost(1000).aDescription("+1 spell power").aName(BREASTPLATE_OF_PETRIFIED_WOOD).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(3000).aDescription("+2 spell power").aName(RIB_CAGE).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(8000).aDescription("+4 to attack, +4 defence ").aName(DRAGON_SCALE_ARMOR).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+1 to all 4 primary skills").aName(ARMOR_OF_WONDER).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(10000).aDescription("+10 spell power, -2 knowledge").aName(TITANS_CUIRAS).aLocation(ArtifactInfo.Location.TORSO).build());
        artifactList.add(ArtifactInfo.builder().aCost(1500).aDescription("+3 spells duration").aName(CAPE_OF_CONJURING).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+2 spell power, +2 knowledge ").aName(DRAGON_WING_TABARD).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(4000).aDescription("+10% to magic resistance").aName(SURCOAT_OF_COUNTERPOISE).aLocation(ArtifactInfo.Location.SHOULDERS).build());
        artifactList.add(ArtifactInfo.builder().aCost(8000).aDescription("+20% to magic resistance").aName(RECANTERS_CLOAK).aLocation(ArtifactInfo.Location.SHOULDERS).build());
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

    public static List<ArtifactInfo> getAll(){
        return Collections.unmodifiableList(artifactList);
    }

    public static List<ArtifactInfo> getByLocation(ArtifactInfo.Location aLocation){
        return artifactList.stream().filter(s -> s.getLocation() == aLocation).collect(Collectors.toList());
    }

    public static List<ArtifactInfo> getByCost(int aCost){
        return artifactList.stream().filter(s -> s.getCost() == aCost).collect(Collectors.toList());
    }


}
