package items.quest;

import scene.GameController;

//Jelzőpisztolyt reprezentáló osztály.
public class Pistol extends QuestItem {
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Pistol picked up");
    }
    public void Show() {
        GameController.OutStream.print("Pistol");
    }
    public void ShowShort() { GameController.OutStream.print("p"); }
}
