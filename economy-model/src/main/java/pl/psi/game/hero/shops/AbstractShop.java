package pl.psi.game.hero.shops;


import lombok.Getter;

import java.util.List;

@Getter
public abstract class AbstractShop {

    private String name;
    private String description;


    public AbstractShop(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AbstractShop(){}

    void freezeShop(){

    }

     public abstract  void generateItemsAvailableToBuy();

}
