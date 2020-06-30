package pl.psi.game.hero.artifact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.hero.artifacts.ArtifactInfo.Location.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;

public class ArtifactInfoTest {
    @BeforeAll
    static void initializeFactories(){
        new ArtifactsInfoFactory();
    }
    //list used for getAll() method test
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
    @Test
    void shouldFindAppropriateArtifactByName(){
        assertEquals(HELM_OF_THE_ALABASTER_UNICORN,getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getName());
        assertEquals(1000,getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getCost());
        assertEquals(HEAD, getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getLocation());

        assertEquals(SKULL_HELMET,getArtifact(SKULL_HELMET).getName());
        assertEquals(3000,getArtifact(SKULL_HELMET).getCost());
        assertEquals(HEAD, getArtifact(SKULL_HELMET).getLocation());

        assertEquals(BLACKSHARD_OF_THE_DEAD_KNIGHT,getArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT).getName());
        assertEquals(3000,getArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT).getCost());
        assertEquals(RIGHT_HAND, getArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT).getLocation());

        assertEquals(RING_OF_VITALITY,getArtifact(RING_OF_VITALITY).getName());
        assertEquals(5000,getArtifact(RING_OF_VITALITY).getCost());
        assertEquals(FINGERS, getArtifact(RING_OF_VITALITY).getLocation());

        assertEquals(GUARDIANS_BOOTS,getArtifact(GUARDIANS_BOOTS).getName());
        assertEquals(3000,getArtifact(GUARDIANS_BOOTS).getCost());
        assertEquals(FEET, getArtifact(GUARDIANS_BOOTS).getLocation());
    }

    @Test
    void shoulReturnListOfAllArtifacts(){
        List<ArtifactInfo> artifactInfoList = getAll();

        assertEquals(40, artifactInfoList.size());
        for(int i = 0; i < 40; i++ ){
            assertEquals(artifactList.get(i).getName(), artifactInfoList.get(i).getName());
        }
    }

    @Test
    void shouldFindAppropriateArtifactsByLocation(){
        assertTrue(getByLocation(HEAD).stream().allMatch(s -> s.getLocation() == HEAD));
        assertTrue(getByLocation(NECK).stream().allMatch(s -> s.getLocation() == NECK));
        assertTrue(getByLocation(TORSO).stream().allMatch(s -> s.getLocation() == TORSO));
        assertTrue(getByLocation(SHOULDERS).stream().allMatch(s -> s.getLocation() == SHOULDERS));
        assertTrue(getByLocation(RIGHT_HAND).stream().allMatch(s -> s.getLocation() == RIGHT_HAND));
        assertTrue(getByLocation(LEFT_HAND).stream().allMatch(s -> s.getLocation() == LEFT_HAND));
        assertTrue(getByLocation(FEET).stream().allMatch(s -> s.getLocation() == FEET));
        assertTrue(getByLocation(FINGERS).stream().allMatch(s -> s.getLocation() == FINGERS));


        assertFalse(getByLocation(HEAD).stream().allMatch(s -> s.getLocation() == NECK));
        assertFalse(getByLocation(NECK).stream().allMatch(s -> s.getLocation() == TORSO));
        assertFalse(getByLocation(TORSO).stream().allMatch(s -> s.getLocation() == SHOULDERS));
        assertFalse(getByLocation(SHOULDERS).stream().allMatch(s -> s.getLocation() == RIGHT_HAND));
        assertFalse(getByLocation(RIGHT_HAND).stream().allMatch(s -> s.getLocation() == FINGERS));
        assertFalse(getByLocation(LEFT_HAND).stream().allMatch(s -> s.getLocation() == FEET));
        assertFalse(getByLocation(FEET).stream().allMatch(s -> s.getLocation() == NECK));
        assertFalse(getByLocation(FINGERS).stream().allMatch(s -> s.getLocation() == SHOULDERS));

    }

    @Test
    void shouldFindAppropriateArtifactsByCost(){
        assertEquals(1, getByCost(500).size());
        assertTrue(getByCost(500).stream().allMatch(s -> s.getCost() == 500));

        assertEquals(4, getByCost(1000).size());
        assertTrue(getByCost(1000).stream().allMatch(s -> s.getCost() == 1000));

        assertEquals(1, getByCost(1500).size());
        assertTrue(getByCost(1500).stream().allMatch(s -> s.getCost() == 1500));

        assertEquals(4, getByCost(2000).size());
        assertTrue(getByCost(2000).stream().allMatch(s -> s.getCost() == 2000));

        assertEquals(1, getByCost(2500).size());
        assertTrue(getByCost(2500).stream().allMatch(s -> s.getCost() == 2500));

        assertEquals(6, getByCost(3000).size());
        assertTrue(getByCost(3000).stream().allMatch(s -> s.getCost() == 3000));

        assertEquals(6, getByCost(4000).size());
        assertTrue(getByCost(4000).stream().allMatch(s -> s.getCost() == 4000));

        assertEquals(5, getByCost(5000).size());
        assertTrue(getByCost(5000).stream().allMatch(s -> s.getCost() == 5000));

        assertEquals(3, getByCost(6000).size());
        assertTrue(getByCost(6000).stream().allMatch(s -> s.getCost() == 6000));

        assertEquals(1, getByCost(7000).size());
        assertTrue(getByCost(7000).stream().allMatch(s -> s.getCost() == 7000));

        assertEquals(3, getByCost(8000).size());
        assertTrue(getByCost(8000).stream().allMatch(s -> s.getCost() == 8000));

        assertEquals(4, getByCost(10000).size());
        assertTrue(getByCost(10000).stream().allMatch(s -> s.getCost() == 10000));

        assertEquals(1, getByCost(12000).size());
        assertTrue(getByCost(12000).stream().allMatch(s -> s.getCost() == 12000));

    }

}
