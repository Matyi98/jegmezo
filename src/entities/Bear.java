package entities;

import main.RandomNumber;
import scene.GameController;

public class Bear extends Entity {
    // számon kell tartani hogy ne tudjon egy körben többször lépni.
    boolean hasStepped = false;

    @Override
    public void step() {
        if(hasStepped)
            return;

        hasStepped = true;
        actualDirection = RandomNumber.getNumber(fieldUnder.getNeighbourCount());
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
    public void decrementHP() {}

    public void startTurn() {}

    public  void endTurn() {
        hasStepped = false;
    }

}
