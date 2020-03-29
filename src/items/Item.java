package items;
import player.Player;

public abstract class Item {

    protected Player owner;

    public abstract void use();

    public boolean setOwner(Player owner){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        this.owner = owner;
        return false;
    }
}
