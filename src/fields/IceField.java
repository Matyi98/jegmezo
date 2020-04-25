package fields;

import entities.Entity;
import items.Item;

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
    public final void Setup(int w, int s, Optional<Item> i, Optional<Entity> e) {
        this.weightLimit = w;
        this.snowLevel = s;
        i.ifPresent(value -> this.item = value);
        e.ifPresent(value -> entities.add(value));
    }

    //Visszaadja a fielden lévő itemet
    public Item getItem(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return item;
    }


    //Iglu építése
    @Override
    public boolean buildIgloo() {
        return false;
    }

    @Override
    public boolean buildTent() {
        return false;
    }

    public void removeItem() {
        item = null;
    }


    }
