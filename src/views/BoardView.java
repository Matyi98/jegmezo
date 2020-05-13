package views;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import scene.Board;

public class BoardView extends StackPane implements IView {
    private Board data;
    public BoardView(Board b) {
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
   }

    @Override
    public void Update() {
        //TODO: Implement this.
    }
}
