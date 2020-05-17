package entities;

import game.GameController;
import javafx.scene.control.Alert;
import localization.Language;
import utility.Dialog;

/**
 * Sarkkutató, amelyet a játékos irányíthat. Képes megnézni a jégtáblák stabilitását.
 */
public class ArcticExplorer extends Player {

    private final int ID;
    /**
     * Default konstructor
     */
    public ArcticExplorer() {
        super();
        ID = autoIncrementID++;
        maxHealthPoints = 4;
        healthPoints = maxHealthPoints;
    }

    @Override
    public String getFancyName() {
        return Language.Instance().ExplorerName(ID);
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
                alert.setTitle(Language.Instance().ResearchMSG());
                alert.setHeaderText(null);
                alert.setContentText(Language.Instance().ResearchMSG() + ": " + stability);
                alert.showAndWait();
            }
            actionPoints--;
        }
    }

    /**
     * A sarkkutatóhoz tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public String GetTexturePath() {
        return "textures/entity_textures/arcticExplorer.png";
    }
}
