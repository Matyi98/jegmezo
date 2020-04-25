package fields.behaviours;

import scene.writer.SceneWriter;

public class FieldBehaviourWithTent extends FieldBehaviour{
    @Override
    public void destroyTent(){
    }

    public boolean buildTent() {
        return true;
    }

    @Override
    public boolean buildIgloo() {
        return true;
    }

    /**
     * Kiírja az állapot röviden.
     */
    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("t");
    }
}
