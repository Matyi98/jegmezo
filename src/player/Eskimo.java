package player;

import enums.Direction;
import fields.Field;
import main.GameController;

public class Eskimo extends Player {

    public Eskimo(GameController gc, Field f) {
        super(gc, f);
        maxHealthPoints = 5;
        healthPoints = maxHealthPoints;
    }

    //Eszkimó mozog.
    @Override
    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Mozgatás.
        fieldUnderPlayer.placePlayerToNextField(Direction.UP, this);
    }

    //Eszkimó speciális képessége.
    @Override
    public void specialPower() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //iglut épít.
        fieldUnderPlayer.buildIgloo();
    }
}
