package views;

import items.Item;

public class ItemView extends ViewBase {
    private Item data;
    public ItemView(Item i) {
        super(i.GetTexturePath());
        this.data = i;
    }

    @Override
    public void Update() {
        //TODO: Implement this.
    }
}
