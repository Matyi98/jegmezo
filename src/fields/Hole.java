package fields;

import entities.Entity;
import fields.behaviours.FieldBehaviour;
import fields.behaviours.StandardFieldBehaviour;
import items.Item;
import scene.Board;
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

    @Override
    public void removeItem() {

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
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {

    }

    @Override
    public String checkStability() {
        //Megadja a mező stabilitását.
        return "Hole";
    }

    public Entity selectEntity() {
        //TODO: teljesen átírni, hogy a Dialoge osztályt használja
        System.out.println("Válassz alapján az alábbi megmenekítendő lények közül kit szeretnél kimenteni!");
        System.out.println("A kiválasztáshoz add meg a sorszámát majd üss entert!");

        for (int i = 0; i < entities.size(); i++)
            System.out.println(i + ".: " + entities.get(i).toString());

        Scanner s = new Scanner(System.in);

        int NO_INPUT = -1;
        int indexOfSelected = NO_INPUT;
        try {
            indexOfSelected = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e){ }

        if(indexOfSelected >= entities.size() || indexOfSelected < 0)
            return null;

        return entities.get(indexOfSelected);
    }

    @Override
    public void step(){
        super.step();
        for(Entity e: entities){
            e.makeDrown();
        }
    }
}
