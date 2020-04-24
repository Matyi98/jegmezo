package entities;

import enums.Direction;
import fields.Field;
import scene.GameController;

public class ArcticExplorer extends Player {

    public ArcticExplorer() {

    }

    public ArcticExplorer(GameController gc, Field f) {
        super(gc, f);
        maxHealthPoints = 4;
        healthPoints = 4;
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
