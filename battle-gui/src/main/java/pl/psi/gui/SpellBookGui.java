package pl.psi.gui;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.gui.states.NormalState;
import pl.psi.gui.states.StateMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class SpellBookGui   {

    private SpellBook spellBook;
    private Hero hero;
    private StateMap stateMap = new NormalState();


    //trzeba zrobic singletona
    public static Spell selectedSpell;


    public SpellBookGui(Hero ahero, StateMap aStateMap){
        stateMap = aStateMap;
        hero = ahero;
        spellBook = hero.getSpellBook();

        JFrame frame = new JFrame("SpellBook");
        frame.setSize(800, 600);
        frame.setLocation(50, 50);
        frame.setLayout(new GridLayout(15,6));
        for(Spell item : spellBook.getSpells()){
            JButton button = new JButton(item.getSpellName());
            frame.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    selectedSpell = item;
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            });

        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



}
