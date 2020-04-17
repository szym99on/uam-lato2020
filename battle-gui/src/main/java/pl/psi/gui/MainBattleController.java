package pl.psi.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MainBattleController {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    public MainBattleController() {

    }

    @FXML
    private void initialize() {
        refreshGui();
    }

    private void refreshGui() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                createTile(i, j);
            }
        }
    }

    private void createTile(int aX, int aY) {
        DefaultTileFactory tileFactory = new DefaultTileFactory();
        MapTile tile = tileFactory.generateTile();

        gridMap.add(tile, aX, aY);
    }
}
