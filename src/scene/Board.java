package scene;

import entities.Entity;
import entities.Player;
import fields.Field;
import main.RandomNumber;
import scene.writer.SceneWriter;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<Field> fields;

    public Board(ArrayList<Field> fields) {
        this.fields = fields;
    }

    public void Show() {
        ArrayList<String> pairs = new ArrayList<>();

        for (int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            f.Show();
            SceneWriter.OutStream.print("; ");

            ArrayList<Field> neighbours = f.GetNeighbours();
            int myIndex = f.GetIndex();
            for (Field fi : neighbours) {
                int ni = fi.GetIndex();
                if (ni > myIndex)
                    pairs.add(Integer.toString(myIndex) + " " + Integer.toString(ni) + "; ");
            }
        }

        SceneWriter.OutStream.println();
        for (String si : pairs)
            SceneWriter.OutStream.print(si);
        SceneWriter.OutStream.println();
    }

    //Nándi: ez a függvény van az osztálydiagramon és nagyon furcsán néz ki, az argumentumok is indokolatlanok. Valószínűleg kell majd rajta változtatni.
    public void changeField(Field currentField, Field newField, List<Entity> entities, List<Field> fields) {

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
