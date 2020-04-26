package items;
import entities.Player;

public abstract class Item {

    /**
     * Az item tulajdonosa
     */
    protected Player owner;

    //Item használata.
    public abstract void use();

    /*
        Beállítja az eszköz tulajdonosát,
        ha QuestItem, akkor jelez a gameControllernek, hogy találtak új questItemet.
    */
    public boolean setOwner(Player owner) {
        showPickup();
        this.owner = owner;
        return false;
    }

    protected abstract void showPickup();
    public abstract void Show();
    public abstract void ShowShort();
}
