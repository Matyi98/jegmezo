package items;

import scene.GameController;

//Lapátot reprezentáló osztály.
public class Shovel extends Item {
    //Ennyi hóréteget takarít el a lapát.
    private int shovelSpeedIncrease = 2;

    @Override
    protected void showPickup() {
        GameController.OutStream.println("Shovel picked up");
    }

    //Lapát használata.
    public void use(){
        owner.shovel(shovelSpeedIncrease);
    }

    public void Show() {
        GameController.OutStream.print("Shovel");
    }
    public void ShowShort() { GameController.OutStream.print("s"); }
}
