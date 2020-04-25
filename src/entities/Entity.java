package entities;

import fields.Field;
import scene.GameController;
import scene.writer.SceneWriter;

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

    public void decrementHP(){

    }

    /**
     * Az Entityt forgatja a körülötte lévő szomszédos mezők irányába.
     * @param directionDelta 'A' betű lenyomására -1, 'D' betű lenyomására +1
     * paraméterrel hívja a kontroller.
     */
    public void turn(int directionDelta){

        int maxTurableDirectionCount = fieldUnder.getNeighbourCount() - 1;

        actualDirection += directionDelta;

        if(actualDirection < 0)
            actualDirection = maxTurableDirectionCount;
        else if (actualDirection > maxTurableDirectionCount)
            actualDirection = 0;
    }

    public void move(){
        fieldUnder.placeEntityToNextField(actualDirection);
    }

    public void collideWith(Entity otherEntity){

    }



}
