package fields.behaviours;

import entities.Entity;
import fields.Field;
import scene.writer.SceneWriter;

import java.util.Collection;

public class FieldBehaviourWithTent extends FieldBehaviour{
    public FieldBehaviourWithTent(Field f) {
        super(f);
    }

    @Override
    public void destroyTent(){
        field.setBehaviour(new StandardFieldBehaviour(field));
    }

    @Override
    public boolean buildIgloo() {
        field.setBehaviour(new FieldBehaviourWithIgloo(field));
        return true;
    }

    @Override
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {
        for(Entity e : standingEntities){
            enteringEntity.collideWith(e);
        }
    }

    /**
     * Kiírja az állapot röviden.
     */
    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("t");
    }
}
