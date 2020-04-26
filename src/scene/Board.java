package scene;

import fields.Field;
import main.RandomNumber;

import java.util.ArrayList;
import java.util.Comparator;

public class Board {
    private ArrayList<Field> fields;

    public void Setup(ArrayList<Field> fields) {
        this.fields = fields;
    }

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

    public void changeField(Field currentField, Field newField) {
        this.fields.remove(currentField);
        this.fields.add(newField);
    }

    //Behavaztat mezőket.
    public void letItSnow() {
        int chanceOfSnowing = 4; // 40% hogy esik-e a hó

        for (Field field : fields) {
            if (RandomNumber.getNumber(10) < chanceOfSnowing) {
                field.snow();
            }
        }
    }

    public void stepEntities() {
        for (Field field : fields) {
            field.step();
        }

        for (Field field : fields) {
            field.endEntitiesTurn();
        }
    }
}
