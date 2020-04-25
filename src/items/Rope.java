package items;

import scene.writer.SceneWriter;

//Kötelet reprezentáló osztály.
public class Rope extends Item {

    public void use() {
        owner.rescueFriend();
    }

    public void Show() {
        SceneWriter.OutStream.print("Rope");
    }
    public void ShowShort() { SceneWriter.OutStream.print("r"); }
}
