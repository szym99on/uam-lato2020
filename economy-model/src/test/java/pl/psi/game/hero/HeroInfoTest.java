package pl.psi.game.hero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class HeroInfoTest {

    @BeforeAll
    static void initializeHeroInfoFactory(){
        new HeroInfoFactory();
    }

    @Test
    void CheckGetAllMethod()
    {
        List<HeroInfo> heroInfoList;
        heroInfoList=HeroInfoFactory.getAll();
        assertEquals(HeroInfoFactory.EDRIC,heroInfoList.get(0).getName());
    }

    @Test
    void CheckIfFractionClassSetStatistics()
    {
        HeroInfo heroInfo=HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        assertEquals(2,heroInfo.getAttack());
        assertEquals(2,heroInfo.getDefence());
        assertEquals(1,heroInfo.getPower());
        assertEquals(1,heroInfo.getKnowledge());
    }
}
