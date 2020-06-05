package pl.psi.game.hero.shops;

import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SpellShop extends AbstractShop{

//    List<SpellInfo> random( int aTier){
//        return Arrays.asList(SpellInfo.SpellInfoEnum.values()).stream().filter(s -> s.getTier==aTier).collect(Collectors.toList());
//    }

    private List<SpellInfo> spellsAvailableToBuy;

    public SpellShop(){};

    public SpellShop(String name, String description, List<SpellInfo> spellsAvailableToBuy) {
        super(name, description);
        this.spellsAvailableToBuy = spellsAvailableToBuy;
    }

//    void generateSpellsAvailableToBuy() {
//        int highestTier = SpellBookInfoFactory.getHighestTier();
//        List<SpellInfo> spellsAvailableToBuy = new ArrayList<>();
//
//
//        for(int i=1; i<= highestTier; i++){
//
//            List<SpellInfo> tierSpells = SpellBookInfoFactory.getSpellsByLevel(i);
//            Collections.shuffle(tierSpells);
//            spellsAvailableToBuy.addAll(tierSpells.subList(0,2));
//
//        }
//
//       this.spellsAvailableToBuy = spellsAvailableToBuy;
//    }

    public List<SpellInfo> getSpellsAvailableToBuy() {

        List<SpellInfo> spells = SpellBookInfoFactory.getAll().stream().collect(Collectors.toList());
        List<SpellShop> SpellAvailableToBuy = new ArrayList<>();

        Random ran = new Random();
        int spellCount = ran.nextInt(10) + 2;
        for (int i = 0; i < spellCount; i++) {
            int randomIndex = ran.nextInt(spells.size());
            SpellInfo randomSpell = spells.get(randomIndex);
            spells.remove(randomIndex);
            spellsAvailableToBuy.add(randomSpell);
        }

        return spellsAvailableToBuy;
    }
}
