package pl.psi.game.mapmaker;

import lombok.Getter;
import pl.psi.game.BattleMap;
import pl.psi.game.mapsaver.MapSaver;

import java.awt.*;

@Getter
public class MapMaker {
    private BattleMap mapInProduction;
    private MapSaver mapSaver;
    public final static String path = "savedMaps\\";

    //Reset mapInProduction;
    public void newMap(){
        mapInProduction.resetMap();
    }

    //save & load
    //Load existing map from file
    public void loadMap(String mapName){

    }

    //Save map
    public void saveMap(){
    }

    //Set name for map in production
    public void setNameForMapInProduction(String name){
        mapInProduction.setMapName(name);
    }

    //Add Tile for map
    public void addTile(Point p, String fieldType) {
        mapInProduction.addPointToBoard(p,fieldType);
    }

    //Remove Tile from map
    public void removeTile(Point p) {
        mapInProduction.getBoard().remove(p);
    }

}
