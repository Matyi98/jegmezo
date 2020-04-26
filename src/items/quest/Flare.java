package items.quest;

import scene.GameController;

//Jelzőfényt megvalósító osztály
public class Flare extends QuestItem {
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Flare picked up");
    }
    public void Show() {
        GameController.OutStream.print("Flare");
    }
    public void ShowShort() { GameController.OutStream.print("e"); }
}
