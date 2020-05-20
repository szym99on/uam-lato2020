package pl.psi.game.mapmaker;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import pl.psi.game.BattleMap;
import pl.psi.game.mapsaver.MapSaver;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.awt.*;
import java.io.IOException;

@Getter
public class MapMaker {
    private BattleMap mapInProduction;
    private MapSaver mapSaver;

    //Reset mapInProduction;
    public void newMap(){
        mapInProduction.resetMap();
    }

    //save & load---------------------------------
    public void loadMapForMapMake(String mapName) throws JsonProcessingException {
        mapInProduction = mapSaver.loadMap(mapName);
    }

    public void saveMap() throws IOException {
        //set last update data
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        mapInProduction.setLastModificationData(dtf.format(now));

        mapSaver.saveMap(mapInProduction);
    }

    //Map edit------------------------------------
    public void setNameForMapInProduction(String name){
        mapInProduction.setMapName(name);
    }

    public void addTile(Point p, String fieldType) {
        mapInProduction.addPointToBoard(p,fieldType);
    }

    public void removeTile(Point p) {
        mapInProduction.getBoard().remove(p);
    }

}
