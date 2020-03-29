package items;

import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int maxItemCount = 6;
    private Player owner;
    List<Item> items = new ArrayList<>();

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
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        if(maxItemCount-items.size() > 0) {
            items.add(newItem);
            newItem.setOwner(owner);
            return true;
        } else {
            System.out.println("Inventory full");
            return false;
        }
    }

    public void useItem(int itemIndex){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        items.get(itemIndex).use();
    }
}
