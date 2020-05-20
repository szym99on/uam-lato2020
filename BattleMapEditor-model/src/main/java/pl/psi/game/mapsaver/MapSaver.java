package pl.psi.game.mapsaver;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.psi.game.BattleMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MapSaver {
    ObjectMapper mapper = new ObjectMapper();

    public MapSaver(){
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    //Save map
    //"Can not find a (Map) Key deserializer for type [simple type, class java.awt.Point]" - i know about this and i need some time for that
    public void saveMap(BattleMap bm) throws IOException {
        String jsonStr = mapper.writeValueAsString(bm);
        BufferedWriter writer = new BufferedWriter(new FileWriter(makePathUsingMapName(bm.getMapName())));
        writer.write(jsonStr);
        writer.close();
    }

    //Load map
    public BattleMap loadMap(String mapName) throws JsonProcessingException {
        String content = "";
        String path = makePathUsingMapName(mapName);

        try {
            content = new String ( Files.readAllBytes( Paths.get(path) ) );
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return mapper.readValue(content,BattleMap.class);
    }

    private String makePathUsingMapName(String mapName){
        return "savedMaps/" + mapName + ".json";
    }
}
