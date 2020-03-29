package fields;

import enums.Direction;
import player.Player;

public class UnstableIceField extends IceField{
    private int stability;

    public UnstableIceField(){
    }

    public UnstableIceField(Field aboveNeighbor){
        super(aboveNeighbor);
    }

    @Override
    public boolean buildIgloo(){
        return false;
    }

    @Override
    public boolean acceptPlayer(Player player) {
        return false;
    }

    @Override
    public String checkStability() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return "";
    }

    @Override
    public String checkStability(Direction direction) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        Field neighbour = neighbors.get(direction);
        neighbour.checkStability();
        return "";
    }

    @Override
    public boolean changeSnowLevel(int delta){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return false;
    }

    @Override
    public boolean placePlayerToNextField(Direction direction, Player player){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        Field neighbour = neighbors.get(direction);
        neighbour.acceptPlayer(player);
        return false;
    }
}
