package items;

import scene.GameController;

public class Tent extends Item {
    @Override
    public void use() {
        owner.buildTent(this);
    }

    @Override
    protected void showPickup() {
        GameController.OutStream.println("Tent picked up");
    }

    public void Show() {
        GameController.OutStream.print("Tent");
    }

    public void ShowShort() { GameController.OutStream.print("t"); }
}
