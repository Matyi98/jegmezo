package fields;

import player.Player;

public class Hole extends Field {
    @Override
    public boolean acceptPlayer(Player player) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikertelen a jatekos befgoadasa.");
        players.add(player);
        return true;
    }

    @Override
    public boolean buildIgloo() {
        return false;
    }

    @Override
    public String checkStability() {
        //Megadja a mező stabilitását.
        return "Hole";
    }


}
