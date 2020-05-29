package pl.psi.game.shops;

import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArtifactsShop {

    List<ArtifactInfo> random(int aTier){
        return ArtifactsInfoFactory.getAll().stream().collect(Collectors.toList());
    }
}


