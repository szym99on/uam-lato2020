package pl.psi.game.hero.shops;

import lombok.Getter;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SpellShop extends AbstractShop{

    @Getter
    private List<SpellInfo> spellsAvailableToBuy;

    public SpellShop(){

    };

    public SpellShop(String name, String description, List<SpellInfo> spellsAvailableToBuy) {
        super(name, description);
        this.spellsAvailableToBuy = spellsAvailableToBuy;
    }

    @Override
    public void generateItemsAvailableToBuy() {


        List<SpellInfo> spellsAvailableToBuy = new ArrayList<>();
        int highestTier = SpellBookInfoFactory.getHighestTier();

        for (int i = 1; i <= highestTier; i++) {
            List<SpellInfo> spellsByTier = SpellBookInfoFactory.getSpellsByLevel(i);
            Collections.shuffle(spellsByTier);
            spellsAvailableToBuy.addAll(spellsByTier.subList(0,2));
        }

        this.spellsAvailableToBuy = spellsAvailableToBuy;
    }
}
