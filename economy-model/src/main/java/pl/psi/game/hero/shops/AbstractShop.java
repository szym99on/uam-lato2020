package pl.psi.game.hero.shops;


import lombok.Getter;

@Getter
public class AbstractShop {

    private String name;
    private String description;


    public AbstractShop(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AbstractShop(){}

    void freezeShop(){

    }




}
