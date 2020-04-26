package items;

import scene.GameController;

/**
 * Sátor item. Bármelyik IceField-re ráépíthető. Adott körben megvéd a hóvihartól,
 * új kör kezdetén elpusztul. Medvétől nem véd meg.
 */
public class Tent extends Item {
    /**
     * Sátor megépítése.
     */
    @Override
    public void use() {
        owner.buildTent(this);
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Tent picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("Tent");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("t"); }
}
