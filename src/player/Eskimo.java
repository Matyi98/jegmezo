package player;

import enums.Direction;
import fields.Field;

public class Eskimo extends Player {

    public Eskimo() {
        super(4);
    }

    public Eskimo(Field fieldUnderPlayer) {
        super(fieldUnderPlayer, 5);
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
