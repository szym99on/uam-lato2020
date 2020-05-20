package pl.psi.game.mapsaver;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FolderManager {
    private File f = new File("savedMaps");
    File[] mapsFiles = f.listFiles();

    public FolderManager(){
        mapListUpdate();
    }

    public void mapListUpdate(){
        mapsFiles = f.listFiles();
    }

    //I do not know if this boolean ascending makes sense, what should i do? leave this / overload this method / create a separate method
    public void sortListByName(boolean ascending){
        if (ascending)
            Arrays.sort(mapsFiles);
        else
            Arrays.sort(mapsFiles, Collections.reverseOrder());
    }

    public void sortListByModificationDate(boolean ascending){
        if (ascending)
            Arrays.sort(mapsFiles, Comparator.comparingLong(File::lastModified));
        else
            Arrays.sort(mapsFiles, Comparator.comparingLong(File::lastModified).reversed());
    }
}
