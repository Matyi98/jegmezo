package views;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public abstract class ViewBase extends StackPane {
    protected Image image;

    public abstract void Update();

    public ViewBase(String imagePath) {
        this.image = new Image(imagePath);
    }
}
