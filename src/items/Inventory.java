package items;

import player.Player;

import java.util.ArrayList;
import java.util.List;

//A játékos inventoryját megvalósító osztály
public class Inventory {
    //Maximum ennyi item lehet az inventoryban.
    private int maxItemCount = 6;
    //Az inventory tulajdonosa.
    private Player owner;
    //Az inventoryban tráolt itemek száma.
    List<Item> items = new ArrayList<>();

    //Létrehoz egy új inventoryt és beállítja a tulajdonosát.
    public Inventory(Player owner) {
        this.owner = owner;
    }

    //A sorszám alapján kivesz egy itemet az inventoryból.
    public void removeByIndex(int itemIndex){
        items.remove(itemIndex);
    }

    //Referencia alapján távolít el egy itemet az inventoryból.
    public void removeSpecificItem(Item item){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        items.remove(item);
    }

    //Új Item felvétele
    public boolean add(Item newItem) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        //Ha van még hely az inventoryban,
        if(maxItemCount-items.size() > 0) {
            //akkor beleteszi az itemet,
            items.add(newItem);
            //beállítja az Item tulajdonságát,
            newItem.setOwner(owner);
            //és igazzal tér vissza, ezáltal jelezve a playernek, hogy sikeres volt a felvétel.
            return true;
        } else {
            //különben jelez, hogy már tele van.
            System.out.println("Inventory full");
            return false;
        }
    }

    //Adott indexen lévő Item használata.
    public void useItem(int itemIndex){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        items.get(itemIndex).use();
    }
}
