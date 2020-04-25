package fields;

import entities.Entity;
import fields.behaviours.FieldBehaviourWithIgloo;
import items.Item;
import entities.Player;
import scene.writer.SceneWriter;

public class StableIceField extends IceField{

    @Override
    public void Show() {
        SceneWriter.OutStream.print('S');
        SceneWriter.OutStream.print('0');
        SceneWriter.OutStream.print(snowLevel);

        if (item != null)
            item.ShowShort();
        else
            SceneWriter.OutStream.print('0');

        for (Entity e : entities)
            e.ShowShort();

        this.ShowState();
    }

    //Mezőn tárolt tárgy beállíítása.
    public void setItem(Item item){
        this.item = item;
    }

    public Item getItem(){ return item;}

    //Játékos befogadása a mezőre.
    @Override
    public boolean acceptEntity(Entity entity) {
        entities.add(entity);
        entity.walk();
        return true;
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("sikeres stabilitás vizsgálat: stableIceField. ");
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
    public void collideEntities(Entity enteringEntity) {
        behaviour.collideEntities(enteringEntity);
    }


}
