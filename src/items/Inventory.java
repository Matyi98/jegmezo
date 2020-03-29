package items;

import player.Player;
import java.util.List;

public class Inventory {
    private int maxItemCount;
    private Player owner;
    List<Item> items;

    public Inventory() {

    }

    public Inventory(Player owner) {
        this.owner = owner;
    }


    public void removeByIndex(int itemIndex){
        items.remove(itemIndex);
    }

    public void removeSpecificItem(Item item){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        items.remove(item);
    }

    public boolean add(Item newItem) {
        return false;
    }

    public void useItem(int itemIndex){
        items.get(itemIndex).use();
    }
}
