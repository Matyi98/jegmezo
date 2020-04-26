package items;

import scene.writer.SceneWriter;

//Kötelet reprezentáló osztály.
public class Rope extends Item {

    @Override
    protected void showPickup() {
        SceneWriter.OutStream.print("Rope picked up");
    }

    public void use() {
        owner.rescueFriend();
    }

    public void Show() {
        SceneWriter.OutStream.print("Rope");
    }
    public void ShowShort() { SceneWriter.OutStream.print("r"); }
}
