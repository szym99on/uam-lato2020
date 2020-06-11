package pl.psi.gui.tiles;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpellBookGui   {

    private SpellBook spellBook;
    private Hero hero;

    public SpellBookGui(Hero ahero){

        hero = ahero;
        spellBook = hero.getSpellBook();

        JFrame frame = new JFrame("SpellBook");
        frame.setSize(800, 400);
        frame.setLayout(new GridLayout(8,8));
        for(Spell item : spellBook.getHeroSpells()){
            JButton button = new JButton(item.getSpellName());
            frame.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // choose tiles and use spell
                }
            });

        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }



}
