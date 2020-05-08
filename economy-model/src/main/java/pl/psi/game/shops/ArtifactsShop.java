package pl.psi.game.shops;

import pl.psi.game.spellbook.SpellInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArtifactsShop {

    List<ArtifactInfo> random(int aTier){
        return Arrays.asList(ArtifactInfo.ArtifactInfoEnum.values()).stream().filter(s -> s.getTier==aTier).collect(Collectors.toList());
    }
}


