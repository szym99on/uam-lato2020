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
        assertEquals(heroInfoList.get(0).getName(),"Edric");
    }
    @Test
    void CheckGetFractionMetode()
    {
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        List<HeroInfo> heroInfoList=new ArrayList<>();
        heroInfoList=heroInfoFactory.getHeroInfoListByFraction(HeroInfo.Fraction.TOWER);
        assertEquals(heroInfoList.get(0).getName(),"Fafner");
    }
    @Test
    void CheckIfFractionClassSetStatistics()
    {
        HeroInfoFactory heroInfoFactory = new HeroInfoFactory();
        HeroInfo heroInfo=heroInfoFactory.getHeroInfoByName("Edric");
        assertEquals(heroInfo.getAttack(),2);
        assertEquals(heroInfo.getDefense(),2);
        assertEquals(heroInfo.getPower(),1);
        assertEquals(heroInfo.getKnowledge(),1);
    }
}
