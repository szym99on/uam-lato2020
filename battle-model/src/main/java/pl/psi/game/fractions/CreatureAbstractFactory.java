package pl.psi.game.fractions;

import java.util.ArrayList;

public class CreatureAbstractFactory {
	
	public Creature getCreature(CreatureInfo creatureInfo) {
		Creature creature = Creature.builder().aMaxHp(creatureInfo.getMaxHp()).aAttack(creatureInfo.getAttack()).aName(creatureInfo.getName()).aArmor(creatureInfo.getArmor()).aMoveRange(creatureInfo.getMoveRange()).aCanFly(creatureInfo.isCanFly()).build();
		addSpecialAttack(creature);
		addMagicResistance(creature);
		return creature;
	}

	private void addMagicResistance(Creature creature) {
		switch (creature.getName()) {
			case "Battle Dwarf":
				creature.setMagicResistance(new MagicResistance(40, MagicResistance.ImmunityType.NONE, new ArrayList<>()));
				break;
			case "Gold Dragon":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.FOURTH_TIER_AND_BELOW, new ArrayList<>()));
				break;
			case "Storm Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.EARTH_SPELLS, new ArrayList<>()));
				break;
			case "Ice Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.ICE_SPELLS, new ArrayList<>()));
				break;
			case "Energy Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.FIRE_SPELLS, new ArrayList<>()));
				break;
			case "Magma Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.AIR_SPELLS, new ArrayList<>()));
				break;
		}
	}

	private Creature addSpecialAttack(Creature creature) {
		switch (creature.getName()) {
			case "Storm Elemental":
				creature.setDealDamageCounterStrategy(new DealDamageCounterDoubleToEarthElementalStrategy());
				break;
			case "Ice Elemental":
				creature.setDealDamageCounterStrategy(new DealDamageCounterDoubleToFireElementalStrategy());
				break;
			case "Energy Elemental":
				creature.setDealDamageCounterStrategy(new DealDamageCounterDoubleToWaterElementalStrategy());
				break;
			case "Magma Elemental":
				creature.setDealDamageCounterStrategy(new DealDamageCounterDoubleToAirElementalStrategy());
				break;
			case "Vampire Lord":
				creature.setDealDamageCounterStrategy(new DealDamageCounterWithHealStrategy());
				creature.setAttackStrategyIf(new AttackWithCounterBlockedStrategy(creature));
				break;
			case "Dread Knight":
				creature.setDealDamageCounterStrategy(new DealDamageCounterDoubleWith20PercentChanceStrategy());
				break;
			case "Grand Elf":
			case "Wolf Raider":
				creature.setAttackStrategyIf(new DoubleAttackStrategy(creature));
				break;
			case "Ancient Behemoth":
				creature.setDealDamageCounterStrategy(new DealDamageCounterWithIgnore80PercentArmorStrategy());
				break;
		}
		return creature;
	}
}

