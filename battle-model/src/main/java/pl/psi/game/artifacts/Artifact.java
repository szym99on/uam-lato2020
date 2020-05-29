package pl.psi.game.artifacts;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.move.GuiTileIf;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter
public abstract class Artifact{

    private final String name;
    private final ArtifactInfo.Location location;

    public Artifact(String aName, ArtifactInfo.Location aLocation) {
        name = aName;
        location = aLocation;
    }


    public abstract void apply(Hero aHero);
}
