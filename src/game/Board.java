package game;

import fields.Field;
import javafx.scene.control.Alert;
import localization.Language;
import utility.Dialog;
import utility.RandomNumber;
import utility.ITextured;
import views.scenes.mainWindow.GameScene;

import java.util.*;

/**
 * A játéktábla, amely a játékmenet összes Field-jét tartalmazza.
 */
public class Board {
    /**
     * Field-ek.
     */
    private ArrayList<Field> fields;

    /**
     * Visszaadja az adott indexen lévő mezőt.
     * @param i mező UID
     * @return mező az adott UID-del
     */
    public Field getField(int i){
        return fields.get(i);
    }

    /**
     * Field-ek beállítása.
     * @param fields fieldek.
     */
    public void Setup(ArrayList<Field> fields) {
        this.fields = fields;
    }

    /**
     * Tábla megjelenítése egy gráf formájában.
     * @param showEdges True - Field-ek megjelenítése (pontok)
     *                  False - Field-ek és hozzájuk tartozó szomszédok (élek) megjelenítése
     */
    public void Show(boolean showEdges) {
        ArrayList<String> pairs = new ArrayList<>();
        fields.sort(new Comparator<Field>() {
            @Override
            public int compare(Field t1, Field t2) {
                return t1.GetUID() - t2.GetUID();
            }
        });

        for (int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            f.Show();
            GameController.OutStream.print("; ");

            ArrayList<Field> neighbours = f.GetNeighbours();
            int myIndex = f.GetUID();
            for (Field fi : neighbours) {
                int ni = fi.GetUID();
                if (ni > myIndex)
                    pairs.add(Integer.toString(myIndex) + " " + Integer.toString(ni) + "; ");
            }
        }
        GameController.OutStream.println();

        if (showEdges) {
            for (String si : pairs)
                GameController.OutStream.print(si);
            GameController.OutStream.println();
        }
    }

    /**
     * Adott Field megváltoztatása egy másik Field-é.
     * @param currentField kiválasztott Field.
     * @param newField új Field.
     */
    public void changeField(Field currentField, Field newField) {
        Collections.replaceAll(this.fields, currentField, newField);
    }

    /**
     * Havazás esélye.
     */
    private double chanceOfSnowing = 10; // ennyi% hogy esik-e a hó
    /**
     * Hóvihar elindítása.
     */
    public void letItSnow() {
        GameScene.UpdateAllViews();
        if (Dialog.AllowGUI) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(Language.Selected().BlizzardShort());
            alert.setHeaderText(null);
            alert.setContentText(Language.Selected().BlizzardLong());
            alert.showAndWait();
        }

        chanceOfSnowing += 5;
        if (chanceOfSnowing < 70) chanceOfSnowing = 70;

        for (Field field : fields) {
            if (RandomNumber.getNumber(100) < chanceOfSnowing) {
                field.performSnow();
            }
        }
    }

    /**
     * Entitások léptetése.
     */
    public void stepEntities() {
        for (Field field : fields) {
            field.step();
        }

        for (Field field : fields) {
            field.endEntitiesTurn();
        }
    }

}
