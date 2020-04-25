package fields.behaviours;

import entities.Entity;
import fields.Field;

import java.util.Collection;

public abstract class FieldBehaviour {
    protected Field field;

    public void performSnow(Collection<Entity> entities){

    }

    public boolean buildTent(){
        return false;
    }

    public void destroyTent(){

    }

    public boolean buildIgloo(){
        return false;
    }

    public void collideEntities(Entity enteringEntity){

    }

    /**
     * Kiírja az állapot röviden.
     */
    public abstract void ShowShort();
}
