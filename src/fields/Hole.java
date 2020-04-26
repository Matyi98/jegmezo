package fields;

import entities.Entity;
import fields.behaviours.FieldBehaviour;
import fields.behaviours.StandardFieldBehaviour;
import items.Item;
import scene.Board;
import scene.Dialog;
import scene.GameController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

public class Hole extends Field {

    /**
     * Inicializálja a mező kezdőállapotát.
     * @param w A mező által elbírt entitások száma.    Ignorált, hiszen ez egy luk.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.                   Ignorált, hiszen lukon nem kezdhet entitás.
     */
    public final void Setup(Board b, int w, int s, Optional<Item> i, ArrayList<Entity> e) {
        board = b; snowLevel = s;
    }

    public Hole()
    {
        super();
    }

    public Hole(ArrayList<Field> _neighbors, ArrayList<Entity> _entities, Board _board, int _autoIncrementId, int _UID)
    {
        neighbors = _neighbors;
        entities = _entities;
        board = _board;
        autoIncrementID = _autoIncrementId;
        UID = _UID;
        behaviour = new StandardFieldBehaviour(this);
    }


    /**
     * Megjeleníti a Fieldet a SceneWirterben meghatározott folyamon.
     */
    public void Show() {
        GameController.OutStream.print('H');
        GameController.OutStream.print('0');
        GameController.OutStream.print(snowLevel);
        GameController.OutStream.print(0);

        if (entities.size() == 0)
            GameController.OutStream.print('0');
        else
            for (Entity e : entities)
            e.ShowShort();
        this.ShowState();
    }

    @Override
    public void acceptEntity(Entity entity) {
        collideEntities(entity);
        entities.add(entity);
        entity.makeDrown();
        entity.changeField(this);
    }

    @Override
    public boolean buildIgloo() { return false; }

    @Override
    public boolean buildTent() {
        return false;
    }

    @Override
    public void destroyTent() {

    }

    @Override
    public void performSnow() {

    }

    @Override
    public String checkStability() {
        //Megadja a mező stabilitását.
        return "Hole";
    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public void removeItem() {

    }

    @Override
    public Entity selectEntity() {
        ArrayList<String> names = new ArrayList<>();
        for(Entity e : entities){
            names.add(e.getName());
        }

        Dialog popup = new Dialog("Who will you rescue?", names);
        int choice = popup.ShowDialog();

        return entities.get(choice);
    }
}
