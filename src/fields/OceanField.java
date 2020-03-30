package fields;

import player.Player;

//A Pálalya szélét reprezentáló mező.
public class OceanField extends Field {

    //Játékos befogadása a mezőre.
    @Override
    public boolean acceptPlayer(Player player) {
        //Minden játékost elutasít, mert a pálya széle.
        return false;
    }

    @Override
    public boolean buildIgloo(){
        //Nem lehet rá Iglut építeni.
        return false;
    }

    @Override
    public String checkStability() {
        //A mező stabilitása.
        return "Ocean";
    }


}
