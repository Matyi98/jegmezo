package fields.behaviours;

import entities.Entity;
import scene.writer.SceneWriter;

public class FieldBehaviourWithIgloo extends FieldBehaviour {
    @Override
    public void collideEntities(Entity enteringEntity) {
        super.collideEntities(enteringEntity);
    }

    /**
     * Kiírja az állapot röviden.
     */
    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("i");
    }
}
