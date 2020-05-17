package pl.psi.game.artifacts;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.move.GuiTileIf;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter
public class Artifact{

    private final String name;
    private final Location location;

    public enum Location{
        HEAD,
        NECK,
        TORSO,
        SHOULDERS,
        RIGHT_HAND,
        LEFT_HAND,
        FINGERS,
        FEET
    }
    @Builder
    public Artifact(String aName, Location aLocation) {
        name = aName;
        location = aLocation;
    }



}
