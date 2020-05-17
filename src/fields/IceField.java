package fields;

import entities.Entity;
import items.Item;
import game.Board;

import java.util.ArrayList;
import java.util.Optional;

/**
 * IceField, ezen a Player-ek szabadon mozoghatnak, lehet rajtuk tárgy, iglu vagy akár sátor is.
 */
public abstract class IceField extends Field {
    /**
     * Tárgy, amely az IceField-en van.
     */
    protected Item item;

    /**
     * IceField stabilitása.
     */
    protected int stability;

    /**
     * Inicializálja a mező kezdőállapotát.
     * @param w A mező által elbírt entitások száma.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.
     */
    public final void Setup(Board b, int w, int s, Optional<Item> i, ArrayList<Entity> e) {
        board = b;
        this.stability = w;
        this.snowLevel = s;
        i.ifPresent(value -> this.item = value);
        entities = e;
    }

    /**
     * Item elhelyezése.
     * @param item Elhelyezendő Item referenciája.
     */
    public void setItem(Item item){
        this.item = item;
    }

    /**
     * A Field-en lévő Item lekérdezése.
     * @return item.
     */
    @Override
    public Item getItem(){
        return this.item;
    }

    /**
     * A Field-en lévő Item eltávolítása.
     */
    @Override
    public void removeItem() {
        this.item = null;
    }

    /**
     * Nincs értelme egyelőre IceFielden embert kiválasztani.
     * @return kiválasztott entitás
     */
    @Override
    public Entity selectEntity(){ return null; }
}
