package fields.behaviours;

import entities.Entity;
import fields.Field;

import java.util.Collection;

public abstract class FieldBehaviour {
    protected Field field;

    public void performSnow(Collection<Entity> entities) {

    }

    public boolean buildTent() {
        return false;
    }

    public boolean buildIgloo() {
        return false;
    }

    public void destroyTent(){

    }

    public abstract void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities);

    /**
     * Kiírja az állapot röviden.
     */
    public abstract void ShowShort();
}
