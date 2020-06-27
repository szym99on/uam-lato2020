package pl.psi.gui.tiles;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MapTile extends StackPane {

    private final Rectangle rect;
    private final Label label;
    private String name;

    public final static int TILE_HEIGHT = 60;
    public final static int TILE_WIDTH = 60;


    MapTile(String aName) {
        name = aName;
        rect = prepareRectangleBackground();
        label = new Label(name);
        getChildren().add(label);
    }

    private Rectangle prepareRectangleBackground() {
        Rectangle rect;
        rect = new Rectangle(TILE_WIDTH, TILE_HEIGHT);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.RED);
        getChildren().add(rect);
        return rect;
    }

    MapTile(Image aImage, String aCurrentState){
        rect = prepareRectangleBackground();

        Image image = aImage;
        ImageView imageView = new ImageView(aImage);
        imageView.setFitHeight(TILE_HEIGHT - 10);
        imageView.setFitWidth(TILE_WIDTH);
        label = new Label(aCurrentState);
        label.setFont(new Font("Arial", 10));

        VBox vbox = new VBox();
        vbox.getChildren().add(imageView);
        vbox.getChildren().add(label);
        getChildren().add(vbox);
    }

    void setName(String aName){
        label.setText(aName);
    }

    Rectangle getRect() {
        return rect;
    }

    void setBackground(Color aColor) {
        rect.setFill(aColor);
    }

}
