package pl.psi.game.hero.shops;

import lombok.Getter;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.skills.SkillInfo;
import pl.psi.game.skills.SkillInfoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SpecialSkillsShop  extends  AbstractShop{


    @Getter
    private List<SkillInfo> specialSkillsAvailableToBuy;

    public SpecialSkillsShop(){}

    public SpecialSkillsShop(String name, String description, List<SkillInfo> skillsAvailableToBuy) {
        super(name, description);
        this.specialSkillsAvailableToBuy = skillsAvailableToBuy;
    }

     @Override
     public void generateItemsAvailableToBuy(){

         List<SkillInfo> skills = new ArrayList<>(SkillInfoFactory.getAll());
         List<SkillInfo> specialSkillAvailableToBuy = new ArrayList<>();

         Random ran = new Random();
         int skillCount = ran.nextInt(4) + 6;
         for (int i = 0; i < skillCount; i++) {
             int randomIndex = ran.nextInt(skills.size());
             SkillInfo randomSkill = skills.get(randomIndex);
             skills.remove(randomIndex);
             specialSkillAvailableToBuy.add(randomSkill);
         }

         this.specialSkillsAvailableToBuy = specialSkillAvailableToBuy;
    }

}
