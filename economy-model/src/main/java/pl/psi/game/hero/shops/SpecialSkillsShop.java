package pl.psi.game.hero.shops;

import pl.psi.game.skills.SkillInfo;
import pl.psi.game.skills.SkillInfoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SpecialSkillsShop  extends  AbstractShop{

    private List<SkillInfo> skillsAvailableToBuy;

    public SpecialSkillsShop(){}

    public SpecialSkillsShop(String name, String description, List<SkillInfo> skillsAvailableToBuy) {
        super(name, description);
        this.skillsAvailableToBuy = skillsAvailableToBuy;
    }

     List<SkillInfo> generateSkillsAvailableToBuy() {

         List<SkillInfo> skills = SkillInfoFactory.getAll().stream().collect(Collectors.toList());
         List<SkillInfo> specialSkillAvailableToBuy = new ArrayList<>();

         Random ran = new Random();
         int skillCount = ran.nextInt(10) + 2;
         for (int i = 0; i < skillCount; i++) {
             int randomIndex = ran.nextInt(skills.size());
             SkillInfo randomSkill = skills.get(randomIndex);
             skills.remove(randomIndex);
             specialSkillAvailableToBuy.add(randomSkill);
         }

         return specialSkillAvailableToBuy;
    }

}
