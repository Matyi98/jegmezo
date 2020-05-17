package entities;

import game.GameController;
import javafx.scene.control.Alert;
import utility.Dialog;

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
            if (Dialog.AllowGUI) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("A kutatás eredménye");
                alert.setHeaderText(null);
                alert.setContentText("Stability of neighbor " + actualDirection + " : " + stability);
                alert.showAndWait();
            }
            actionPoints--;
        }
    }

    @Override
    public String GetTexturePath() {
        return "textures/entity_textures/arcticExplorer.png";
    }
}
