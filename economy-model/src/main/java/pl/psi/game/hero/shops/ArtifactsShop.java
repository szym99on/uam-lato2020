package pl.psi.game.hero.shops;

import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArtifactsShop extends AbstractShop {

    private List<ArtifactInfo> artifactsAvailableToBuy;

   public ArtifactsShop(){}


    public ArtifactsShop(String name, String description, List<ArtifactInfo> artifactsAvailableToBuy) {
        super(name, description);
        this.artifactsAvailableToBuy = artifactsAvailableToBuy;
    }

    public List<ArtifactInfo> generateArtifactsAvailableToBuy() {

        List<ArtifactInfo> artifacts = ArtifactsInfoFactory.getAll().stream().collect(Collectors.toList());
        List<ArtifactInfo> artifactAvailableToBuy = new ArrayList<>();

        Random ran = new Random();
        int artifactCount = ran.nextInt(10) + 2;
        for (int i = 0; i < artifactCount; i++) {
            int randomIndex = ran.nextInt(artifacts.size());
            ArtifactInfo randomArtifact = artifacts.get(randomIndex);
            artifacts.remove(randomIndex);
            artifactAvailableToBuy.add(randomArtifact);
        }

       return artifactAvailableToBuy;
    }



}


