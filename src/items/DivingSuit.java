package items;

import game.GameController;

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

    /**
     * A búvárruhához tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public String GetTexturePath() {
        return "textures/item_textures/suit.png";
    }
}
