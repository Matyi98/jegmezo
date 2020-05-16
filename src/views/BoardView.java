package views;

import fields.Field;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import game.Board;
import javafx.scene.shape.Line;
import reader.LayoutReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardView extends StackPane implements IView {
    private Board data;
    private ArrayList<Point2D> fieldCoords;
    private ArrayList<FieldView> fieldViews = new ArrayList<>();

    public BoardView(Board b, File file) {
        this.data = b;

        readFieldLayouts(file);
        initialise();

   }

    private void readFieldLayouts(File file){
        LayoutReader layoutReader;
        try {
            FileInputStream fis = new FileInputStream(file);
            layoutReader = new LayoutReader(fis);
            fieldCoords = layoutReader.readCoords();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

   private void initialise() {
        this.setBackground(
               new Background(
                       new BackgroundFill(
                               Color.rgb(240, 240, 240),
                               CornerRadii.EMPTY,
                               Insets.EMPTY
                       )));

        initFieldViews();
   }

   public void initFieldViews(){
       for(int i = 0; i < fieldCoords.size(); i++){

           Field field = data.getField(i);
           FieldView fieldView = new FieldView(field);
           ArrayList<Integer> UIDs = field.GetNeighboursUIDs();

           Point2D fieldCoord = fieldCoords.get(i);

           for(Integer UID : UIDs){
               Point2D neighbourCoords = fieldCoords.get(UID);
               Line passage = new Line(fieldCoord.getX(), fieldCoord.getY(),
                       neighbourCoords.getX(), neighbourCoords.getY());

               getChildren().add(passage);
           }

           fieldView.setTranslateX(fieldCoord.getX());
           fieldView.setTranslateY(fieldCoord.getY());

           fieldViews.add(fieldView);
           getChildren().add(fieldView);
       }
   }

    @Override
    public void Update() {
        fieldViews.clear();
        initFieldViews();
        fieldViews.forEach(e -> Update());
    }
}
