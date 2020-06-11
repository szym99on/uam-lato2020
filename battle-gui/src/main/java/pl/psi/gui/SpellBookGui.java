package pl.psi.gui;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.game.spellbook.SummonUnits;
import pl.psi.gui.states.SummonUnitsState;
import pl.psi.gui.states.StateMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SpellBookGui   {

    private SpellBook spellBook;
    private Hero hero;
    private StateMap stateMap;

    public SpellBookGui(Hero ahero, StateMap aStateMap){
        stateMap = aStateMap;
        hero = ahero;
        spellBook = hero.getSpellBook();

        JFrame frame = new JFrame("SpellBook");
        frame.setSize(800, 600);
        frame.setLocation(50, 50);
        frame.setLayout(new GridLayout(15,6));

        Map<String,JButton> buttonMap = new HashMap<String,JButton>();

        for(Spell item : spellBook.getHeroSpells()){
            JButton button = new JButton(item.getSpellName());
            frame.add(new Button(item.getSpellName()));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    stateMap = new SummonUnitsState();
                    frame.setTitle("eloo");


                }
            });

        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }



}
