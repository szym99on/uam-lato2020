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
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        List<HeroInfo> heroInfoList=new ArrayList<>();
        heroInfoList=heroInfoFactory.getAll();
        assertEquals("Edric",heroInfoList.get(0).getName());
    }
    @Test
    void CheckGetFractionMetode()
    {
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        List<HeroInfo> heroInfoList=new ArrayList<>();
        heroInfoList=heroInfoFactory.getHeroInfoListByFraction(HeroInfo.Fraction.TOWER);
        assertEquals("Fafner",heroInfoList.get(0).getName());
    }
    @Test
    void CheckIfFractionClassSetStatistics()
    {
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        HeroInfo heroInfo=heroInfoFactory.getHeroInfoByName("Edric");
        assertEquals(2,heroInfo.getAttack());
        assertEquals(2,heroInfo.getDefense());
        assertEquals(1,heroInfo.getPower());
        assertEquals(1,heroInfo.getKnowledge());
    }
}
