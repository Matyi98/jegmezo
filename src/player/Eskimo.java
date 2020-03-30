package player;

import enums.Direction;
import fields.Field;
import main.GameController;

public class Eskimo extends Player {

    public Eskimo() {
        super(5);
    }

    public Eskimo(Field fieldUnderPlayer) {
        super(fieldUnderPlayer, 5);
    }

    public Eskimo(GameController gc, Field f) {
        super(gc, f);
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
