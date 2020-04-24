package items;

import scene.writer.SceneWriter;

public class Tent extends Item {
    @Override
    public void use() {

    }

    public void Show() {
        SceneWriter.OutStream.print("Tent");
    }

    public void ShowShort() { SceneWriter.OutStream.print("t"); }
}
