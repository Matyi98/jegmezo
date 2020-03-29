package player;

import enums.Direction;
import fields.Field;
import main.GameController;

public class Eskimo extends Player {

    public Eskimo() {
        super(4);
    }

    public Eskimo(Field fieldUnderPlayer) {
        super(fieldUnderPlayer, 5);
    }

    public Eskimo(GameController gc, Field f) {
        super(gc, f);
    }

    @Override
    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        fieldUnderPlayer.placePlayerToNextField(Direction.UP, this);
    }

    @Override
    public void specialPower() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        fieldUnderPlayer.buildIgloo();
    }
}
