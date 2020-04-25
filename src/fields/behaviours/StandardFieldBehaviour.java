package fields.behaviours;

import entities.Entity;
import fields.Field;
import scene.writer.SceneWriter;

import java.util.Collection;

public class StandardFieldBehaviour extends FieldBehaviour {
    public StandardFieldBehaviour(Field f) {
        super(f);
    }

    @Override
    public void performSnow(Collection<Entity> entities) {
        for(Entity e: entities){
            e.decrementHP();
        }
        field.changeSnowLevel(2);
    }

    @Override
    public boolean buildTent() {
        if(field.getSnowLevel() == 0){
            field.setBehaviour(new FieldBehaviourWithTent(field));
            return true;
        } else
            return false;
    }

    @Override
    public boolean buildIgloo() {
        if(field.getSnowLevel() == 0){
            field.setBehaviour(new FieldBehaviourWithIgloo(field));
            return true;
        } else
            return false;
    }

    @Override
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {
        for(Entity e : standingEntities){
            enteringEntity.collideWith(e);
        }
    }

    /**
     * Kiírja az állapot röviden. Ennek az állípotnak nincs rövid jele.
     */
    @Override
    public void ShowShort() {

    }
}
