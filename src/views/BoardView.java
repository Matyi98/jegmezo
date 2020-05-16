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
import reader.LayoutReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BoardView extends StackPane implements IView {
    private Board data;
    private File file;
    private List<Point2D> fieldCoords;
    public BoardView(Board b, File file) {
        this.file = file;
        initialise();

        this.data = b;
   }

   private void initialise() {
        this.setBackground(
               new Background(
                       new BackgroundFill(
                               Color.rgb(240, 240, 240),
                               CornerRadii.EMPTY,
                               Insets.EMPTY
                       )));

        //Build the View here
       readFieldLayouts();
       for(int i = 0; i < fieldCoords.size(); i++){
           FieldView field = new FieldView(data.getField(i));
           field.setTranslateX(fieldCoords.get(i).getX());
           field.setTranslateY(fieldCoords.get(i).getY());
           getChildren().add(field);
       }
   }

    void readFieldLayouts(){
        LayoutReader layoutReader;
        try {
            FileInputStream fis = new FileInputStream(file);
            layoutReader = new LayoutReader(fis);
            fieldCoords = layoutReader.readCoords();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }


   }

    @Override
    public void Update() {
        //TODO: Implement this.
    }
}
