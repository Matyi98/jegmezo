package player;

import enums.Direction;
import fields.Field;

public class ArcticExplorer extends Player {

    public ArcticExplorer() {
        super(4);
    }

    public ArcticExplorer(Field underPlayer) {
        fieldUnderPlayer = underPlayer;
    }

    @Override
    public void specialPower() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        fieldUnderPlayer.checkStability(Direction.UP);
    }
}
