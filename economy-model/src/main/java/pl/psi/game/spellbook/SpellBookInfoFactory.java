package pl.psi.game.spellbook;

import java.util.ArrayList;
import java.util.List;

public class SpellBookInfoFactory {

    public final static String MAGIC_ARROW = "Magic arrow";

    private final static String LIGHTNING_BOLT = "Lightning bolt";
    private final static String DESTROY_UNDEAD = "Destroy undead";
    private final static String FIRE_BALL = "Fire ball";


    private final static String HASTE = "Haste";
    private final static String AIR_SHIELD = "Air shield";
    private final static String BLOODLUST = "Bloodlust";
    private final static String FIRE_SHIELD = "Fire shield";
    private final static String SLOW = "Slow";
    private final static String STONESKIN = "Stoneskin";
    private final static String WEAKNESS = "Weakness";
    private final static String PRAYER = "Prayer";

    private final static String STORM_ELEMENTAL = "Summon storm elemental";
    private final static String ENERGY_ELEMENTAL = "Summon energy elemental";
    private final static String MAGMA_ELEMENTAL = "Summon magma elemental";
    private final static String ICE_ELEMENTAL = "Summon ice elemental";

    private final static List<SpellInfo> spellList = new ArrayList<>();
    {
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 10) damage.").aDuration("Instant").aManaCost(5).aName(MAGIC_ARROW).aLevel(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 20) damage.").aDuration("Instant").aManaCost(5).aName(MAGIC_ARROW).aLevel(2).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 30) damage.").aDuration("Instant").aManaCost(5).aName(MAGIC_ARROW).aLevel(3).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy creature receives ((Power x 25) + 10) damage.").aDuration("Instant").aManaCost(10).aName(LIGHTNING_BOLT).aLevel(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy creature receives ((Power x 25) + 20) damage.").aDuration("Instant").aManaCost(10).aName(LIGHTNING_BOLT).aLevel(2).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy creature receives ((Power x 25) + 50) damage.").aDuration("Instant").aManaCost(10).aName(LIGHTNING_BOLT).aLevel(3).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("All undead creature troops receive ((Power x 10) +10) damage.").aDuration("Instant").aManaCost(15).aName(DESTROY_UNDEAD).aLevel(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("All undead creature troops receive ((Power x 10) +20) damage.").aDuration("Instant").aManaCost(15).aName(DESTROY_UNDEAD).aLevel(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("All undead creature troops receive ((Power x 10) +50) damage.").aDuration("Instant").aManaCost(15).aName(DESTROY_UNDEAD).aLevel(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 10) damage.").aDuration("Instant").aManaCost(5).aName(MAGIC_ARROW).aLevel(1).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 20) damage.").aDuration("Instant").aManaCost(5).aName(MAGIC_ARROW).aLevel(2).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Target, enemy troop receives ((Power x 10) + 30) damage.").aDuration("Instant").aManaCost(5).aName(MAGIC_ARROW).aLevel(3).aType(SpellInfo.Type.FIRE).build());


        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the speed of the selected unit.").aDuration("1/magic power").aManaCost(6).aName(HASTE).aLevel(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Shields a selected unit, reducing the amount of damage received from ranged attacks.").aDuration("1/magic power").aManaCost(12).aName(AIR_SHIELD).aLevel(3).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the hand-to-hand damage inflicted by the selected unit.").aDuration("1/magic power").aManaCost(5).aName(BLOODLUST).aLevel(1).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Cast on a friendly unit, it does not provide any additional protection, but any enemy attacking through the fire shield will suffer damage equal to a portion of what it inflicts.").aDuration("1/magic power").aManaCost(16).aName(FIRE_SHIELD).aLevel(4).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the speed of the selected enemy unit.").aDuration("1/magic power").aManaCost(6).aName(SLOW).aLevel(1).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the selected unit's defense strength.").aDuration("1/magic power").aManaCost(5).aName(STONESKIN).aLevel(1).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the selected enemy unit's attack strength.").aDuration("1/magic power").aManaCost(8).aName(WEAKNESS).aLevel(2).aType(SpellInfo.Type.WATER).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Bestows a bonus to the attack strength, defense strength and speed of the selected unit.").aDuration("1/magic power").aManaCost(16).aName(PRAYER).aLevel(4).aType(SpellInfo.Type.WATER).build());

        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration("Combat").aManaCost(25).aName(STORM_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration("Combat").aManaCost(25).aName(ENERGY_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration("Combat").aManaCost(25).aName(MAGMA_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Allows you to summon elementals. Once cast, no other elemental types may be summoned.").aDuration("Combat").aManaCost(25).aName(ICE_ELEMENTAL).aLevel(5).aType(SpellInfo.Type.WATER).build());
    }

    public static SpellInfo getSpell(String aName){
        return spellList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }

    public static List<SpellInfo> getSpellsByLevel(int aLevel){
        return new ArrayList<>();
    }

    public static List<SpellInfo> getSpellsByType(SpellInfo.Type type){
        return new ArrayList<>();
    }
}
