package pl.psi.gui.tiles;

public class DefaultTileFactory extends AbstractTileFactory{

    DefaultTileFactory() {
        super(null);
    }

    @Override
    public MapTile generateTile() {

        return new MapTile("");
    }

}
