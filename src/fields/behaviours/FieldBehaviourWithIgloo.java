package fields.behaviours;

import entities.Entity;
import fields.Field;
import scene.GameController;
import scene.writer.SceneWriter;

import java.util.Collection;

public class FieldBehaviourWithIgloo extends FieldBehaviour {

    public FieldBehaviourWithIgloo(Field f) {
        super(f);
        GameController.OutStream.println("Successful IglooBuild");
    }

    @Override
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {

    }

    /**
     * Kiírja az állapot röviden.
     */
    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("i");
    }
}
