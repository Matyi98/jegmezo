package items;

import game.GameController;
import javafx.scene.image.Image;
import utility.TurboTextureLoader;

/**
 * Étel item. Életerejét növelheti a Player, ha megeszi.
 */
public class Food extends Item {
    /**
     * Kalóriaszint, ami azt jelzi, hogy hány életerőpontot ér a játékos számára.
     */
    int calorieLevel = 1;

    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("Food picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("Food");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("f"); }

    /**
     * Megeszi az ételt.
     */
    @Override
    public void use(){
        owner.eat(this);
    }

    /**
     * Az ételhez tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public Image GetTexturePath() {
        return TurboTextureLoader.GetItemTexture(TurboTextureLoader.ItemTextures.food);
    }
}
