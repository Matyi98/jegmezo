package fields.behaviours;

import entities.Entity;
import scene.writer.SceneWriter;

import java.util.Collection;

public class StandardFieldBehaviour extends FieldBehaviour {
    @Override
    public void performSnow(Collection<Entity> entities) {
        for(Entity e: entities){
            e.decrementHP();
            field.changeSnowLevel(2);
        }
    }

    @Override
    public boolean buildTent() {
        field.setBehaviour(new FieldBehaviourWithTent());
        return true;
    }

    @Override
    public boolean buildIgloo() {
        field.setBehaviour(new FieldBehaviourWithIgloo());
        return true;
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
