package pl.psi.game;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @Test
    void fastestCreatureShouldBeFirst(){
        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        Board.getBoard();
        List<Creature> creatures = new ArrayList<>();
        Creature c1 = Creature.builder().aMoveRange(10).aAmount(1).build();
        Creature c2 = Creature.builder().aMoveRange(4).aAmount(1).build();
        creatures.add(c1);
        creatures.add(c2);
        List<Creature> creatures2 = new ArrayList<>();
        Creature c2_1 = Creature.builder().aMoveRange(11).aAmount(1).build();
        Creature c2_2 = Creature.builder().aMoveRange(7).aAmount(1).build();
        creatures2.add(c2_1);
        creatures2.add(c2_2);
        Hero hero1 = Hero.builder().aCreatures(creatures).build();
        Hero hero2 = Hero.builder().aCreatures(creatures2).build();

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
        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        List<Creature> creatures = new ArrayList<>();
        Creature c1 = Creature.builder().aMoveRange(10).aAmount(1).build();
        Creature c2 = Creature.builder().aMoveRange(4).build();
        creatures.add(c1);
        creatures.add(c2);
        board.putCreature(1,1,c1);
        List<Creature> creatures2 = new ArrayList<>();
        Creature c2_1 = Creature.builder().aMoveRange(11).aAmount(1).build();
        Creature c2_2 = Creature.builder().aMoveRange(7).aAmount(1).build();
        creatures2.add(c2_1);
        creatures2.add(c2_2);
        Hero hero1 = Hero.builder().aCreatures(creatures).build();
        Hero hero2 = Hero.builder().aCreatures(creatures2).build();

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

    @Test
    void checkResetCounterAttack(){
        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        List<Creature> creatures = new ArrayList<>();
        Creature attacker1 = Creature.builder().aMaxHp(10).aAttack(Range.closed(1,1)).aAmount(1).build();
        Creature attacker2 = Creature.builder().aMaxHp(10).aAttack(Range.closed(1,1)).aAmount(1).build();
        creatures.add(attacker1);
        creatures.add(attacker2);
        List<Creature> creatures2 = new ArrayList<>();
        Creature defender = Creature.builder().aMaxHp(100).aAttack(Range.closed(1,1)).aAmount(1).build();
        creatures2.add(defender);
        Hero hero1 = Hero.builder().aCreatures(creatures).build();
        Hero hero2 = Hero.builder().aCreatures(creatures2).build();
        GameEngine gameEngine = new GameEngine(hero1, hero2);

        attacker1.attack(defender);
        attacker2.attack(defender);
        //new turn
        gameEngine.pass();
        gameEngine.pass();
        gameEngine.pass();
        attacker1.attack(defender);

        assertEquals(97, defender.getCurrentHp());
        assertEquals(10, attacker2.getCurrentHp());
        assertEquals(8, attacker1.getCurrentHp());
    }


    @Test
    @Disabled
    void isPointInPath() {
        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        List<Creature> creatures = new ArrayList<>();
        Creature attacker1 = Creature.builder().aMaxHp(10).aAttack(Range.closed(1,1)).aAmount(1).build();
        creatures.add(attacker1);
        List<Creature> creatures2 = new ArrayList<>();
        Hero hero1 = Hero.builder().aCreatures(creatures).build();
        Hero hero2 = Hero.builder().aCreatures(creatures2).build();
        GameEngine gameEngine = new GameEngine(hero1, hero2);
        board.putCreature(1,1,attacker1);
        gameEngine.getMovePath(1, 5);

        assertTrue(gameEngine.isPointInPath(1,2));
        assertTrue(gameEngine.isPointInPath(1,3));
        assertTrue(gameEngine.isPointInPath(1,4));
        assertTrue(gameEngine.isPointInPath(1,5));
    }
}
