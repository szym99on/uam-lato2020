package pl.psi.game.mapmaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashMap;


class MapMakerTest {
    @Test
    void addTileTest() {
        MapMaker mm = new MapMaker();
        Point p = new Point(3,4);
        String fieldType = "Lava";

        mm.addTile(p,fieldType);

        Assertions.assertTrue( mm.getMapInProduction().getBoard().containsKey(p) ); //T
    }

    @Test
    void removeTileTest() {
        MapMaker mm = new MapMaker();
        Point p = new Point(3,4);
        String fieldType = "Lava";

        mm.addTile(p,fieldType);
        mm.removeTile(p);

        Assertions.assertFalse( mm.getMapInProduction().getBoard().containsKey(p) ); //F
    }

    @Test
    void rawTest(){
        HashMap<Integer,String> board = new HashMap<>();
        board.put(1,"Ala");

        Assertions.assertTrue( board.containsKey(1) );
    }
}