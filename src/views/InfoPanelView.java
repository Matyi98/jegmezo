package views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import main.Main;
import scene.GameController;

public class InfoPanelView extends StackPane implements IView {

    public InfoPanelView() {
        initialise();
    }

    private void initialise() {
        this.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(240, 240, 240),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));

        Button bExit = new Button("EXIT");
        bExit.setOnMouseClicked(mouseEvent -> GameController.GetInstance().EXIT());
        getChildren().add(bExit);

        //Build the View here
    }

    @Override
    public void Update() {

    }
}
