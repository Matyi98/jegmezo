package items;

import scene.GameController;

/**
 * Búvárruha item. Lehetővé teszi, hogy fulladás nélkül
 * Hole típusú Field-ekre léphessenek a Player-ek.
 */
public class DivingSuit extends Item {

    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("DivingSuit picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("DivingSuit");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("d"); }

    /**
     * Búvárruha használata.
     */
    @Override
    public void use() {
        this.owner.swapDivingSuit();
    }
}
