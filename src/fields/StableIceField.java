package fields;

import items.Item;
import player.Player;

public class StableIceField extends IceField{

    public StableIceField(){
        super();
    }

    public StableIceField(Item item) {
        super();
        setItem(item);
    }

    //Mezőn tárolt tárgy beállíítása.
    public void setItem(Item item){
        this.item = item;
    }

    //Játékos befogadása a mezőre.
    @Override
    public boolean acceptPlayer(Player player) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikeres a jatekos befogadasa");
        //Felvétel a belső Player listára.
        players.add(player);
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

}
