package items;

import entities.Player;
import game.GameController;

import java.util.ArrayList;
import java.util.List;

/**
 * A Player-ek táskája. Benne adott számú Item tárolható.
 */
public class Inventory {
    /**
     * Maximum item-ek száma az inventory-ban.
     */
    private final int maxItemCount = 6;
    /**
     * Invetory tulajdonosa.
     */
    private Player owner;
    /**
     * Inventory-ban tárolt elemek.
     */
    List<Item> items = new ArrayList<>();

    /**
     * Inventory létrehozása egy adott tulajdonos számára.
     * @param owner tulajdonos.
     */
    public Inventory(Player owner) {
        this.owner = owner;
    }

    /**
     * Referencia alapján távolít el egy itemet az inventoryból.
     * @param item Item referenciája amelyet eltávolítunk.
     */
    public void removeSpecificItem(Item item){
        items.remove(item);
    }

    /**
     * Item hozzáadása az Inventory-hoz.
     * Ha tele van, akkor nem adható hozzá több Item.
     * @param newItem új Item referenciája.
     * @return sikeres hozzáadás.
     */
    public boolean add(Item newItem) {
        if(maxItemCount-items.size() > 0) {
            items.add(newItem);
            newItem.setOwner(owner);
            return true;
        } else {
            GameController.OutStream.println("Inventory full");
            return false;
        }
    }

    /**
     * Adott indexen található Item használata.
     * @param itemIndex Item indexe.
     */
    public void useItem(int itemIndex) {
        if (itemIndex >= items.size() || itemIndex < 0)
            GameController.OutStream.println("Invaild item index");
        else
             items.get(itemIndex).use();
    }

    /**
     * Megjeleníti az inventory tartalmát.
     */
    public void Show() {
        if (items.size() == 0)
            GameController.OutStream.println("Inventory empty");
        else {
            GameController.OutStream.println("Inventory:");
            int j = 0;
            for (Item i : items) {
                GameController.OutStream.print(j);
                GameController.OutStream.print(": ");
                i.Show();
                GameController.OutStream.println();
                j++;
            }
        }
    }


}
