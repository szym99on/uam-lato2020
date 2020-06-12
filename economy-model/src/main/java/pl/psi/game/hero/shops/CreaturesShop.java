package pl.psi.game.hero.shops;

import lombok.Getter;
import org.checkerframework.checker.units.qual.C;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.CreatureStack;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.skills.SkillInfo;

import java.util.*;

public class CreaturesShop extends AbstractShop {

    public List<CreatureInfo> getCreaturesAvailableToBuy() {
        return creaturesAvailableToBuy;
    }

    //@Getter
    private List<CreatureInfo> creaturesAvailableToBuy;


    public CreaturesShop(){}

    public CreaturesShop(String name, String description, List<CreatureInfo> creaturesAvailableToBuy) {
        super(name, description);
        this.creaturesAvailableToBuy = creaturesAvailableToBuy;
    }
    @Override
    public void generateItemsAvailableToBuy() {
        EconomyHero hero = EconomyHero.builder().build();
//        FractionsInfoAbstractFactory.Fraction fraction = hero.getFraction();
//        FractionsInfoAbstractFactory creaturesFactory = FractionsInfoAbstractFactory.getFactory(fraction);
        List<CreatureInfo> creaturesAvailableToBuy = new ArrayList<>();
        List<CreatureStack> creatureStacks = new ArrayList<>();

        for (CreatureInfo creature:creaturesAvailableToBuy) {
            Random ran = new Random();
            int creaturesCount = ran.nextInt(3) + 2;
            CreatureStack creatureStack = new CreatureStack(creature,creaturesCount);
            creatureStacks.add(creatureStack);
        }
        this.creaturesAvailableToBuy = creaturesAvailableToBuy;

    }

}
