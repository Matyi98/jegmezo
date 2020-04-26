package items;

import scene.GameController;

/**
 * Ásó item. Egyszerre sok hó eltakarítására képes.
 */
public class Shovel extends Item {
    /**
     * Hómennyiség, amit egy használattal eltakarít.
     */
    private int shovelSpeedIncrease = 2;

    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Shovel picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("Shovel");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("s"); }

    /**
     * Lapát használata.
     */
    public void use(){
        owner.shovel(shovelSpeedIncrease);
    }


}
