package entities;

//import enums.Direction;
import fields.Field;
import scene.GameController;
import scene.writer.SceneWriter;

public class ArcticExplorer extends Player {

    public ArcticExplorer() {
        maxHealthPoints = 4;
        healthPoints = maxHealthPoints;
    }

    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("K");
    }

    //Mozgatás.
    @Override
    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Játékos áthelyezése másik mezőre.
//        fieldUnder.placePlayerToNextField(Direction.UP, this);
    }

    //Speciális képesség használata.
    @Override
    public void specialPower() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Stabilitás vizsgálat.
//        fieldUnder.checkStability(Direction.UP);
        /*
        * Itt valahogyan ki kell majd jelezni, a visszatérési értéket.
        * */
    }
}
