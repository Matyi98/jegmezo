package items;

import entities.Player;
import scene.writer.SceneWriter;

import java.util.ArrayList;
import java.util.List;

//A játékos inventoryját megvalósító osztály
public class Inventory {
    /**
     * Maximum item-ek száma az inventory-ban
     */
    private final int maxItemCount = 6;
    /**
     * Invetory tulajdonosa
     */
    private Player owner;
    /**
     * Inventory-ban tárolt elemek
     */
    List<Item> items = new ArrayList<>();

    //Létrehoz egy új inventoryt és beállítja a tulajdonosát.
    public Inventory(Player owner) {
        this.owner = owner;
    }

    //Referencia alapján távolít el egy itemet az inventoryból.
    public void removeSpecificItem(Item item){
        items.remove(item);
    }

    //Új Item felvétele
    public boolean add(Item newItem) {
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
            SceneWriter.OutStream.println("Inventory full");
            return false;
        }
    }

    //Adott indexen lévő Item használata.
    public void useItem(int itemIndex) {
        if (itemIndex >= items.size() || itemIndex < 0)
            SceneWriter.OutStream.println("Invaild item index");
        else
             items.get(itemIndex).use();
    }

    /**
     * Megjeleníti az inventory tartalmát.
     */
    public void Show() {
        if (items.size() == 0)
            SceneWriter.OutStream.println("Inventory empty");
        else {
            SceneWriter.OutStream.println("Inventory:");
            int j = 0;
            for (Item i : items) {
                SceneWriter.OutStream.print(j);
                SceneWriter.OutStream.print(": ");
                i.Show();
                SceneWriter.OutStream.println();
                j++;
            }
        }
    }


}
