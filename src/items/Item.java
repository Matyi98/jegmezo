package items;
import player.Player;

public abstract class Item {

    protected Player owner;

    public abstract void use();

    public boolean setOwner(Player owner){
        return false;
    }
}
