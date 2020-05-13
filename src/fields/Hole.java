package fields;

import entities.Entity;
import fields.behaviours.StandardFieldBehaviour;
import items.Item;
import scene.Board;
import utility.Dialog;
import scene.GameController;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Lyuk, amiben víz van. Player-ek képesek belefulladni, ha nincs rajtuk búvárruha.
 */
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

    /**
     * Default konstruktor.
     */
    public Hole()
    {
        super();
    }

    /**
     * Konstruktor inicializálásra.
     * @param _neighbors Szomszédos mezők.
     * @param _entities Entitások, amelyek ezen a mezőn állnak.
     * @param _board Referencia a Board-ra, amely ezt a mezőt tartalmazza.
     * @param _UID Egyedi azonosító.
     */
    public Hole(ArrayList<Field> _neighbors, ArrayList<Entity> _entities, Board _board, int _UID)
    {
        neighbors = _neighbors;
        entities = _entities;
        board = _board;
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

    /**
     * Új Entity befogadása.
     * @param entity Field-re lépő entity referenciája.
     */
    @Override
    public void acceptEntity(Entity entity) {
        collideEntities(entity);
        entities.add(entity);
        entity.makeDrown();
        entity.changeField(this);
    }

    /**
     * Iglu építése. Ha sikeres az építés True-val tér vissza.
     * @return False, mivel nem lehet építeni.
     */
    @Override
    public boolean buildIgloo() { return false; }

    /**
     * Sátor építése. Ha sikeres az építés True-val tér vissza.
     * @return False, mivel nem lehet építeni.
     */
    @Override
    public boolean buildTent() {
        return false;
    }

    /**
     * Sátor elpusztítása.
     * Hole-on nem lehet sátor, így nem történik semmi.
     */
    @Override
    public void destroyTent() {

    }

    /**
     * Visszaadja a stabilitást.
     * @return "Hole" string, mivel stabilitás nem értelmezhető.
     */
    @Override
    public String checkStability() {
        //Megadja a mező stabilitását.
        return "Hole";
    }

    /**
     * Hole-on lévő tárgy visszaadása.
     * @return Ez mindig null, hiszen nem lehet tárgy a Hole-on.
     */
    @Override
    public Item getItem() {
        return null;
    }

    /**
     * Hole-on lévő tárgy eltávolítása.
     * Nem történik semmi, hiszen nem lehet Item, a Hole-on.
     */
    @Override
    public void removeItem() {

    }

    /**
     * Felhasználói input hatására kiválaszt egy Entity-t, amely a Hole-on van.
     * @return kiválaszott Entity.
     */
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
