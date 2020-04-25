package fields;

import entities.Entity;
import scene.writer.SceneWriter;

public class UnstableIceField extends IceField{

    @Override
    public void Show() {
        SceneWriter.OutStream.print('U');
        SceneWriter.OutStream.print('0');
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
    public void collideEntities(Entity enteringEntity) {
        behaviour.collideEntities(enteringEntity);
    }

    //Jáékos befogadása a mezőre.
    @Override
    public boolean acceptEntity(Entity entity) {
        entities.add(entity);
        if(weightLimit<entities.size())
        {
            board.changeField(this, new Hole(), entities, neighbors);
        }
        return true;
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        return String.valueOf(weightLimit);
    }

    //Játékos átadása a aszomszd mezőnek, a megadott irányba.
    @Override
    public boolean placeEntityToNextField(int direction, Entity entity){
        //Szomszéd mező lekérése.
        Field neighbour = neighbors.get(direction);
        //Átadás a szomszédnak.
        neighbour.acceptEntity(entity);
        return false;
    }

}
