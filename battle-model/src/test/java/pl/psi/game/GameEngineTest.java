package pl.psi.game;

import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameEngineTest {

    @Test
    void fastestCreatureShouldBeFirst(){
        List<Creature> creatures = new ArrayList<>();
        Creature c1 = Creature.builder().aMoveRange(10).build();
        Creature c2 = Creature.builder().aMoveRange(4).build();
        creatures.add(c1);
        creatures.add(c2);
        List<Creature> creatures2 = new ArrayList<>();
        Creature c2_1 = Creature.builder().aMoveRange(11).build();
        Creature c2_2 = Creature.builder().aMoveRange(7).build();
        creatures2.add(c2_1);
        creatures2.add(c2_2);
        Hero hero1 = new Hero(creatures);
        Hero hero2 = new Hero(creatures2);

        GameEngine gameEngine = new GameEngine(hero1, hero2);

        assertEquals(c2_1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2_2, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2, gameEngine.getActiveCreature().getValue());
    }

    @Test
    void checkNewTurn(){
        List<Creature> creatures = new ArrayList<>();
        Creature c1 = Creature.builder().aMoveRange(10).build();
        Creature c2 = Creature.builder().aMoveRange(4).build();
        creatures.add(c1);
        creatures.add(c2);
        List<Creature> creatures2 = new ArrayList<>();
        Creature c2_1 = Creature.builder().aMoveRange(11).build();
        Creature c2_2 = Creature.builder().aMoveRange(7).build();
        creatures2.add(c2_1);
        creatures2.add(c2_2);
        Hero hero1 = new Hero(creatures);
        Hero hero2 = new Hero(creatures2);

        GameEngine gameEngine = new GameEngine(hero1, hero2);

        assertEquals(c2_1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c1, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2_2, gameEngine.getActiveCreature().getValue());
        gameEngine.pass();
        assertEquals(c2, gameEngine.getActiveCreature().getValue());


        gameEngine.pass();
        assertEquals(c2_1, gameEngine.getActiveCreature().getValue());
    }
}