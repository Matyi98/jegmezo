package scene;

import fields.Field;
import entities.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<Field> board;

    public Board(ArrayList<Field> fields) {
        this.board = fields;
    }

    //Nándi: ez a függvény van az osztálydiagramon és nagyon furcsán néz ki, az argumentumok is indokolatlanok. Valószínűleg kell majd rajta változtatni.
    public void changeField(Field currentField, Field newField, List<Player> players) {

    }

    //Behavaztat mezőket.
    public void letItSnow(){

    }
}
