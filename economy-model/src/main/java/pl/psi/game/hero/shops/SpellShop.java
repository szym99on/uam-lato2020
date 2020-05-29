package pl.psi.game.hero.shops;

import lombok.Getter;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpellShop extends AbstractShop{

//    List<SpellInfo> random( int aTier){
//        return Arrays.asList(SpellInfo.SpellInfoEnum.values()).stream().filter(s -> s.getTier==aTier).collect(Collectors.toList());
//    }

    private List<SpellInfo> spellsAvailableToBuy;


    void generateSpellsAvailableToBuy() {
        int highestTier = SpellBookInfoFactory.getHighestTier();
        List<SpellInfo> spellsAvailableToBuy = new ArrayList<>();


        for(int i=1; i<= highestTier; i++){

            List<SpellInfo> tierSpells = SpellBookInfoFactory.getSpellsByLevel(i);
            Collections.shuffle(tierSpells);
            spellsAvailableToBuy.addAll(tierSpells.subList(0,2));

        }

       this.spellsAvailableToBuy = spellsAvailableToBuy;
    }


    public List<SpellInfo> getSpellsAvailableToBuy() {
        return spellsAvailableToBuy;
    }

    public SpellShop(){};

    public SpellShop(String name, String description, List<SpellInfo> spellsAvailableToBuy) {
        super(name, description);
        this.spellsAvailableToBuy = spellsAvailableToBuy;
    }



}
