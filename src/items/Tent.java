package items;

import scene.writer.SceneWriter;

public class Tent extends Item {
    @Override
    public void use() {
        owner.buildTent(this);
    }

    @Override
    protected void showPickup() {
        SceneWriter.OutStream.println("Tent picked up");
    }

    public void Show() {
        SceneWriter.OutStream.print("Tent");
    }

    public void ShowShort() { SceneWriter.OutStream.print("t"); }
}
