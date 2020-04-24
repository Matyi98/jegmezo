package items;

import scene.writer.SceneWriter;

public class FragileShovel extends Item {

    @Override
    public void use() {

    }

    public void Show() {
        SceneWriter.OutStream.print("FragileShovel");
    }
    public void ShowShort() { SceneWriter.OutStream.print("g"); }
}
