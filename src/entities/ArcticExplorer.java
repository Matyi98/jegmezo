package entities;

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


    @Override
    public void specialPower() {
        if(actionPoints != 0) {
            String stability = fieldUnder.checkStability(actualDirection);
            SceneWriter.OutStream.println("Stability of neighbor " + actualDirection + " : " + stability);
            actionPoints--;
        }
    }
}
