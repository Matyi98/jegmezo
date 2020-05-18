package items.quest;

import game.GameController;
import javafx.scene.image.Image;
import utility.TurboTextureLoader;

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
    public Image GetTexturePath() {
        return TurboTextureLoader.GetItemTexture(TurboTextureLoader.ItemTextures.patron);
    }
}
