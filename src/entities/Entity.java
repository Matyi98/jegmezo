package entities;

import fields.Field;
import scene.GameController;

public abstract class Entity {

    protected Field fieldUnder;
    protected int maxHealthPoints;
    protected int healthPoints;
    protected GameController gameController;
    protected int actualDirection;


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

    public void decrementHP(){
        --healthPoints;
    }

    public void drown() {

    }

    public void walk() {

    }

    public void die(){

    }

    public void turn(int index){
        actualDirection = index;
    }

    public void move(){
        fieldUnder.placePlayerToNextField(actualDirection);
    }

    public void collideWith(Entity otherEntity){

    }



}
