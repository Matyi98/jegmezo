package items.quest;

import scene.writer.SceneWriter;

//Jelzőfényt megvalósító osztály
public class Flare extends QuestItem {
    public void Show() {
        SceneWriter.OutStream.print("Flare");
    }
    public void ShowShort() { SceneWriter.OutStream.print("e"); }
}
