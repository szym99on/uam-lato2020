package pl.psi.gui.tiles;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.psi.game.GameEngine;
import pl.psi.game.spellbook.Spell;
import pl.psi.gui.SpellBookGui;
import java.awt.*;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaException;
//import javafx.scene.media.MediaPlayer;


public class SpellCastPossibleTileFactoryDecorator extends AbstractTileFactory {

    private Point location;
    private GameEngine engine;
    private Spell selectedSpell;
    private String spellSfx;

    public SpellCastPossibleTileFactoryDecorator(AbstractTileFactory aDecorated, int aX, int aY, GameEngine aEngine) {
        super(aDecorated);
        engine = aEngine;
        location = new Point(aX, aY);

    }


    @Override
    public MapTile generateTile() {
        MapTile tile = getDecorated().generateTile();
        tile.setBackground(Color.LIGHTBLUE);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->
                {
                    engine.castSpell(location.x, location.y, SpellBookGui.selectedSpell);
                    engine.invokeSpellCastedEvent();
//                    try {
//                        spellSfx = "battle-gui/src/main/resources/spellSfx/" + SpellBookGui.selectedSpell.getSpellName() + ".wav";
//                        Media sound = new Media(new File(spellSfx).toURI().toString());
//                        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//                        mediaPlayer.play();
//                    } catch (MediaException mediaException) {
//                        System.out.println("No sound for this spell: " + SpellBookGui.selectedSpell.getSpellName());
//                    }
                }
        );
        return tile;
    }
}
