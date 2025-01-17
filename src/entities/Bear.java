package entities;

import javafx.scene.image.Image;
import localization.Language;
import utility.RandomNumber;
import game.GameController;
import utility.TurboTextureLoader;

/**
 * Jegesmedve osztály, amely az Entity-ből származik. Ha játékosokkal kerül egy mezőre, akkor megöli őket.
 */
public class Bear extends Entity {
    /**
     * A jelenlegi körben lépett-e a medve.
     */
    boolean hasStepped = false;

    /**
     * A medve léptetése. Átlép egy véletlenül kiválasztott szomszédos mezőre.
     * Ha ezen a mezőn van sátor, akkor elpusztítja.
     */
    @Override
    public void step() {
        if(hasStepped)
            return;

        hasStepped = true;
        actualDirection = RandomNumber.getNumber(fieldUnder.getNeighbourCount());
        move();
        fieldUnder.destroyTent();
    }

    /**
     * Folyamra írja a típusazonosítóját.
     */
    @Override
    public void ShowShort() {
        GameController.OutStream.print("M");
    }

    /**
     * Az entitás hosszú neve nyelvi csomagnak megfelelően.
     * @return hosszú név.
     */
    @Override
    public String getFancyName() {
        return "Maci";
    }

    /**
     * Másik entitással való interakció. A medve próbálja megölni a másik entitást.
     * @param otherEntity Az entitás amellyel interakcióba lép a medve.
     */
    @Override
    public void collideWith(Entity otherEntity) {
        otherEntity.die(Language.Selected().BearDeathMSG());
    }

    /**
     * Itt mutatkozik be a Player a Bearnek. Üvözlés képpen a Bear megöli a Playert.
     * @param player Azon Player, aki rálép arra a mezőre, amelyen ez a Bear tartózkodik.
     */
    public void meetPlayer(Entity player){
        player.die(Language.Selected().BearDeathMSG());
    }

    /**
     * Medvének nincs élete így nem csökkenhet.
     */
    @Override
    public void decrementHP() {

    }

    /**
     * A medve viselkedése új kör kezdetén.
     */
    public void startTurn() {

    }

    /**
     * A medve viselkedése kör végén.
     */
    public void endTurn() {
        hasStepped = false;
    }

    /**
     * A jegesmedvéhez tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public Image GetTexturePath() {
        return TurboTextureLoader.GetEntityTexture(TurboTextureLoader.EntityTextures.bear);
    }
}
