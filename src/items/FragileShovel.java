package items;

import game.GameController;

/**
 * Törékeny ásó item. Adott számú használat után eltörik.
 * Egyszerre sok havat lehet vele eltakarítani.
 */
public class FragileShovel extends Item {

    /**
     * Lehetséges használatok száma.
     */
    private int durability = 3;

    /**
     * Hómennyiség, amelyet egy használattal eltakarít.
     */
    private int shovelSpeedIncrease = 2;

    /**
     * Megjelenítéshez szükséges függvény.
     */
    @Override
    protected void showPickup() {
        GameController.OutStream.println("FragileShovel picked up");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void Show() {
        GameController.OutStream.print("FragileShovel");
    }

    /**
     * Megjelenítéshez szükséges függvény.
     */
    public void ShowShort() { GameController.OutStream.print("g"); }

    /**
     * Törékeny ásó használata.
     */
    @Override
    public void use() {
        owner.shovel(shovelSpeedIncrease);
        --durability;
        if(durability == 0)
            owner.removeItem(this);
    }

    /**
     * A törékeny ásóhoz tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public String GetTexturePath() {
        return "textures/item_textures/fragile_shovel.png";
    }
}
