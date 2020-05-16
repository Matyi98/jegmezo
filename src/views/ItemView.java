package views;

import items.Item;
import javafx.scene.image.ImageView;

public class ItemView extends ViewBase {
    private Item data;
    ImageView imageView;

    public ItemView(Item i) {
        super(i.GetTexturePath());
        this.data = i;
        imageView = new ImageView(image);
        getChildren().add(imageView);
    }

    public void SetOpacity(double opacity){
        imageView.setOpacity(opacity);
    }


    @Override
    public void Update() {

    }
}
