package pl.psi.game.hero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class HeroInfoTest {
    @Test
    void CheckGetAllMetode()
    {
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        List<HeroInfo> heroInfoList=new ArrayList<>();
        heroInfoList=heroInfoFactory.getAll();
        assertEquals(heroInfoList.get(0).getName(),"Isra");
    }
    @Test
    void CheckGetFractionMetode()
    {
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        List<HeroInfo> heroInfoList=new ArrayList<>();
        heroInfoList=heroInfoFactory.getHeroInfoListByFraction(HeroInfo.Fraction.NECROPOLIS);
        assertEquals(heroInfoList.get(0).getName(),"Isra");
    }
    @Test
    void CheckIfFractionClassSetStatistics()
    {
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        HeroInfo heroInfo=heroInfoFactory.getHeroInfoByName("Isra");
        assertEquals(heroInfo.getAttack(),1);
        assertEquals(heroInfo.getDefense(),2);
        assertEquals(heroInfo.getPower(),2);
        assertEquals(heroInfo.getKnowledge(),1);
    }
}
