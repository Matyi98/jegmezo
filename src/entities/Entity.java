package entities;

import fields.Field;
import scene.GameController;

public abstract class Entity {

    protected Field fieldUnder;

    protected GameController gameController;
    protected int actualDirection = 0;

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
        int maxTurnableDirectionCount = fieldUnder.getNeighbourCount() - 1;

        actualDirection += directionDelta;

        if(actualDirection < 0)
            actualDirection = maxTurnableDirectionCount;
        else if (actualDirection > maxTurnableDirectionCount)
            actualDirection = 0;

        GameController.OutStream.println("Successful turn: " + fieldUnder.GetNeighbours().get(actualDirection).GetUID());
    }

    public void move() {
        int oldUID = fieldUnder.GetUID();
        fieldUnder.placeEntityToNextField(actualDirection, this);
        GameController.OutStream.println("Successful move: " + fieldUnder.GetUID());
    }

    public void collideWith(Entity otherEntity){

    }

    public void changeField(Field newField)
    {
        this.fieldUnder = newField;
    }

    public abstract void decrementHP();
}
