package views;

import entities.Player;
import fields.Field;
import game.GameController;
import javafx.geometry.Point2D;
import javafx.scene.layout.*;
import game.Board;
import javafx.scene.shape.Line;
import reader.LayoutReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Játéktábla megjelenítésért felelős osztály.
 */
public class BoardView extends Pane implements IUpdatable {
    /**
     * A játéktbála aminek az adatait jeleníti meg.
     */
    private Board data;
    private ArrayList<Point2D> fieldCoords;
    private ArrayList<FieldView> fieldViews = new ArrayList<>();
    private final int fieldRadius = 50;

    /**
     * Konstruktor
     * @param b A játéktbála aminek az adatait jeleníti meg.
     * @param mapLayout A pályakinézetet leíró fájl.
     */
    public BoardView(Board b, File mapLayout) {
        this.data = b;

        fieldCoords = readFieldLayouts(mapLayout);
        initialise();
    }

    /**
     * Pályakinézet leíró fájl betöltése.
     * @param file elérési út.
     * @return Egyes fieldek koordinátái a rajzfelületen.
     */
    private ArrayList<Point2D> readFieldLayouts(File file){
        LayoutReader layoutReader;
        try {
            FileInputStream fis = new FileInputStream(file);
            layoutReader = new LayoutReader(fis);
            return layoutReader.readCoords();

        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Grafikus felület inicializálása.
     */
   private void initialise() {
       setStyle("-fx-background-color: rgb(240, 240, 240)");
       initPassages();
       initFieldViews();
   }

    /**
     * Élek inicializálása.
     */
   private void initPassages(){
       for(int i = 0; i < fieldCoords.size(); i++) {
           Field field = data.getField(i);
           Point2D fieldCoord = fieldCoords.get(i);
           ArrayList<Integer> UIDs = field.GetNeighboursUIDs();

           for (Integer UID : UIDs) {
               Point2D neighbourCoords = fieldCoords.get(UID);
               Line passage = new Line(fieldCoord.getX(), fieldCoord.getY(),
                       neighbourCoords.getX(), neighbourCoords.getY());

               passage.setTranslateX(fieldRadius);
               passage.setTranslateY(fieldRadius);
               getChildren().add(passage);
               getChildren().get(getChildren().size() - 1).toBack();
           }
       }
   }

    /**
     * Csomópontok inicializálása.
     */
   private void initFieldViews(){
       for(int i = 0; i < fieldCoords.size(); i++){
           Field field = data.getField(i);
           Point2D fieldCoord = fieldCoords.get(i);

           FieldView fieldView = new FieldView(field, fieldRadius);

           fieldView.setTranslateX(fieldCoord.getX());
           fieldView.setTranslateY(fieldCoord.getY());

           fieldViews.add(fieldView);
           fieldView.setScaleX(1.2);
           fieldView.setScaleY(1.2);
           getChildren().add(fieldView);
       }

       showSelectedField();
   }

    /**
     * Játékos által kiválasztott mező körvonalal kijelölése.
     */
   private void showSelectedField(){
       Player activePlayer = GameController.GetInstance().GetActivePlayer();
       int UIDofSelected = activePlayer.getFieldUnder().getNeighbourByDirection(activePlayer.getActualDirection()).GetUID();
       fieldViews.get(UIDofSelected).showSelect();
   }

    /**
     * Frissítés.
     */
   @Override
   public void Update() {
       for(FieldView view : fieldViews){
           getChildren().remove(view);
       }
       fieldViews.clear();
       initFieldViews();
    }

}
