package views;

import items.Item;
import javafx.scene.image.ImageView;

public class ItemView extends ImageStackPane {
    public ItemView(Item i) {
        super(i.GetTexturePath());
        ImageView imageView = new ImageView(image);
        getChildren().add(imageView);
    }

}
