package entities;

import fields.Field;
import scene.GameController;

import java.util.Random;

public class Bear extends Entity {


    @Override
    public void step() {
        int randomDirection = new Random().nextInt(fieldUnder.getNeighbourCount());
        actualDirection = randomDirection;
        move();
        fieldUnder.destroyTent();
    }

    @Override
    public void ShowShort() {
        GameController.OutStream.print("M");
    }

    @Override
    public void collideWith(Entity otherEntity) {
        otherEntity.die();
    }

    @Override
    public void decrementHP() {

    }

    public void startTurn()
    {

    }

    public  void endTurn()
    {

    }

}
