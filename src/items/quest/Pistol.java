package items.quest;

import scene.writer.SceneWriter;

//Jelzőpisztolyt reprezentáló osztály.
public class Pistol extends QuestItem {
    @Override
    protected void showPickup() {
        SceneWriter.OutStream.println("Pistol picked up");
    }
    public void Show() {
        SceneWriter.OutStream.print("Pistol");
    }
    public void ShowShort() { SceneWriter.OutStream.print("p"); }
}
