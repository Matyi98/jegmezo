package fields;

import entities.Entity;
import fields.behaviours.StandardFieldBehaviour;
import scene.GameController;

import java.util.ArrayList;
import java.util.Collection;

public class UnstableIceField extends IceField{

    @Override
    public void Show() {
        GameController.OutStream.print('U');
        GameController.OutStream.print(weightLimit);
        GameController.OutStream.print(snowLevel);
        if (item != null)
            item.ShowShort();
        else
            GameController.OutStream.print('0');

        if (entities.size() == 0)
            GameController.OutStream.print('0');
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

    //Játékos befogadása a mezőre.
    @Override
    public void acceptEntity(Entity entity) {
        collideEntities(entity);
        entities.add(entity);
        if(weightLimit < entities.size()) {
            Hole hole = new Hole(this.neighbors, this.entities, this.board, this.autoIncrementID, this.UID);

            entity.changeField(hole);
            board.changeField(this,hole);
            for(Field field: neighbors)
            {
                field.changeNeighbor(this, hole);
            }
            entity.makeDrown();
        }
        else {
            entity.changeField(this);
            entity.makeWalk();
        }
    }

    @Override
    public String checkStability() {
        return String.valueOf(weightLimit);
    }

}
