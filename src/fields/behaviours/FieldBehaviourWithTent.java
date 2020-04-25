package fields.behaviours;

import entities.Entity;
import scene.writer.SceneWriter;

import java.util.Collection;

public class FieldBehaviourWithTent extends FieldBehaviour{
    @Override
    public void destroyTent(){
        field.setBehaviour(new StandardFieldBehaviour());
    }

    @Override
    public boolean buildIgloo() {
        field.setBehaviour(new FieldBehaviourWithIgloo());
        return true;
    }

    @Override
    public void collideEntities(Entity enteringEntity) {

    }

    /**
     * Kiírja az állapot röviden.
     */
    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("t");
    }
}
