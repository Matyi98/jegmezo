package fields;

import entities.Entity;
import entities.Player;
import items.Item;

//A Pálalya szélét reprezentáló mező.
public class OceanField extends Field {

    @Override
    public void Setup(int w, int s, Item i, Entity e) {
        //????????????????????????
    }

    //Játékos befogadása a mezőre.
    @Override
    public boolean acceptPlayer(Player player) {
        //Minden játékost elutasít, mert a pálya széle.
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("A jatekos befogadasa sikertelen. ");
        return false;
    }

    @Override
    public boolean buildIgloo(){
        //Nem lehet rá Iglut építeni.
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return false;
    }

    @Override
    public String checkStability() {
        //A mező stabilitása.
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return "Ocean";
    }


}
