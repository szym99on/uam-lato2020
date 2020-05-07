package pl.psi.game.spellbook;

import java.util.ArrayList;
import java.util.List;

public class SpellBookInfoFactory {

    private final static String MAGIC_ARROW = "Magic arrow";

    private final static String HASTE = "Haste";
    private final static String AIR_SHIELD = "Air shield";
    private final static String BLOODLUST = "Bloodlust";
    private final static String FIRE_SHIELD = "Fire shield";
    private final static String SLOW = "Slow";
    private final static String STONESKIN = "Stoneskin";
    private final static String WEAKNESS = "Weakness";
    private final static String PRAYER = "Prayer";

    private final static List<SpellInfo> spellList = new ArrayList<>();
    {
        spellList.add(SpellInfo.builder().aCost(1).aDescription("x").aDuration("1/magic power").aManaCost(1).aName(MAGIC_ARROW).aTier(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the speed of the selected unit.").aDuration("1/magic power").aManaCost(6).aName(HASTE).aTier(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the speed of the selected unit.").aDuration("1/magic power").aManaCost(6).aName(HASTE).aTier(2).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the speed of the selected unit.").aDuration("1/magic power").aManaCost(6).aName(HASTE).aTier(3).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Shields a selected unit, reducing the amount of damage received from ranged attacks.").aDuration("1/magic power").aManaCost(12).aName(AIR_SHIELD).aTier(1).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Shields a selected unit, reducing the amount of damage received from ranged attacks.").aDuration("1/magic power").aManaCost(12).aName(AIR_SHIELD).aTier(2).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Shields a selected unit, reducing the amount of damage received from ranged attacks.").aDuration("1/magic power").aManaCost(12).aName(AIR_SHIELD).aTier(3).aType(SpellInfo.Type.AIR).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the hand-to-hand damage inflicted by the selected unit.").aDuration("1/magic power").aManaCost(5).aName(BLOODLUST).aTier(1).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the hand-to-hand damage inflicted by the selected unit.").aDuration("1/magic power").aManaCost(5).aName(BLOODLUST).aTier(2).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the hand-to-hand damage inflicted by the selected unit.").aDuration("1/magic power").aManaCost(5).aName(BLOODLUST).aTier(3).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Cast on a friendly unit, it does not provide any additional protection, but any enemy attacking through the fire shield will suffer damage equal to a portion of what it inflicts.").aDuration("1/magic power").aManaCost(16).aName(FIRE_SHIELD).aTier(1).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Cast on a friendly unit, it does not provide any additional protection, but any enemy attacking through the fire shield will suffer damage equal to a portion of what it inflicts.").aDuration("1/magic power").aManaCost(16).aName(FIRE_SHIELD).aTier(2).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Cast on a friendly unit, it does not provide any additional protection, but any enemy attacking through the fire shield will suffer damage equal to a portion of what it inflicts.").aDuration("1/magic power").aManaCost(16).aName(FIRE_SHIELD).aTier(3).aType(SpellInfo.Type.FIRE).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the speed of the selected enemy unit.").aDuration("1/magic power").aManaCost(6).aName(SLOW).aTier(1).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the speed of the selected enemy unit.").aDuration("1/magic power").aManaCost(6).aName(SLOW).aTier(2).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the speed of the selected enemy unit.").aDuration("1/magic power").aManaCost(6).aName(SLOW).aTier(3).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the selected unit's defense strength.").aDuration("1/magic power").aManaCost(5).aName(SLOW).aTier(1).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the selected unit's defense strength.").aDuration("1/magic power").aManaCost(5).aName(SLOW).aTier(2).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Increases the selected unit's defense strength.").aDuration("1/magic power").aManaCost(5).aName(SLOW).aTier(3).aType(SpellInfo.Type.EARTH).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the selected enemy unit's attack strength.").aDuration("1/magic power").aManaCost(8).aName(WEAKNESS).aTier(1).aType(SpellInfo.Type.WATER).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the selected enemy unit's attack strength.").aDuration("1/magic power").aManaCost(8).aName(WEAKNESS).aTier(2).aType(SpellInfo.Type.WATER).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Reduces the selected enemy unit's attack strength.").aDuration("1/magic power").aManaCost(8).aName(WEAKNESS).aTier(3).aType(SpellInfo.Type.WATER).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Bestows a bonus to the attack strength, defense strength and speed of the selected unit.").aDuration("1/magic power").aManaCost(16).aName(PRAYER).aTier(1).aType(SpellInfo.Type.WATER).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Bestows a bonus to the attack strength, defense strength and speed of the selected unit.").aDuration("1/magic power").aManaCost(16).aName(PRAYER).aTier(2).aType(SpellInfo.Type.WATER).build());
        spellList.add(SpellInfo.builder().aCost(1).aDescription("Bestows a bonus to the attack strength, defense strength and speed of the selected unit.").aDuration("1/magic power").aManaCost(16).aName(PRAYER).aTier(3).aType(SpellInfo.Type.WATER).build());

    }

    public static SpellInfo getSpell(String aName){
        return spellList.stream().filter(s -> s.getName().endsWith(aName)).findAny().orElseThrow();
    }

    public static List<SpellInfo> getSpellsByTier(int aTier){
        return new ArrayList<>();
    }

    public static List<SpellInfo> getSpellsByType(SpellInfo.Type type){
        return new ArrayList<>();
    }
}
