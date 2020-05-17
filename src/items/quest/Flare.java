package items.quest;

import game.GameController;

/**
 * Egyik összegyűjtendő QuestItem.
 */
public class Flare extends QuestItem {
    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Flare picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("Flare");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("e"); }

    /**
     * A jelzőfényhez tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public String GetTexturePath() {
        return "textures/item_textures/flare.png";
    }
}
