package pl.psi.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Start extends Application {

    public Start() {
    }

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("main-battle.fxml"));
            MainBattleController mainBattleController = new MainBattleController();
            loader.setController(mainBattleController);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setTitle("Heroes 3");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException aE) {
            aE.printStackTrace();
        }

    }

}
