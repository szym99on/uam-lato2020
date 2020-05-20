package pl.psi.game.skills;

import java.util.ArrayList;
import java.util.List;

public class SkillInfoFactory {


    public final static String ARCHERY = "Archery";
    public final static String OFFENCE = "Offence";
    public final static String ARMOURER = "Armourer";
    public final static String RESISTANCE = "Resistance";
    public final static String LEADERSHIP = "Leadership";
    public final static String LUCK = "Luck";
    public final static String TACTICS = "Tactics";
    public final static String ARTILLERY = "Artillery";
    public final static String BALLISTICS = "Ballistics";
    public final static String FIRST_AID = "First Aid";
    public final static String NECROMANCY = "Necromancy";
    public final static String DIPLOMACY = "Diplomacy";
    public final static String ESTATES = "Estates";
    public final static String LEARNING = "Learning";
    public final static String LOGISTICS = "Logistics";
    public final static String PATH_FINDING = "Path finding";
    public final static String SCOUTING = "Scouting";
    public final static String NAVIGATION = "Navigation";
    public final static String EAGLE_EYE = "Eagle Eye";
    public final static String INTELLIGENCE = "Intelligence";
    public final static String MYSTICISM = "Mysticism";
    public final static String SCHOLAR = "Scholar";
    public final static String SORCERY = "Sorcery";
    public final static String WISDOM = "Wisdom";
    public final static String AIR_MAGIC = "Air Magic";
    public final static String EARTH_MAGIC = "Earth Magic";
    public final static String FIRE_MAGIC = "Fire Magic";
    public final static String WATER_MAGIC = "Water Magic";

    private final static List<SkillInfo> skillList = new ArrayList<>();
    {
        skillList.add(SkillInfo.builder().aName(ARCHERY).aDescription("ranged attack damage +10%").aCost(1000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(OFFENCE).aDescription("hand-to-hand damage +10%").aCost(6000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(ARMOURER).aDescription("damage on troops -5%").aCost(7000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(RESISTANCE).aDescription("+5% chance of spell failure").aCost(1000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(LEADERSHIP).aDescription("+1 morale").aCost(1000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(LUCK).aDescription("+1 luck").aCost(1000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(TACTICS).aDescription("arrange your troops on the battlefield, 1 placement allowed within the first 3 hex coloumns").aCost(5000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(ARTILLERY).aDescription("+50% chance of double damage using ballista's shots").aCost(1000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(BALLISTICS).aDescription("1 shot with 60% chance to hit right wall, + 50% chance for maximum damage,until all seige walls are destroyed, chance to hit arrow towers or drawbridge < 60%").aCost(500).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(FIRST_AID).aDescription("+50 health on top creature in a troop").aCost(2000).aType(SkillInfo.SkillType.COMBAT_SKILL).build());
        skillList.add(SkillInfo.builder().aName(NECROMANCY).aDescription("+10% resurrect of killed enemys (turn into skeletons and join hero's army)").aCost(5000).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(DIPLOMACY).aDescription("+25% of creatures leeing  offer to join, -20% to surrendering cost").aCost(1000).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(ESTATES).aDescription("+125 gold/day").aCost(5000).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(LEARNING).aDescription("+5% earned experience").aCost(500).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(LOGISTICS).aDescription("+10% range").aCost(8000).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(PATH_FINDING).aDescription("no penalty for rough,+25% penaly for sand/snow, +50% for swamp").aCost(2000).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(SCOUTING).aDescription("+1 square view radius").aCost(3000).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(NAVIGATION).aDescription("+50% water movement range").aCost(4000).aType(SkillInfo.SkillType.ADVENTURE_SKILL).build());
        skillList.add(SkillInfo.builder().aName(EAGLE_EYE).aDescription("+40% chance to learn spells(level 2 and below)").aCost(500).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(INTELLIGENCE).aDescription("+ 25% maximum spell points").aCost(9000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(MYSTICISM).aDescription("+2 spell ponts per day to hero's spell regeneration").aCost(5000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(SCHOLAR).aDescription("allows teach and learn spells, hero automatically exchange spells with other heroes during trading sessions (level 2 and below)").aCost(500).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(SORCERY).aDescription("+ 5% effectiveness of cast spells ").aCost(8000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(WISDOM).aDescription("hero can learn spells(level 3 and below)").aCost(10000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(AIR_MAGIC).aDescription("increases the effectiveness of Air Magic spells cast by hero").aCost(5000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(EARTH_MAGIC).aDescription("increases the effectiveness of Earth Magic spells cast by hero").aCost(50000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(FIRE_MAGIC).aDescription("increases the effectiveness of Fire Magic spells cast by hero").aCost(5000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
        skillList.add(SkillInfo.builder().aName(WATER_MAGIC).aDescription("increases the effectiveness of Water Magic spells cast by hero").aCost(5000).aType(SkillInfo.SkillType.MAGIC_SKILL).build());
    }


    public static SkillInfo getSkill(SkillInfo.SkillType skillType) {
        return null;
    }
}
