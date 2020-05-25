package pl.psi.game.hero;

import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class HeroInfoTest {

    //PW is static method so you don't have to do instance of HeroInfoFactory
    @Test
    void CheckGetAllMetode()
    {
        List<HeroInfo> heroInfoList;
        heroInfoList=HeroInfoFactory.getAll();
        assertEquals(HeroInfoFactory.EDRIC,heroInfoList.get(0).getName());
    }
    @Test
    void CheckGetFractionMetode()
    {
        List<HeroInfo> heroInfoList;
        heroInfoList=HeroInfoFactory.getHeroInfoListByFraction(HeroInfo.Fraction.TOWER);
        assertEquals(HeroInfoFactory.FAFNER,heroInfoList.get(0).getName());
    }
    @Test
    void CheckIfFractionClassSetStatistics()
    {
        HeroInfo heroInfo=HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        assertEquals(2,heroInfo.getAttack());
        assertEquals(2,heroInfo.getDefense());
        assertEquals(1,heroInfo.getPower());
        assertEquals(1,heroInfo.getKnowledge());
    }
}
