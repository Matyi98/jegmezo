package entities;

import main.RandomNumber;
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
     * 
     * @param otherEntity
     */
    @Override
    public void collideWith(Entity otherEntity) {
        otherEntity.die();
    }

    @Override
    public void decrementHP() {

    }

    public void startTurn() {

    }

    public void endTurn() {
        hasStepped = false;
    }

}
