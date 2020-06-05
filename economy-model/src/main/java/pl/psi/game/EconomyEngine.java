package pl.psi.game;

import pl.psi.game.hero.economyHero.EconomyHero;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EconomyEngine implements PropertyChangeListener {

    public static final String END_OF_TURN = "END_OF_TURN";
    public static final String ITEM_BOUGHT = "ITEM_BOUGHT";
    public static final String ACTIVE_HERO_CHANGED = "ACTIVE_HERO_CHANGED";


    private PropertyChangeSupport propertyChangeSupport;


    public EconomyEngine(EconomyHero economyHero1, EconomyHero economyHero2){

    }


    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }
}
