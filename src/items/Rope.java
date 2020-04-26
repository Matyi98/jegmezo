package items;

import scene.GameController;

//Kötelet reprezentáló osztály.
public class Rope extends Item {

    @Override
    protected void showPickup() {
        GameController.OutStream.println("Rope picked up");
    }

    public void use() {
        owner.rescueFriend();
    }

    public void Show() {
        GameController.OutStream.print("Rope");
    }
    public void ShowShort() { GameController.OutStream.print("r"); }
}
