package pl.psi.game.hero;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroEcoBattleConverterTest {

    @Test
    @Disabled
    void heroShouldHave100ManaPoints() {
        EconomyHero economyHero = EconomyHero.builder().aKnowledge(10).build();
        HeroEcoBattleConverter heroEcoBattleConverter = new HeroEcoBattleConverter();
        Hero hero = heroEcoBattleConverter.createHero(economyHero);

        assertEquals(100, hero.getManaPoints());
    }
    @Test
    @Disabled
    void heroShouldHaveTheSameCreatureAsEconomyHero() {

    }

    @Test
    @Disabled
    void heroShouldIncreaseCreatureMaxHpTo20() {
        // TO DO: Creatures -> EconomyCreatures
        Creature ecoCreature = Creature.builder().aMaxHp(10).build();
        List<Creature> ecoCreatureList = new ArrayList<>();
        ecoCreatureList.add(ecoCreature);
        EconomyHero economyHero = EconomyHero.builder().aDefence(10).aCreatures(ecoCreatureList).build();
        // !
        HeroEcoBattleConverter heroEcoBattleConverter = new HeroEcoBattleConverter();
        Hero hero =  heroEcoBattleConverter.createHero(economyHero);
        List<Creature> creatureList = hero.getCreatures();
        Creature creature = creatureList.get(0);

        assertEquals(20, creature.getMaxHp());
    }

    @Test
    @Disabled
    void heroShouldIncreaseCreatureAttackTo20() {
        // TO DO: Creatures -> EconomyCreatures
        Creature ecoCreature = Creature.builder().aAttack(Range.closed(10,10)).build();
        List<Creature> ecoCreatureList = new ArrayList<>();
        ecoCreatureList.add(ecoCreature);
        EconomyHero economyHero = EconomyHero.builder().aAttack(10).aCreatures(ecoCreatureList).build();
        // !
        HeroEcoBattleConverter heroEcoBattleConverter = new HeroEcoBattleConverter();
        Hero hero =  heroEcoBattleConverter.createHero(economyHero);
        List<Creature> creatureList = hero.getCreatures();
        Creature creature = creatureList.get(0);

        assertEquals(20, creature.getAttack().upperEndpoint());
        assertEquals(20, creature.getAttack().lowerEndpoint());
    }

    @Test
    @Disabled
    void heroShouldHaveTheSameSpellAsEconomyHero() {

    }

    @Test
    @Disabled
    void heroShouldIncreaseSpellDamage() {

    }



}
