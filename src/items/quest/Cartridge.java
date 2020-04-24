package items.quest;

import scene.writer.SceneWriter;

//Patront megvalósító osztály
public class Cartridge extends QuestItem {
    public void Show() {
        SceneWriter.OutStream.print("Cartridge");
    }
    public void ShowShort() { SceneWriter.OutStream.print("c"); }
}
