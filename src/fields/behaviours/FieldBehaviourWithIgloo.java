package fields.behaviours;

import entities.Entity;
import scene.writer.SceneWriter;

import java.util.Collection;

public class FieldBehaviourWithIgloo extends FieldBehaviour {

    @Override
    public void collideEntities(Entity enteringEntity) {

    }

    /**
     * Kiírja az állapot röviden.
     */
    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("i");
    }
}
