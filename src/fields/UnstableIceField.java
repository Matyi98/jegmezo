package fields;

import enums.Direction;
import player.Player;

public class UnstableIceField extends IceField{
    private int stability;

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
        players.add(player);
        return true;
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //A stabilitását adja vissza.
        return String.valueOf(stability);
    }

    //Játékos átadása a aszomszd mezőnek, a megadott irányba.
    @Override
    public boolean placePlayerToNextField(Direction direction, Player player){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Szomszéd mező lekérése.
        Field neighbour = neighbors.get(direction);
        //Átadás a szomszédnak.
        neighbour.acceptPlayer(player);
        return false;
    }
}
