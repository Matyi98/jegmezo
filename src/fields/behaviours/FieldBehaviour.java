package fields.behaviours;

import entities.Entity;
import fields.Field;

import java.util.Collection;

public abstract class FieldBehaviour {
    protected Field field;

    public void performSnow(Collection<Entity> entities){

    }

    public abstract boolean buildTent();
    public void destroyTent(){

    }

    public abstract boolean buildIgloo();

    public void collideEntities(Entity enteringEntity){

    }

    /**
     * Kiírja az állapot röviden.
     */
    public abstract void ShowShort();
}
