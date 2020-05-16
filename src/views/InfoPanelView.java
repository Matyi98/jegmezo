package views;

import entities.Player;
import items.Item;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import game.GameController;
import javafx.scene.text.Font;
import javafx.util.Builder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        loadNewDatas();

            }
    public void loadNewDatas()
    {
        GameController gc = GameController.GetInstance();
        actualPlayer = gc.GetActivePlayer();
        actualInventory = actualPlayer.getItems();
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
                    Image image = null;
                    try(InputStream is = Files.newInputStream(Paths.get(actualInventory.get(i * 3 + j).GetTexturePath()))){
                        image = new Image(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(image != null)
                    {
                        ImageView pic = new ImageView();
                        pic.setFitHeight(50);
                        pic.setFitWidth(50);
                        pic.setPreserveRatio(true);
                        pic.setImage(image);
                        pic.setX(0);
                        pic.setY(0);
                        slotPane.getChildren().add(pic);
                        int finI, finJ;
                        finI = i;
                        finJ = j;
                        slotPane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                             GameController.GetInstance().Execute("p use "+finI * 3 + finJ);
                        }
                    });
                    }
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
        nameLabel.setText("Name: "+actualPlayer.getName());
        nameLabel.setAlignment(Pos.TOP_LEFT);
        nameLabel.setFont(new Font("Arial", 20));
        nameLabel.setMaxSize(350, 25);
        nameLabel.setMinSize(350, 25);
        playerInfoPane.getChildren().add(nameLabel);
        nameLabel.setTranslateX(5);
        //End

        //create playerActionPointsLabel
        Label actionPoints = new Label();
        actionPoints.setText("Action Points: "+actualPlayer.getActionPoints());
        actionPoints.setAlignment(Pos.TOP_LEFT);
        actionPoints.setFont(new Font("Arial", 20));
        actionPoints.setMaxSize(350, 25);
        actionPoints.setMinSize(350, 25);
        playerInfoPane.getChildren().add(actionPoints);
        actionPoints.setTranslateY(35);
        actionPoints.setTranslateX(5);
        //End

        //create lifePointsLabel
        //create playerActionPointsLabel
        Label lifePointsLabel = new Label();
        lifePointsLabel.setText("Health points: "+actualPlayer.getHealthPoints());
        lifePointsLabel.setAlignment(Pos.TOP_LEFT);
        lifePointsLabel.setFont(new Font("Arial", 20));
        lifePointsLabel.setMaxSize(350, 25);
        lifePointsLabel.setMinSize(350, 25);
        playerInfoPane.getChildren().add(lifePointsLabel);
        lifePointsLabel.setTranslateY(70);
        lifePointsLabel.setTranslateX(5);

        /*//create playerActionPointsLabel
        Label directionLabel = new Label();
        directionLabel.setText("direcţie: "+actualPlayer.getDirection());
        directionLabel.setAlignment(Pos.TOP_LEFT);
        directionLabel.setFont(new Font("Arial", 20));
        directionLabel.setMaxSize(350, 25);
        directionLabel.setMinSize(350, 25);
        playerInfoPane.getChildren().add(directionLabel);
        directionLabel.setTranslateY(105);
        directionLabel.setTranslateX(5);*/
    }

    private void BuildButtons()
    {
        StackPane buttonPane = new StackPane();
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
        String[] commands = {"p turn a", "p turn d", "p move", "p special", "p skip", "p pickup", "p dig"};

        //buttons turn a
        Button b1 = new Button(commands[0]);
        b1.setMaxSize(80,30);
        b1.setMinSize(80,30);
        b1.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[0]));
        b1.setTranslateY(-75);
        b1.setTranslateX(-125);
        getChildren().add(b1);

        //button turn d
        Button b2 = new Button(commands[1]);
        b2.setMaxSize(80,30);
        b2.setMinSize(80,30);
        b2.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[1]));
        b2.setTranslateY(-75);
        b2.setTranslateX(125);
        getChildren().add(b2);

        //button move
        Button b3 = new Button(commands[2]);
        b3.setMaxSize(80,30);
        b3.setMinSize(80,30);
        b3.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[2]));
        b3.setTranslateY(-120);
        b3.setTranslateX(0);
        getChildren().add(b3);

        //button skip
        Button b4 = new Button(commands[3]);
        b4.setMaxSize(80,30);
        b4.setMinSize(60,30);
        b4.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[3]));
        b4.setTranslateY(-30);
        b4.setTranslateX(-125);
        getChildren().add(b4);

        //button p special
        Button b5 = new Button(commands[4]);
        b5.setMaxSize(80,30);
        b5.setMinSize(80,30);
        b5.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[4]));
        b5.setTranslateY(-120);
        b5.setTranslateX(-125);
        getChildren().add(b5);

        //pick up
        Button b6 = new Button(commands[5]);
        b6.setMaxSize(80,30);
        b6.setMinSize(80,30);
        b6.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[5]));
        b6.setTranslateY(-30);
        b6.setTranslateX(125);
        getChildren().add(b6);

        //dig
        Button b7 = new Button(commands[6]);
        b7.setMaxSize(80,30);
        b7.setMinSize(80,30);
        b7.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[6]));
        b7.setTranslateY(-120);
        b7.setTranslateX(125);
        getChildren().add(b7);

        //Show player
        GridPane playerPane = new GridPane();
        playerPane.setMaxSize(75,136);
        playerPane.setMinSize(75,136);
        playerPane.setTranslateX(5);
        playerPane.setTranslateY(10);
        Image image = null;
        try(InputStream is = Files.newInputStream(Paths.get(actualPlayer.GetTexturePath()))){
            image = new Image(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(image != null)
        {
            ImageView pic = new ImageView();
            pic.setFitHeight(136);
            pic.setFitWidth(75);
            pic.setPreserveRatio(true);
            pic.setImage(image);
            playerPane.getChildren().add(pic);

        }
        buttonPane.getChildren().add(playerPane);


    }

       @Override
        public void Update() {
            initialise();
        }
    }

