package entities;

import fields.Field;
import scene.GameController;

public class ArcticExplorer extends Player {

    public ArcticExplorer() {
        maxHealthPoints = 4;
        healthPoints = maxHealthPoints;
    }

    @Override
    public void ShowShort() {
        GameController.OutStream.print("K");
    }


    @Override
    public void specialPower() {
        if(actionPoints != 0) {
            String stability = fieldUnder.checkStability(actualDirection);
            GameController.OutStream.println("Stability of neighbor " + actualDirection + " : " + stability);
            actionPoints--;
        }
    }
}
