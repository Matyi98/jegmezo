package fields;

import enums.Direction;
import player.Player;

public class UnstableIceField extends IceField{
    private int stability;

    @Override
    public boolean buildIgloo(){
        return false;
    }

    @Override
    public boolean acceptPlayer(Player player) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        players.add(player);
        return true;
    }

    @Override
    public String checkStability() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return "Unstable";
    }


    @Override
    public boolean placePlayerToNextField(Direction direction, Player player){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        Field neighbour = neighbors.get(direction);
        neighbour.acceptPlayer(player);
        return false;
    }
}
