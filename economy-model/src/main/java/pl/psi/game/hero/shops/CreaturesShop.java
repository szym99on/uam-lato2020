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

    public CreaturesShop(){}

    public CreaturesShop(FractionsInfoAbstractFactory aFactory) {
        factory = aFactory;
        creaturesAvailableToBuy = new ArrayList<>();
    }

    public CreaturesShop(String name, String description, List<CreatureStack> creaturesAvailableToBuy) {
        super(name, description);
        this.creaturesAvailableToBuy = creaturesAvailableToBuy;
    }

    @Override
    public void generateItemsAvailableToBuy() {
        FractionsInfoAbstractFactory creaturesFactory = factory;


        List<CreatureStack> creaturesAvailableToBuy = new ArrayList<>();

        for (int i = 1; i<= 7; i++) {

            CreatureInfo creature = creaturesFactory.getCreatureByTier(i);
            int creaturesCount = (7 - i) * (7 - i) + 1;
            CreatureStack creatureStack = new CreatureStack(creature, creaturesCount);
            creaturesAvailableToBuy.add(creatureStack);

        }
        addCreaturesToCreaturesAvailableToBuy(this.creaturesAvailableToBuy, creaturesAvailableToBuy);

    }
    private void addCreaturesToCreaturesAvailableToBuy(List<CreatureStack> creaturesAvailableToBuy, List<CreatureStack> creaturesToAdd){
        boolean wasntAdd;
        for(CreatureStack c1: creaturesToAdd){
            wasntAdd = true;
            for(CreatureStack c2: creaturesAvailableToBuy){
                if(c1.getCreatureInfo().equals(c2.getCreatureInfo())){
                    c2.setCreaturesCount(c2.getCreaturesCount()+c1.getCreaturesCount());
                    wasntAdd = false;
                }
            }
            if(wasntAdd)
                creaturesAvailableToBuy.add(c1);


        }


    }

}
