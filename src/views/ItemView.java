package views;

import items.Item;
import javafx.scene.image.ImageView;

public class ItemView extends ViewBase {
    private Item data;

    public ItemView(Item i) {
        super(i.GetTexturePath());
        this.data = i;
        ImageView imageView = new ImageView(image);
        getChildren().add(imageView);
    }

    @Override
    public void Update() {

    }
}
