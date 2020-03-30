package fields;

import enums.Direction;
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

    public void setItem(Item item){
        this.item = item;
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

}
