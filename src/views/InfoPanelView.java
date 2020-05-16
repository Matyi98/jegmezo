package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import game.GameController;
import javafx.scene.text.Font;

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

    //Inventory
        Pane inventoryPane = new Pane();
        inventoryPane.setMinSize(350,350);
        inventoryPane.setMaxSize(350,350);

        inventoryPane.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(100, 100, 100),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));
        inventoryPane.setTranslateY(175);
        getChildren().add(inventoryPane);
        Label invenotryLabel = new Label();
        invenotryLabel.setText("Inventory");
        invenotryLabel.setAlignment(Pos.TOP_CENTER);
        invenotryLabel.setFont(new Font("Arial", 30));
        invenotryLabel.setMaxSize(350,50);
        invenotryLabel.setMinSize(350,50);
        inventoryPane.getChildren().add(invenotryLabel);

        for(int i = 0; i<3; i++)
            for(int j = 0; j<3; j++)
            {
                Pane slotPane = new Pane();
                slotPane.setMinSize(80,80);
                slotPane.setMaxSize(80,80);

                slotPane.setBackground(
                        new Background(
                                new BackgroundFill(
                                        Color.rgb(75, 75, 200),
                                        CornerRadii.EMPTY,
                                        Insets.EMPTY
                                )));
                slotPane.setTranslateY(i*100+55);
                slotPane.setTranslateX(j*100+35);
                inventoryPane.getChildren().add(slotPane);
            }



        //Build the View here
    }

    @Override
    public void Update() {

    }
}
