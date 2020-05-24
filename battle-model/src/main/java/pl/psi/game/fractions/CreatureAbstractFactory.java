package pl.psi.game.fractions;

public class CreatureAbstractFactory {
	
	public Creature getCreature(CreatureInfo creatureInfo) {
		Creature creature = Creature.builder().aMaxHp(creatureInfo.getMaxHp()).aAttack(creatureInfo.getAttack()).aName(creatureInfo.getName()).aArmor(creatureInfo.getArmor()).aMoveRange(creatureInfo.getMoveRange()).build();
		addSpecialAttack(creature);
		return creature;
	}
	
	private Creature addSpecialAttack(Creature creature) {
		switch (creature.getName()) {
			case "Storm Elemental":
				creature.setDealDamageCountStrategy(new DealDamageCounterDoubleToEarthElementalStrategy());
				break;
			case "Ice elemental":
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

