package fields;

import entities.Entity;
import items.Item;
import scene.Board;

import java.util.ArrayList;
import java.util.Optional;

public abstract class IceField extends Field {
    protected Item item;
    protected int weightLimit;

    /**
     * Inicializálja a mező kezdőállapotát.
     * @param w A mező által elbírt entitások száma.    Ignorált, hiszen ez egy luk.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.                   Ignorált, hiszen lukon nem kezdhet entitás.
     */
    public final void Setup(Board b, int w, int s, Optional<Item> i, ArrayList<Entity> e) {
        board = b;
        this.weightLimit = w;
        this.snowLevel = s;
        i.ifPresent(value -> this.item = value);
        entities = e;
    }

    //Visszaadja a fielden lévő itemet
    public Item getItem(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return this.item;
    }

    @Override
    public void removeItem() {

    }

    /**
     * Nincs értelme egyelőre IceFielden embert kiválasztani.
     * @return kiválasztott entitás
     */
    @Override
    public Entity selectEntity(){ return null; }

}
