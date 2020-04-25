package entities;

import fields.Field;
import scene.GameController;

import static java.lang.StrictMath.abs;

public abstract class Entity {

    protected Field fieldUnder;

    protected GameController gameController;
    protected int actualDirection;

    public abstract void ShowShort() ;

    /**
     * Beállítja az entitás kezdőállapotát.
     * @param gc A GameController.
     * @param f A mező, amin a játékos áll.
     */
    public final void Setup(GameController gc, Field f) {
        this.gameController = gc;
        this.fieldUnder = f;
    }

    public void step(){

    }

    public void drown() {

    }

    public void walk() {

    }

    public void die(){

    }

    /**
     * Az Entityt forgatja a körülötte lévő szomszédos mezők irányába.
     * @param directionDelta 'A' betű lenyomására -1, 'D' betű lenyomására +1
     * paraméterrel hívja a kontroller.
     */
    public final void turn(int directionDelta){

        int numOfIndices = fieldUnder.getNeighbourCount();

        actualDirection += directionDelta;

        if(actualDirection < 0)
            actualDirection = actualDirection % numOfIndices + numOfIndices;
        else if(actualDirection >= numOfIndices)
            actualDirection = actualDirection % numOfIndices;

    }

    public void move(){
        fieldUnder.placeEntityToNextField(actualDirection, this);
    }

    public void collideWith(Entity otherEntity){

    }

    public abstract void decrementHP();
}
