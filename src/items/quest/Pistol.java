package items.quest;

import scene.GameController;

/**
 * Egyik összegyűjtendő QuestItem.
 */
public class Pistol extends QuestItem {
    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Pistol picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("Pistol");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("p"); }

    @Override
    public String GetTexturePath() {
        return "textures/item_textures/pistol.png";
    }
}
