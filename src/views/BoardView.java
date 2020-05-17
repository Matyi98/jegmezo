package views;

import entities.Player;
import fields.Field;
import game.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import game.Board;
import javafx.scene.shape.Line;
import reader.LayoutReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BoardView extends Pane implements IUpdatable {
    private Board data;
    private ArrayList<Point2D> fieldCoords;
    private ArrayList<FieldView> fieldViews = new ArrayList<>();
    private final int fieldRadius = 50;

    public BoardView(Board b, File file) {
        this.data = b;

        fieldCoords = readFieldLayouts(file);
        initialise();

    }

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

   private void initialise() {
       setStyle("-fx-background-color: rgb(240, 240, 240)");
       initPassages();
       initFieldViews();
   }

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

   private void initFieldViews(){
       for(int i = 0; i < fieldCoords.size(); i++){
           Field field = data.getField(i);
           Point2D fieldCoord = fieldCoords.get(i);

           FieldView fieldView = new FieldView(field, fieldRadius);

           fieldView.setTranslateX(fieldCoord.getX());
           fieldView.setTranslateY(fieldCoord.getY());

           fieldViews.add(fieldView);
           getChildren().add(fieldView);

       }

       showSelectedField();
   }

   private void showSelectedField(){
       Player activePlayer = GameController.GetInstance().GetActivePlayer();
       int UIDofSelected = activePlayer.getFieldUnder().getNeighbourByDirection(activePlayer.getActualDirection()).GetUID();
       fieldViews.get(UIDofSelected).showSelect();

   }

   @Override
   public void Update() {
        refreshFieldViews();
    }

   private void refreshFieldViews(){
       for(FieldView view : fieldViews){
           getChildren().remove(view);
       }

       fieldViews.clear();

       initFieldViews();
   }
}
