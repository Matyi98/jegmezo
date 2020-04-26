package items.quest;

import scene.GameController;

/**
 * Egyik összegyűjtendő QuestItem.
 */
public class Cartridge extends QuestItem {
    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Cartridge picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("Cartridge");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("c"); }
}
