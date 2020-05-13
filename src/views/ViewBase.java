package views;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public abstract class ViewBase extends StackPane implements IView {
    protected Image image;

    public ViewBase(String imagePath) {
        if (!imagePath.equals(""))
            this.image = new Image(imagePath);
        else
            this.image = null;
    }
}
