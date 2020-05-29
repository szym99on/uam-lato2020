package pl.psi.game.hero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.SpellInfo;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterRequest {

    @BeforeAll
    static void initializeHeroInfoFactory(){
        new HeroInfoFactory();

    }
    @Test
    void CreateEconomyHeroFromHeroInfo()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();
    }
    @Test
    void EconomyHeroNeedGetAttackMethod()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();
        assertEquals(2,economyHero.getAttack());
    }
    @Test
    void EconomyHeroNeedGetDefenceMethod()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();
        assertEquals(2,economyHero.getDefense());
    }
    @Test
    void EconomyHeroNeedGetPowerMethod()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();
        assertEquals(1,economyHero.getPower());
    }
    @Test
    void EconomyHeroNeedGetKnowledgeMethod()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();
        assertEquals(1,economyHero.getKnowledge());
    }
    @Test
    void EconomyHeroGetArtifactsShouldBePublic()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();
        List<ArtifactInfo> artifactInfoList = economyHero.getArtifacts();
    }
    @Test
    void EconomyHeroGetSpellsShouldBePublic()
    {
        HeroInfo heroInfo = HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC);
        EconomyHero economyHero = EconomyHero.builder().aHeroInfo(heroInfo).build();
        List<SpellInfo> artifactInfoList = economyHero.getSpells();
    }
}
