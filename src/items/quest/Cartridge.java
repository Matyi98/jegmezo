package items.quest;

import scene.writer.SceneWriter;

//Patront megvalósító osztály
public class Cartridge extends QuestItem {
    @Override
    protected void showPickup() {
        SceneWriter.OutStream.print("Cartridge picked up");
    }
    public void Show() {
        SceneWriter.OutStream.print("Cartridge");
    }
    public void ShowShort() { SceneWriter.OutStream.print("c"); }
}
