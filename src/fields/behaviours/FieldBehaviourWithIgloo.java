package fields.behaviours;

import entities.Entity;
import scene.writer.SceneWriter;

public class FieldBehaviourWithIgloo extends FieldBehaviour {
    @Override
    public void collideEntities(Entity enteringEntity) {
        super.collideEntities(enteringEntity);
    }

    public boolean buildTent() {
        return false;
    }

    @Override
    public boolean buildIgloo() {
        return false;
    }

    /**
     * Kiírja az állapot röviden.
     */
    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("i");
    }
}
