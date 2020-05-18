package items;

import game.GameController;
import javafx.scene.image.Image;
import utility.TurboTextureLoader;

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

    /**
     * A kötélhez tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public Image GetTexturePath() {
        return TurboTextureLoader.GetItemTexture(TurboTextureLoader.ItemTextures.rope);
    }
}
