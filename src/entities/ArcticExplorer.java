package entities;

import game.GameController;

/**
 * Sarkkutató, amelyet a játékos irányíthat. Képes megnézni a jégtáblák stabilitását.
 */
public class ArcticExplorer extends Player {

    /**
     * Default konstructor
     */
    public ArcticExplorer() {
        maxHealthPoints = 4;
        healthPoints = maxHealthPoints;
    }

    /**
     * Megjelenítéshez szükséges
     */
    @Override
    public void ShowShort() {
        GameController.OutStream.print("K");
    }

    /**
     * Sarkkutató speciális képességének meghívása. Megnézi, hogy az előtte (actualDirection irányában)
     * lévő mezőnek mennyi a stabilitása.
     */
    @Override
    public void specialPower() {
        if(actionPoints != 0) {
            String stability = fieldUnder.checkStability(actualDirection);
            GameController.OutStream.println("Stability of neighbor " + actualDirection + " : " + stability);
            actionPoints--;
        }
    }

    @Override
    public String GetTexturePath() {
        return null;
    }
}
