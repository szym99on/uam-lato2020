package pl.psi.game.fractions;

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
				creature.setMagicResistance(new MagicResistance(40, MagicResistance.ImmunityType.NONE));
				break;
			case "Gold Dragon":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.FOURTH_TIER_AND_BELOW));
				break;
			case "Storm Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.EARTH_SPELLS));
				break;
			case "Ice Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.ICE_SPELLS));
				break;
			case "Energy Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.FIRE_SPELLS));
				break;
			case "Magma Elemental":
				creature.setMagicResistance(new MagicResistance(0, MagicResistance.ImmunityType.AIR_SPELLS));
				break;
		}
	}

	private Creature addSpecialAttack(Creature creature) {
		switch (creature.getName()) {
			case "Storm Elemental":
				creature.setDealDamageCountStrategy(new DealDamageCounterDoubleToEarthElementalStrategy());
				break;
			case "Ice Elemental":
				creature.setDealDamageCountStrategy(new DealDamageCounterDoubleToFireElementalStrategy());
				break;
			case "Energy Elemental":
				creature.setDealDamageCountStrategy(new DealDamageCounterDoubleToWaterElementalStrategy());
				break;
			case "Magma Elemental":
				creature.setDealDamageCountStrategy(new DealDamageCounterDoubleToAirElementalStrategy());
				break;
			case "Vampire Lord":
				creature.setDealDamageCountStrategy(new DealDamageCounterWithHealStrategy());
				break;
			case "Dread Knight":
				creature.setDealDamageCountStrategy(new DealDamageCounterDoubleWith20PercentChanceStrategy());
				break;
			case "Grand Elf":
			case "Wolf Raider":
				//PW It's not working like that. You not multiply damage. You have to really attack 2 times.
				// UseCase:
				// creature with 10 amount in stack attacks defender
				// deal 10*(attack-defence) damage
				// defender counterattack and kill 3 unit in stack
				// attacker attack second time but with 7 in stack so deal 7*(attack-defence) damage
				creature.setDealDamageCountStrategy(new DealDamageCounterDoubleStrategy());
				break;
			case "Ancient Behemoth":
				creature.setDealDamageCountStrategy(new DealDamageCounterWithIgnore80PercentArmorStrategy());
				break;
		}
		return creature;
	}
}

