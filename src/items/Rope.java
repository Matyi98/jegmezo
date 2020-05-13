package items;

import scene.GameController;

/**
 * Kötél item. Segítségével ki lehet húzni más játékosokat egy Hole típusú Field-ből.
 */
public class Rope extends Item {

    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Rope picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("Rope");
    }
    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() {
        GameController.OutStream.print("r");
    }

    /**
     * Item használata.
     */
    public void use() {
        owner.rescueFriend();
    }

    @Override
    public String GetTexturePath() {
        return "textures/item_textures/rope.png";
    }
}
