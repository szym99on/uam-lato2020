package pl.psi.gui.tiles;


import javafx.scene.image.Image;
import pl.psi.game.fractions.Creature;
import pl.psi.game.move.GuiTileIf;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjectTileFactory extends AbstractTileFactory {

    private final GuiTileIf somethingToRender;

    public ObjectTileFactory(AbstractTileFactory aDecorated, GuiTileIf aSomethingToRender) {
        super(aDecorated);
        somethingToRender = aSomethingToRender;
    }

    @Override
    public MapTile generateTile() {
        MapTile ret;
        if (somethingToRender.isCreature()){
            try {
                ret = new MapTile(new Image(ObjectTileFactory.class.getClassLoader().getResourceAsStream( ((Creature)somethingToRender).getName()+".png" )),"asdf", false);
            } catch (Exception aE) {
                ret = generateStringMapTile();
            }
        }
        else
        {
            ret = generateStringMapTile();
        }

        return ret;
    }

    private MapTile generateStringMapTile() {
        MapTile ret = getDecorated().generateTile();
        ret.setName(somethingToRender.getDisplayName());
        return ret;
    }
}
