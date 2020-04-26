package items.quest;

import scene.GameController;

//Patront megvalósító osztály
public class Cartridge extends QuestItem {
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Cartridge picked up");
    }
    public void Show() {
        GameController.OutStream.print("Cartridge");
    }
    public void ShowShort() { GameController.OutStream.print("c"); }
}
