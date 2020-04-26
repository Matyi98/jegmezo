package items;
import entities.Player;

/**
 * Item, amelyet a Player használhat.
 */
public abstract class Item {

    /**
     * Az item tulajdonosa.
     */
    protected Player owner;

    /**
     * Item használata.
     */
    public abstract void use();

    /**
     * Item tulajdonosának beállítása.
     * @param owner tulajdonos.
     * @return Az adott Item, az QuestItem.
     */
    public boolean setOwner(Player owner) {
        showPickup();
        this.owner = owner;
        return false;
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    protected abstract void showPickup();

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public abstract void Show();

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public abstract void ShowShort();
}
