package pl.psi.game.hero.shops;

import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;

import java.util.List;

public class ArtifactsShop extends AbstractShop {

    private List<ArtifactInfo> artifactsAvailableToBuy;






   public ArtifactsShop(){}


    public ArtifactsShop(String name, String description, List<ArtifactInfo> artifactsAvailableToBuy) {
        super(name, description);
        this.artifactsAvailableToBuy = artifactsAvailableToBuy;
    }

    List<ArtifactInfo> generateArtifactsAvailableToBuy() {

        List<ArtifactInfo> artifacts = ArtifactsInfoFactory.getAll();
        System.out.println("All artifacts available to buy: ");
        artifacts.forEach(System.out::println);

       return artifacts;
    }



}


