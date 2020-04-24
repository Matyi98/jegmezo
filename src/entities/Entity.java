package entities;

import fields.Field;
import scene.GameController;

public  class Entity {

    protected Field fieldUnder;
    protected int maxHealthPoints;
    protected int healthPoints;
    protected GameController gameController;

    /**
     * Beállítja az entitás kezdőállapotát.
     * @param gc A GameController.
     * @param f A mező, amin a játékos áll.
     */
    public final void Setup(GameController gc, Field f) {
        this.gameController = gc;
        this.fieldUnder = f;
    }

}
