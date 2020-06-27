package pl.psi.gui;

import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.move.MoveInfoFactory;
import pl.psi.game.skills.SkillInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;

public abstract class AbstractInitializer {

    AbstractInitializer() {
        new HeroInfoFactory();
        new ArtifactsInfoFactory();
        new SpellBookInfoFactory();
        new SkillInfoFactory();
        new MoveInfoFactory();
    }

   abstract EconomyHero getH1();
   abstract EconomyHero getH2();
}
