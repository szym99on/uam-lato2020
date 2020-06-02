package pl.psi.game.mapsaver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.psi.game.BattleMap;
import pl.psi.game.mapmaker.MapMaker;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

class MapSaverTest {

    @Test
    void saveMapTest() throws IOException {
        BattleMap bmFirst = BattleMap.battleMapBuilder().mapName("test").build();
        MapSaver ms = new MapSaver();

        ms.saveMap(bmFirst);

        File f = new File(MapSaver.getFolderPath() + "test.json");

        Assertions.assertTrue(f.exists()); //T
    }

    @Test
    void loadMapTest() throws IOException {
        BattleMap bmFirst = BattleMap.battleMapBuilder().mapName("test").build();
        MapSaver ms = new MapSaver();

        ms.saveMap(bmFirst);
        BattleMap bmSecond = ms.loadMap("test");

        Assertions.assertEquals(bmFirst,bmSecond);
    }


    @Test
    void deleteMap() throws IOException {
        BattleMap bmFirst = BattleMap.battleMapBuilder().mapName("test").build();
        MapSaver ms = new MapSaver();

        ms.saveMap(bmFirst);
        ms.deleteMap("test");

        File file = new File(MapSaver.folderPath + "test.json");

        Assertions.assertFalse(file.exists()); //F
    }
}