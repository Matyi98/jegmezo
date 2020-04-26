package entities;

//import enums.Direction;

import scene.GameController;


public class Eskimo extends Player {

    public Eskimo() {
        maxHealthPoints = 5;
        healthPoints = maxHealthPoints;
    }

    @Override
    public void ShowShort() {
        GameController.OutStream.print("E");
    }


    //Eszkimó speciális képessége.
    @Override
    public void specialPower() {
        //iglut épít.
        if(actionPoints != 0)
        {
            if (fieldUnder.buildIgloo()) {
                actionPoints--;
            }
        }
    }
}
