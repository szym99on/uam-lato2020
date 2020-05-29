package pl.psi.game.hero.shops;

import pl.psi.game.skills.SkillInfo;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpecialSkillsShop  extends  AbstractShop{

//    List<SkillInfo> random(int aTier){
//        return Arrays.asList(SkillInfo.SkillIInfoEnum.values()).stream().filter(s -> s.getTier==aTier).collect(Collectors.toList());
//    }

    private List<SkillInfo> skillsAvailableToBuy;


     List<SkillInfo> generateSkillsAvailableToBuy() {
        return null;
    }

    public SpecialSkillsShop(){}

    public SpecialSkillsShop(String name, String description, List<SkillInfo> skillsAvailableToBuy) {
        super(name, description);
        this.skillsAvailableToBuy = skillsAvailableToBuy;
    }
}
