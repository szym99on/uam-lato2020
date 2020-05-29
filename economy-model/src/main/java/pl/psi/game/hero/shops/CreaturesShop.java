package pl.psi.game.hero.shops;

import pl.psi.game.fractions.CreatureInfo;

import java.util.List;

public class CreaturesShop extends AbstractShop {



    private List<CreatureInfo> creaturesAvailableToBuy;


    List<CreatureInfo> generateCreaturesAvailableToBuy() {
        return null;
    }

    public CreaturesShop(){};

    public CreaturesShop(String name, String description, List<CreatureInfo> creaturesAvailableToBuy) {
        super(name, description);
        this.creaturesAvailableToBuy = creaturesAvailableToBuy;
    }

}
