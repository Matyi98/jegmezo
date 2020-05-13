package scene;

import fields.Field;
import main.RandomNumber;
import utility.ITextured;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A játéktábla, amely a játékmenet összes Field-jét tartalmazza.
 */
public class Board implements ITextured{
    /**
     * Field-ek.
     */
    private ArrayList<Field> fields;

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
        this.fields.remove(currentField);
        this.fields.add(newField);
    }

    /**
     * Hóvihar elindítása.
     */
    public void letItSnow() {
        int chanceOfSnowing = 4; // 40% hogy esik-e a hó

        for (Field field : fields) {
            if (RandomNumber.getNumber(10) < chanceOfSnowing) {
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

    @Override
    public String GetTexturePath() {
        return null;
    }
}
