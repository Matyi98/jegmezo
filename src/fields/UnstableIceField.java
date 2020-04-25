package fields;

import entities.Entity;

import fields.behaviours.StandardFieldBehaviour;
import scene.writer.SceneWriter;

import java.util.Collection;

public class UnstableIceField extends IceField{

    @Override
    public void Show() {
        SceneWriter.OutStream.print('U');
        SceneWriter.OutStream.print(weightLimit);
        SceneWriter.OutStream.print(snowLevel);
        if (item != null)
            item.ShowShort();
        else
            SceneWriter.OutStream.print('0');

        if (entities.size() == 0)
            SceneWriter.OutStream.print('0');
        else
        for (Entity e : entities)
            e.ShowShort();
            this.ShowState();
    }

    //Iglu építése.
    @Override
    public boolean buildIgloo(){
        //Instabil mezőre ne lehet építeni Iglut.
        return false;
    }

    @Override
    public boolean buildTent() {
        return behaviour.buildTent();
    }

    @Override
    public void destroyTent() {
        behaviour.destroyTent();
    }

    @Override
    public void performSnow() {
        behaviour.performSnow(entities);
    }

    @Override
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {
        behaviour.collideEntities(enteringEntity, entities);
    }

    //Játékos befogadása a mezőre.
    @Override
    public void acceptEntity(Entity entity) {
        entities.add(entity);
        if(weightLimit <entities.size()) {
            Hole hole = new Hole(this.neighbors, this.entities, this.board, this.autoIncrementID, this.UID, new StandardFieldBehaviour());
            entity.changeField(hole);
            board.changeField(this,hole);
            for(Field field: neighbors)
            {
                field.changeNeighbor(this, hole);
            }
            entity.drown();
        }
        else {
            entity.changeField(this);
            entity.walk();
        }
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        return String.valueOf(weightLimit);
    }

}
