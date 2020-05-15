package views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import main.Main;
import scene.GameController;

import java.util.ArrayList;

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

    //Exit to Menu demo
        Button bExit = new Button("EXIT");
        bExit.setOnMouseClicked(mouseEvent -> GameController.GetInstance().EXIT());
        getChildren().add(bExit);
        StackPane.setAlignment(bExit, Pos.TOP_LEFT);
    //End of demo

    //Execute demo
        Button bExecute = new Button("Move");
        bExecute.setOnMouseClicked(e -> GameController.GetInstance().Execute("p move"));
        getChildren().add(bExecute);
        StackPane.setAlignment(bExecute, Pos.TOP_RIGHT);
    //End of demo

    //Dialog Demo
        Button bDialog = new Button("DialogTST");
        ArrayList<String> opts = new ArrayList<>();
        opts.add("tűzindító");
        opts.add("Jonatán");
        opts.add("ODA VAN ÍRVAAA!!!");
        utility.Dialog d = new utility.Dialog("Ez alma?", opts);
        StackPane.setAlignment(bDialog, Pos.TOP_CENTER);
        bDialog.setOnMouseClicked(mouseEvent -> d.ShowDialog());
        getChildren().add(bDialog);
    //End of demo

        //Build the View here
    }

    @Override
    public void Update() {

    }
}
