package pl.psi.game.mapmaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
        import pl.psi.game.BattleMap;
import pl.psi.game.mapsaver.MapSaver;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MapMakerTest {

    @Test //not sure
    void loadMapTest() {
        MapMaker mm = new MapMaker();
        mm.saveMap();
        String mapName = mm.getMapInProduction().getMapName();

        //Not sure, map name depending on type of record
        mm.loadMap(mapName + ".txt");
    }

    @Test //Ok
    void addTileTest() {
        MapMaker mm = new MapMaker();
        Point p = new Point(3,4);
        String fieldType = "Lava";

        mm.addTile(p,fieldType);

        Assertions.assertTrue( mm.getMapInProduction().getBoard().containsKey(p) ); //T
    }

    @Test //Ok
    void removeTileTest() {
        MapMaker mm = new MapMaker();
        Point p = new Point(3,4);
        String fieldType = "Lava";

        mm.addTile(p,fieldType);
        mm.removeTile(p);

        Assertions.assertFalse( mm.getMapInProduction().getBoard().containsKey(p) ); //F
    }
}