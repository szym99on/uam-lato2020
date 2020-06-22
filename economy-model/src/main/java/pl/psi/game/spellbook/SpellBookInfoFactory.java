package pl.psi.game.spellbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SpellBookInfoFactory {

    public final static String MAGIC_ARROW = "Magic arrow";
    public final static String LIGHTNING_BOLT = "Lightning bolt";
    public final static String DESTROY_UNDEAD = "Destroy undead";
    public final static String FIRE_BALL = "Fire ball";
    public final static String METEOR_SHOWER = "Meteor shower";
    public final static String IMPLOSION = "Implosion";

    public final static String HASTE = "Haste";
    public final static String AIR_SHIELD = "Air shield";
    public final static String BLOODLUST = "Bloodlust";
    public final static String FIRE_SHIELD = "Fire shield";
    public final static String SLOW = "Slow";
    public final static String STONESKIN = "Stoneskin";
    public final static String WEAKNESS = "Weakness";
    public final static String PRAYER = "Prayer";

    public final static String STORM_ELEMENTAL = "Summon storm elemental";
    public final static String ENERGY_ELEMENTAL = "Summon energy elemental";
    public final static String MAGMA_ELEMENTAL = "Summon magma elemental";
    public final static String ICE_ELEMENTAL = "Summon ice elemental";

    private final static List<SpellInfo> spellList = new ArrayList<>();
    {
        //1-2
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 10) damage.").aDuration(0).aManaCost(5).aName(MAGIC_ARROW).aLevel(1).aType(SpellInfo.Type.ALL).build());
//        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 10) damage.").aDuration(0).aManaCost(5).aName(MAGIC_ARROW).aLevel(1).aType(SpellInfo.Type.FIRE).build());
//        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 10) damage.").aDuration(0).aManaCost(5).aName(MAGIC_ARROW).aLevel(1).aType(SpellInfo.Type.AIR).build());
//        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 10) damage.").aDuration(0).aManaCost(5).aName(MAGIC_ARROW).aLevel(1).aType(SpellInfo.Type.WATER).build());
//        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 10) damage.").aDuration(0).aManaCost(5).aName(MAGIC_ARROW).aLevel(1).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 25) + 10) damage.").aDuration(0).aManaCost(10).aName(LIGHTNING_BOLT).aLevel(2).aType(SpellInfo.Type.AIR).build());
        //3-4
        spellList.add(SpellInfo.builder().aCost(1).aDescription("All undead creature troops receive ((Power x 10) + 10) damage.").aDuration(0).aManaCost(15).aName(DESTROY_UNDEAD).aLevel(3).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Troops in target hex and adjacent hexes take ((Power x 10) + 15) damage.").aDuration(0).aManaCost(15).aName(FIRE_BALL).aLevel(3).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Troops in target hex and adjacent hexes take ((Power x 25) + 25) damage.").aDuration(0).aManaCost(16).aName(METEOR_SHOWER).aLevel(4).aType(SpellInfo.Type.EARTH).build());
        //5
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 75) + 100) damage.").aDuration(0).aManaCost(30).aName(IMPLOSION).aLevel(5).aType(SpellInfo.Type.EARTH).build());


        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the speed of the selected unit.").aDuration(1).aManaCost(6).aName(HASTE).aLevel(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Shields a selected unit, reducing the amount of damage received from ranged attacks.").aDuration(1).aManaCost(12).aName(AIR_SHIELD).aLevel(3).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the hand-to-hand damage inflicted by the selected unit.").aDuration(1).aManaCost(5).aName(BLOODLUST).aLevel(1).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Cast on a friendly unit, it does not provide any additional protection, but any enemy attacking through the fire shield will suffer damage equal to a portion of what it inflicts.").aDuration(1).aManaCost(16).aName(FIRE_SHIELD).aLevel(4).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the speed of the selected enemy unit.").aDuration(1).aManaCost(6).aName(SLOW).aLevel(1).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the selected unit's defense strength.").aDuration(1).aManaCost(5).aName(STONESKIN).aLevel(1).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the selected enemy unit's attack strength.").aDuration(1).aManaCost(8).aName(WEAKNESS).aLevel(2).aType(SpellInfo.Type.WATER).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Bestows a bonus to the attack strength, defense strength and speed of the selected unit.").aDuration(1).aManaCost(16).aName(PRAYER).aLevel(4).aType(SpellInfo.Type.WATER).build());

        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration(-1).aManaCost(25).aName(STORM_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration(-1).aManaCost(25).aName(ENERGY_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration(-1).aManaCost(25).aName(MAGMA_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration(-1).aManaCost(25).aName(ICE_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.WATER).build());
    }

    public static SpellInfo getSpell(String aName){
        return spellList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }

    public static List<SpellInfo> getListAllSpells(){
        return spellList;
    }

    public static List<SpellInfo> getAll(){return Collections.unmodifiableList(spellList);}

    public static List<SpellInfo> getSpellsByLevel(int aLevel){

        return spellList.stream().filter(spell -> spell.getLevel() == aLevel).collect(Collectors.toList());

    }

    public static List<SpellInfo> getSpellsByType(SpellInfo.Type type){
        return spellList.stream().filter(s -> s.getType() == type).collect(Collectors.toList());
    }

    public static int getHighestTier(){
        return spellList.stream().map(SpellInfo::getLevel).max(Integer::compare).orElseThrow();
    }

}
