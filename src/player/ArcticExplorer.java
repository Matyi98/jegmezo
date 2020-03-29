package player;

import enums.Direction;
import fields.Field;

public class ArcticExplorer extends Player {

    public ArcticExplorer() {
        super(4);
    }

    public ArcticExplorer(Field fieldUnderPlayer) {
        super(fieldUnderPlayer, 4);
    }

    @Override
    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        fieldUnderPlayer.placePlayerToNextField(Direction.UP, this);
    }

    @Override
    public void specialPower() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        fieldUnderPlayer.checkStability(Direction.UP);
    }
}
