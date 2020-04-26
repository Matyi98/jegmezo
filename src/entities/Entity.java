package entities;

import fields.Field;
import scene.GameController;

public abstract class Entity {

    protected Field fieldUnder;

    protected GameController gameController;
    protected int actualDirection = 0;

    private static char autoIncrement = 'A';
    protected String name;

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

    public Entity(){
        name = String.valueOf(autoIncrement);
        ++autoIncrement;
    }

    public String getName(){
        return name;
    }

    public void step(){

    }

    public void makeDrown() {

    }

    public void makeWalk() {

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

        GameController.OutStream.println(getName() + " successful turn: " + fieldUnder.GetNeighbours().get(actualDirection).GetUID());
    }

    public void move() {
        fieldUnder.placeEntityToNextField(actualDirection, this);
        GameController.OutStream.println(getName() + " successful move: " + fieldUnder.GetUID());
        this.actualDirection = 0;
    }

    public void collideWith(Entity otherEntity){

    }

    public void changeField(Field newField)
    {
        this.fieldUnder = newField;
    }

    public abstract void decrementHP();
}
