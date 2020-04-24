package items.quest;

import scene.writer.SceneWriter;

//Jelzőpisztolyt reprezentáló osztály.
public class Pistol extends QuestItem {

    public void Show() {
        SceneWriter.OutStream.print("Pistol");
    }
    public void ShowShort() { SceneWriter.OutStream.print("p"); }
}
