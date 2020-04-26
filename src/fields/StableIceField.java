package fields;

import entities.Entity;
import scene.GameController;

/**
 * StableIceField osztály. Bármennyi Entity-t képes elbírni.
 */
public class StableIceField extends IceField{

    /**
     * Megjeleníti a StableIceFieldet a SceneWriterben meghatározott folyamon.
     */
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

    /**
     * Új Entity befogadása.
     * @param entity Field-re lépő Entity referenciája.
     */
    @Override
    public void acceptEntity(Entity entity) {
        collideEntities(entity);
        entities.add(entity);
        entity.makeWalk();
        entity.changeField(this);
    }

    /**
     * Lekérdezi a Field stabilitását.
     * @return "Stable" string, bármennyi Entity-t elbír.
     */
    @Override
    public String checkStability() {
        return "Stable";
    }

    /**
     * Iglu építése. Ha sikeres az építés True-val tér vissza.
     * @return sikeres építés.
     */
    @Override
    public boolean buildIgloo(){
        return behaviour.buildIgloo();
    }

    /**
     * Sátor építése. Ha sikeres az építés True-val tér vissza.
     * @return sikeres építés.
     */
    @Override
    public boolean buildTent() {
        return behaviour.buildTent();
    }

    /**
     * Sátor elpusztítása.
     */
    @Override
    public void destroyTent() {
        behaviour.destroyTent();
    }

    /**
     * Havazás a Field-en.
     */
    @Override
    public void performSnow() {
        behaviour.performSnow(entities);
    }


}
