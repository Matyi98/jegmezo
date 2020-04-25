package items;

import scene.writer.SceneWriter;

//Búvárruhát reprezentáló osztály.
public class DivingSuit extends Item {
    public void use() {
        this.owner.swapDivingSuit();
    }

    public void Show() {
        SceneWriter.OutStream.print("DivingSuit");
    }
    public void ShowShort() { SceneWriter.OutStream.print("d"); }
}
