package fields;

import entities.Entity;
import scene.GameController;

/**
 * UnstableIceField osztály. Csak adott számú Entity-t képes elbírni, ha túl sok Entity kerül rá
 * akkor összetörik és Hole-á alakul.
 */
public class UnstableIceField extends IceField{

    /**
     * Megjeleníti a UnstableIceFieldet a SceneWriterben meghatározott folyamon.
     */
    @Override
    public void Show() {
        GameController.OutStream.print('U');
        GameController.OutStream.print(stability);
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
     * Iglu építése. Ha sikeres az építés True-val tér vissza.
     * @return unstableIceField-re nem lehet iglut építeni.
     */
    @Override
    public boolean buildIgloo(){
        return false;
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
     * Új Entity befogadása.
     * @param entity Field-re lépő Entity referenciája.
     */
    @Override
    public void acceptEntity(Entity entity) {
        collideEntities(entity);
        entities.add(entity);
        if(stability < entities.size()) {
            Hole hole = new Hole(this.neighbors, this.entities, this.board, this.UID);

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

    /**
     * Lekérdezi a Field stabilitását.
     * @return stabilitás.
     */
    @Override
    public String checkStability() {
        return String.valueOf(stability);
    }

}
