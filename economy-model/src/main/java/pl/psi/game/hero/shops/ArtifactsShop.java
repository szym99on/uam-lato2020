package pl.psi.game.hero.shops;

import pl.psi.game.hero.artifacts.ArtifactInfo;

import java.util.List;

public class ArtifactsShop extends AbstractShop {

    private List<ArtifactInfo> artifactsAvailableToBuy;




    List<ArtifactInfo> generateArtifactsAvailableToBuy() {
        return null;
    }


   public ArtifactsShop(){}


    public ArtifactsShop(String name, String description, List<ArtifactInfo> artifactsAvailableToBuy) {
        super(name, description);
        this.artifactsAvailableToBuy = artifactsAvailableToBuy;
    }

}


