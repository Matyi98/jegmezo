package fields;

import entities.Entity;
import items.Item;
import scene.GameController;

import java.util.Collection;

public class StableIceField extends IceField{

    @Override
    public void Show() {
        GameController.OutStream.print('S');
        GameController.OutStream.print('0');
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

    //Mezőn tárolt tárgy beállíítása.
    public void setItem(Item item){
        this.item = item;
    }

    //Játékos befogadása a mezőre.
    @Override
    public void acceptEntity(Entity entity) {
        entities.add(entity);
        entity.makeWalk();
        entity.changeField(this);
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        return "Stable";
    }

    //Iglu építése a mezőn.
    @Override
    public boolean buildIgloo(){
        return behaviour.buildIgloo();
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

}
