package items;
import player.Player;

public abstract class Item {

    protected Player owner;

    public abstract void use();

    public boolean setOwner(Player owner){
        this.owner = owner;
        return false;
    }
}
