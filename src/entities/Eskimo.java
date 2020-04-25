package entities;

//import enums.Direction;
import fields.Field;
import scene.GameController;
import scene.writer.SceneWriter;

public class Eskimo extends Player {

    public Eskimo() {
        maxHealthPoints = 5;
        healthPoints = maxHealthPoints;
    }

    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("E");
    }

    //Eszkimó mozog.
    @Override
    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Mozgatás.
//        fieldUnder.placePlayerToNextField(Direction.UP, this);
    }

    //Eszkimó speciális képessége.
    @Override
    public void specialPower() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //iglut épít.
        fieldUnder.buildIgloo();
    }
}