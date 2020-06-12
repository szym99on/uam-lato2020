package pl.psi.game.hero.shops;

import lombok.Getter;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArtifactsShop extends AbstractShop {

    @Getter
    private List<ArtifactInfo> artifactsAvailableToBuy;

   public ArtifactsShop(){}


    public ArtifactsShop(String name, String description, List<ArtifactInfo> artifactsAvailableToBuy) {
        super(name, description);
        this.artifactsAvailableToBuy = artifactsAvailableToBuy;
    }

    @Override
    public void generateItemsAvailableToBuy() {

        List<ArtifactInfo> artifacts = new ArrayList<>(ArtifactsInfoFactory.getAll());
        List<ArtifactInfo> artifactsAvailableToBuy = new ArrayList<>();

        Random ran = new Random();
        int artifactCount = ran.nextInt(10);
        for (int i = 0; i < artifactCount; i++) {
            int randomIndex = ran.nextInt(artifacts.size());
            ArtifactInfo randomArtifact = artifacts.get(randomIndex);
            artifacts.remove(randomIndex);
            artifactsAvailableToBuy.add(randomArtifact);
        }

       this.artifactsAvailableToBuy = artifactsAvailableToBuy;
    }



}


