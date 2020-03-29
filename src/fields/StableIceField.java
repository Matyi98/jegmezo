package fields;

import enums.Direction;
import items.Item;
import player.Player;

public class StableIceField extends IceField{

    public StableIceField(){
        super();
    }

    public StableIceField(Item i) {
        super();
        item = i;
    }

    @Override
    public boolean acceptPlayer(Player player) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return true;
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
    public boolean buildIgloo(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return true;
    }

    @Override
    public boolean changeSnowLevel(int delta){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return false;
    }

}
