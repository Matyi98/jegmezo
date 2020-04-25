package scene;

import fields.Field;
import main.RandomNumber;
import scene.writer.SceneWriter;

import java.util.ArrayList;

public class Board {
    private ArrayList<Field> fields;

    public void Setup(ArrayList<Field> fields) {
        this.fields = fields;
    }

    public void Show(boolean showEdges) {
        ArrayList<String> pairs = new ArrayList<>();

        for (int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            f.Show();
            SceneWriter.OutStream.print("; ");

            ArrayList<Field> neighbours = f.GetNeighbours();
            int myIndex = f.GetUID();
            for (Field fi : neighbours) {
                int ni = fi.GetUID();
                if (ni > myIndex)
                    pairs.add(Integer.toString(myIndex) + " " + Integer.toString(ni) + "; ");
            }
        }
        SceneWriter.OutStream.println();

        if (showEdges) {
            for (String si : pairs)
                SceneWriter.OutStream.print(si);
            SceneWriter.OutStream.println();
        }
    }

    public void changeField(Field currentField, Field newField) {
        this.fields.remove(currentField);
        this.fields.add(newField);
    }

    //Behavaztat mezőket.
    public void letItSnow(RandomNumber rand) {
        int chanceOfSnowing = 4; // 40% hogy esik-e a hó

        for (Field field : fields) {
            if (rand.getNumber(10) > chanceOfSnowing) {
                field.snow();
            }
        }
    }

}
