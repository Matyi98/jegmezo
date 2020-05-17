package views;

import items.Item;
import javafx.scene.image.ImageView;

/**
 * Eszközök megjelenítésért felelős osztály.
 */
public class ItemView extends ImageStackPane {
    /**
     * Konstruktor.
     * @param i Az az item, amit megjelenít.
     */
    public ItemView(Item i) {
        super(i.GetTexturePath());
        ImageView imageView = new ImageView(image);
        getChildren().add(imageView);
    }

}
