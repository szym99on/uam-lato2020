package pl.psi.game.hero.shops;

import lombok.Getter;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.CreatureStack;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreaturesShop extends AbstractShop {

    @Getter
    private List<CreatureStack> creaturesAvailableToBuy;
    private FractionsInfoAbstractFactory factory;

    public CreaturesShop() {
    }

    public CreaturesShop(FractionsInfoAbstractFactory aFraction) {
         factory = aFraction;
    }

    public CreaturesShop(String name, String description, List<CreatureStack> creaturesAvailableToBuy) {
        super(name, description);
        this.creaturesAvailableToBuy = creaturesAvailableToBuy;
    }

    @Override
    public void generateItemsAvailableToBuy() {
        FractionsInfoAbstractFactory creaturesFactory = factory;
//        HeroInfo heroInfo = new HeroInfo("name", creaturesFactory
//                , HeroInfo.FractionClass.ALCHEMIST);
//        EconomyHero hero = EconomyHero.builder().build();
        //FractionsInfoAbstractFactory.Fractions fraction = hero.getFraction();

        List<CreatureInfo> creatures = creaturesFactory.getAllCreatures();
        List<CreatureStack> creaturesAvailableToBuy = new ArrayList<>();

        for (CreatureInfo creature : creatures) {
            Random ran = new Random();
            int creaturesCount = ran.nextInt(3) + 2;
            CreatureStack creatureStack = new CreatureStack(creature, creaturesCount);
            creaturesAvailableToBuy.add(creatureStack);
        }
        this.creaturesAvailableToBuy = creaturesAvailableToBuy;
    }
}
