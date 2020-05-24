package pl.psi.game;

import lombok.Getter;

@Getter
public class AbstractItemInfo {


    private String name;
    private String description;
    private int cost;

    public String getName() {
        return name;
    }
    public AbstractItemInfo(String aName, String aDescription, int aCost) {
        name = aName;
        description = aDescription;
        cost = aCost;
    }
}
