package fields.behaviours;

import scene.writer.SceneWriter;

public class StandardFieldBehaviour extends FieldBehaviour {
    @Override
    public boolean buildTent() {
        return true;
    }

    @Override
    public boolean buildIgloo() { return true; }

    /**
     * Kiírja az állapot röviden. Ennek az állípotnak nincs rövid jele.
     */
    @Override
    public void ShowShort() {

    }
}
