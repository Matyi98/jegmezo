package fields;

import entities.Entity;
import items.Item;
import entities.Player;

public class StableIceField extends IceField{

    /**
     * Inicializálja a mező kezdőállapotát.
     * @param w A mező által elbírt entitások száma.    Ignorált, hiszen stabil.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.
     */
    public void Setup(int w, int s, Item i, Entity e) {
        snowLevel = s;
        item = i;
        //TODO: entity
    }

    public StableIceField(){
        super();
    }

    @Override
    public void Show() {

    }

    //Mezőn tárolt tárgy beállíítása.
    public void setItem(Item item){
        this.item = item;
    }

    //Játékos befogadása a mezőre.
    @Override
    public boolean acceptEntity(Entity entity) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikeres a jatekos befogadasa");
        //Felvétel a belső Player listára.
        entities.add(entity);
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
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikeres iglu epites. ");
        return true;
    }

    @Override
    public boolean buildTent() {
        return false;
    }

    public Item getItem(){ return item;}
}
