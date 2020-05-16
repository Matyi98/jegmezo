package entities;

import fields.Field;
import game.GameController;
import utility.ITextured;

/**
 * Entitás osztály. Minden karakter ősosztálya, ami képes mozogni a pályán vagy
 * interakcióba lépni a pályával vagy egymással.
 */
public abstract class Entity implements ITextured {

    /**
     * A mezőn, amelyen az entitás áll.
     */
    protected Field fieldUnder;

    /**
     * Referencia a GameContoller-re.
     */
    protected GameController gameController;

    /**
     * Irány, amerre az entitás néz.
     */
    protected int actualDirection = 0;

    /**
     * Automata névgeneráláshoz szükséges.
     */
    protected static char autoIncrement = 'A';

    /**
     * Entitás neve.
     */
    protected String name;

    /**
     * Reseteli a kezdő egyedi azonosítót.
     */
    public static void resetAutoIncrement(){
        autoIncrement = 'A';
    }
    /**
     * Megjelenítésért felelős függvény.
     */
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

    /**
     * Default konstruktor
     */
    public Entity(){
        name = String.valueOf(autoIncrement);
        ++autoIncrement;
    }

    /**
     * Entitás nevének lekérdezése.
     * @return entitás neve.
     */
    public String getName(){
        return name;
    }

    /**
     * Lyukban áll-e az entitás.
     * @return
     */
    public boolean isInHole()
    {
        return fieldUnder.checkStability() == "Hole";

    }

    /**
     * Entitás léptetése.
     */
    public void step(){

    }

    /**
     * Entitás fullasztása.
     */
    public void makeDrown() {

    }

    /**
     * Entitás szárazföldre léptetése.
     */
    public void makeWalk() {

    }

    /**
     * Entitás megölése
     */
    public void die(){

    }

    /**
     * Az Entityt forgatja a körülötte lévő szomszédos mezők irányába.
     * @param directionDelta forgatás mértéke. Negatív esetén balra forgatás,
     *                       pozitív előjel esetén jobbra.
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

    /**
     * Entitás mozgatása az előtte (actualDirection irányába) lévő mezőre.
     */
    public void move() {
        fieldUnder.placeEntityToNextField(actualDirection, this);
        GameController.OutStream.println(getName() + " successful move: " + fieldUnder.GetUID());
        this.actualDirection = 0;
    }

    /**
     * Entitás körének kezdetén történő viselkedés.
     */
    public abstract void startTurn();

    /**
     * Entitás körének végén történő viselkedés.
     */
    public abstract void endTurn();

    /**
     * Interakcióba lép egy másik entitással.
     * @param otherEntity másik entitás.
     */
    public void collideWith(Entity otherEntity){

    }

    /**
     * Megváltoztatja az entitás alatt lévő mezőt.
     * @param newField új mező, amely az entitás alá kerül.
     */
    public void changeField(Field newField)
    {
        this.fieldUnder = newField;
    }

    /**
     * Entitás életerejének csökkentése.
     */
    public abstract void decrementHP();

}
