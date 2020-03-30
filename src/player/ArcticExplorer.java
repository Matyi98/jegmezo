package player;

import enums.Direction;
import fields.Field;
import main.GameController;

public class ArcticExplorer extends Player {

    public ArcticExplorer() {
        super(4);
    }

    public ArcticExplorer(GameController gc, Field f) {
        super(gc, f);
    }

    public ArcticExplorer(Field fieldUnderPlayer) {
        super(fieldUnderPlayer, 4);
    }

    //Mozgatás.
    @Override
    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Játékos áthelyezése másik mezőre.
        fieldUnderPlayer.placePlayerToNextField(Direction.UP, this);
    }

    //Speciális képesség használata.
    @Override
    public void specialPower() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Stabilitás vizsgálat.
        fieldUnderPlayer.checkStability(Direction.UP);
        /*
        * Itt valahogyan ki kell majd jelezni, a visszatérési értéket.
        * */
    }
}
