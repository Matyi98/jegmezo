package views;

import entities.Player;
import items.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import game.GameController;
import javafx.scene.text.Font;
import javafx.util.Builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfoPanelView extends StackPane implements IView {

    public InfoPanelView() {
        initialise();
    }
    private List<Item> actualInventory;
    private Player actualPlayer;


    private void initialise() {
        this.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(240, 240, 240),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));
        //GetActualPlayer
        GameController gc = GameController.GetInstance();
        actualPlayer = gc.GetActivePlayer();
        actualInventory = actualPlayer.getItems();

        //Exit to Menu demo
       /* Button bExit = new Button("EXIT");
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
        //End of demo*/

        BuildInventory();
        BuildPlayerInfo();
        BuildButtons();


            }

    private void BuildInventory()
    {

        //Create Inventory Pane
        Pane inventoryPane = new Pane();
        inventoryPane.setMinSize(350, 250);
        inventoryPane.setMaxSize(350, 250);
        inventoryPane.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(200, 200, 200),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));
        inventoryPane.setStyle("-fx-border-color: black");
        inventoryPane.setTranslateY(215);
        getChildren().add(inventoryPane);
        Label invenotryLabel = new Label();
        invenotryLabel.setText("Rucsac");
        invenotryLabel.setAlignment(Pos.TOP_CENTER);
        invenotryLabel.setFont(new Font("Arial", 30));
        invenotryLabel.setMaxSize(350, 50);
        invenotryLabel.setMinSize(350, 50);
        inventoryPane.getChildren().add(invenotryLabel);
        //End

        //Set slots of Inventory
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++) {
                Pane slotPane = new Pane();
                slotPane.setMinSize(80, 80);
                slotPane.setMaxSize(80, 80);
                if (actualInventory.size() >= i * 3 + (j + 1)) {
                    BackgroundImage myBI = new BackgroundImage(new Image(actualInventory.get(i * 3 + j + 1 - 1).GetTexturePath(), 32, 32, false, true),
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT);
                    slotPane.setBackground(new Background(myBI));
                } else {
                    slotPane.setBackground(
                            new Background(
                                    new BackgroundFill(
                                            Color.rgb(75, 75, 200),
                                            CornerRadii.EMPTY,
                                            Insets.EMPTY
                                    )));
                       }
                    slotPane.setTranslateY(i * 100 + 55);
                    slotPane.setTranslateX(j * 100 + 35);
                    inventoryPane.getChildren().add(slotPane);
                }
        }


    private void BuildPlayerInfo()
    {
        //Create information panel
        Pane playerInfoPane = new Pane();
        playerInfoPane.setMinSize(350, 150);
        playerInfoPane.setMaxSize(350, 150);
        playerInfoPane.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(200, 200, 200),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));
        playerInfoPane.setTranslateY(-250);
        getChildren().add(playerInfoPane);
        playerInfoPane.setStyle("-fx-border-color: black");
        //End

        //create playerNameLabel
        Label nameLabel = new Label();
        nameLabel.setText("Nume și prenume: "+actualPlayer.getName());
        nameLabel.setAlignment(Pos.TOP_LEFT);
        nameLabel.setFont(new Font("Arial", 20));
        nameLabel.setMaxSize(350, 25);
        nameLabel.setMinSize(350, 25);
        playerInfoPane.getChildren().add(nameLabel);
        nameLabel.setTranslateX(5);
        //End

        //create playerActionPointsLabel
        Label actionPoints = new Label();
        actionPoints.setText("Punct de acțiune: "+actualPlayer.getActionPoints());
        actionPoints.setAlignment(Pos.TOP_LEFT);
        actionPoints.setFont(new Font("Arial", 20));
        actionPoints.setMaxSize(350, 25);
        actionPoints.setMinSize(350, 25);
        playerInfoPane.getChildren().add(actionPoints);
        actionPoints.setTranslateY(50);
        actionPoints.setTranslateX(5);
        //End

        //create lifePointsLabel
        //create playerActionPointsLabel
        Label lifePointsLabel = new Label();
        lifePointsLabel.setText("Punct de viaţa "+actualPlayer.getActionPoints());
        lifePointsLabel.setAlignment(Pos.TOP_LEFT);
        lifePointsLabel.setFont(new Font("Arial", 20));
        lifePointsLabel.setMaxSize(350, 25);
        lifePointsLabel.setMinSize(350, 25);
        playerInfoPane.getChildren().add(lifePointsLabel);
        lifePointsLabel.setTranslateY(100);
        lifePointsLabel.setTranslateX(5);


    }

    private void BuildButtons()
    {
        Pane buttonPane = new Pane();
        buttonPane.setMinSize(350, 200);
        buttonPane.setMaxSize(350, 200);
        buttonPane.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(200, 200, 200),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));
        buttonPane.setStyle("-fx-border-color: black");
        buttonPane.setTranslateY(-40);
        getChildren().add(buttonPane);

        //Create move button
        String[] commands = {"p turn a", "p turn d", "p move", "p special", "p skip", "p shovel", "p pickup", "p dig", "p use 0", "p use 1", "p use 2", "p use 3","p use 4", "p use 5" };
        String[] buttonNames = {"învârte s", "învârte d", "merge", "putere", "ocolire", "săpat", "ridica", "săpa",  "folosiți 1", "folosiți2","folosiți 3","folosiți 4","folosiți 5", "folosiți 6"};
        for(int i = 0; i<14; i++)
        {
            Button b = new Button(commands[i]);
            int finalI = i;
            b.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[finalI]));
            b.setTranslateX(i*75 - 300 *(i/4));
            b.setTranslateY(40 * (i/4));
            getChildren().add(b);
            buttonPane.getChildren().add(b);

        }
    }

       @Override
        public void Update() {
            initialise();
        }
    }

