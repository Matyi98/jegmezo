package items;

import scene.GameController;

//Búvárruhát reprezentáló osztály.
public class DivingSuit extends Item {

    @Override
    protected void showPickup() {
        GameController.OutStream.println("DivingSuit picked up");
    }

    public void use() {
        this.owner.swapDivingSuit();
    }

    public void Show() {
        GameController.OutStream.print("DivingSuit");
    }
    public void ShowShort() { GameController.OutStream.print("d"); }
}
