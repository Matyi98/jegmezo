package items.quest;

import game.GameController;

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

    /**
     * A patronhoz tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public String GetTexturePath() {
        return "textures/item_textures/patron.png";
    }
}
