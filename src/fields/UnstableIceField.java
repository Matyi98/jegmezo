package fields;

import entities.Entity;

import entities.Player;
import items.Item;

public class UnstableIceField extends IceField{
    private int stability;

    @Override
    public void Show() {

    }

    /**
     * Inicializálja a mező kezdőállapotát.
     * @param w A mező által elbírt entitások száma.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.
     */
    public void Setup(int w, int s, Item i, Entity e) {
        stability = w;
        snowLevel = s;
        item = i;
        //TODO: entity
    }

    //Iglu építése.
    @Override
    public boolean buildIgloo(){
        //Instabil mezőre ne lehet építeni Iglut.
        return false;
    }

    //Jáékos befogadása a mezőre.
    @Override
    public boolean acceptPlayer(Player player) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikeres a jatekos befogadasa");
        players.add(player);
        return true;
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        stability = 3;
        System.out.println("sikeres stabilitás vizsgálat: unstableIceField: "+stability);
        //A stabilitását adja vissza.
        return String.valueOf(stability);
    }

    //Játékos átadása a aszomszd mezőnek, a megadott irányba.
    @Override
    public boolean placePlayerToNextField(int direction, Player player){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Szomszéd mező lekérése.
        Field neighbour = neighbors.get(direction);
        //Átadás a szomszédnak.
        neighbour.acceptPlayer(player);
        return false;
    }
}
