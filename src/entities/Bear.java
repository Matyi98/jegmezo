package entities;

import utility.RandomNumber;
import scene.GameController;

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
     * Megjelenítéshez szükséges.
     */
    @Override
    public void ShowShort() {
        GameController.OutStream.print("M");
    }

    /**
     * Másik entitással való interakció. A medve próbálja megölni a másik entitást.
     * @param otherEntity Az entitás amellyel interakcióba lép a medve.
     */
    @Override
    public void collideWith(Entity otherEntity) {
        otherEntity.die();
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

    @Override
    public String GetTexturePath() {
        return null;
    }
}
