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
import javafx.scene.text.FontWeight;
import javafx.util.Builder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InfoPanelView extends StackPane implements IView {
    /**
     * Az infopanel inicializalasa.
     */
    public InfoPanelView() {
        initialise();
    }

    /**
     * Ebbe a ket valtozoba fogjuk beletenni az aktualis jatekost es
     * az inventoryját az infopanel kitoltesehez.
     */
    private List<Item> actualInventory;
    private Player actualPlayer;


    private void initialise() {
        //Infopanel hatterszinenek beallitasa
        this.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(240, 240, 240),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));
        //
        //Az adatok betoltese
        loadNewDatas();
            }
    public void loadNewDatas()
    {
        GameController gc = GameController.GetInstance();
        actualPlayer = gc.GetActivePlayer();
        actualInventory = actualPlayer.getItems();
        //Jatekos inventorijanak betoltese
        //a benne talalhato itemekkel
        BuildInventory();
        //A jatekos nevenek, eleteropontjanak
        //es akciopontjanak betoltese
        BuildPlayerInfo();
        //Az iranyitashoz szukseges gombok elkeszitese
        BuildButtons();
    }

    private void BuildInventory()
    {

        //Inventory panel letrehozasa, hatterszin
        //meret, eltolas, text beallitasa
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
        invenotryLabel.setText("Inventory");
        invenotryLabel.setAlignment(Pos.TOP_CENTER);
        invenotryLabel.setFont(new Font("Arial", 30));
        invenotryLabel.setMaxSize(350, 50);
        invenotryLabel.setMinSize(350, 50);
        inventoryPane.getChildren().add(invenotryLabel);
        //

        //Inventory itemhejeinek betolese
        //6 itemet tarolhatunk
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++) {
                //Uj panel egy itemnek, meret beallitasa
                Pane slotPane = new Pane();
                slotPane.setMinSize(80, 80);
                slotPane.setMaxSize(80, 80);
                //Megnezzuk, hogy az adott sloton van-e
                //item,ha van betesszuk, ha nincs akkor
                //kek hatterszint allitunk be
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
                //
                //A panelt a helyere toljuk
                    slotPane.setTranslateY(i * 100 + 55);
                    slotPane.setTranslateX(j * 100 + 35);
                //hozzaadjuk a szulo panelhez
                    inventoryPane.getChildren().add(slotPane);
                }
        }

    /***
     * Jatekos eletenek, akciopontjanak es
     * nevenek megjelenitese
     */
    private void BuildPlayerInfo()
    {
        //Informaciopanel letrehozasa es
        //meret, hatterszin, eltolas, keret beallitasa
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
        //

        //Jatekosnev letrehozasa labelkent
        //lekerdezese az actualPlayerbol
        Label nameLabel = new Label();
        nameLabel.setText("Name: "+actualPlayer.getName());
        nameLabel.setAlignment(Pos.TOP_LEFT);
        nameLabel.setFont(new Font("Arial", 20));
        nameLabel.setMaxSize(350, 25);
        nameLabel.setMinSize(350, 25);
        playerInfoPane.getChildren().add(nameLabel);
        nameLabel.setTranslateX(5);
        //

        //Player akciopont letrehozas labelkent
        //lekerdezese az actualPlayerbol
        Label actionPoints = new Label();
        actionPoints.setText("Action Points: "+actualPlayer.getActionPoints());
        actionPoints.setAlignment(Pos.TOP_LEFT);
        actionPoints.setFont(new Font("Arial", 20));
        actionPoints.setMaxSize(350, 25);
        actionPoints.setMinSize(350, 25);
        playerInfoPane.getChildren().add(actionPoints);
        actionPoints.setTranslateY(35);
        actionPoints.setTranslateX(5);
        //E

        //Player eleteropontjanak letrehozas labelkent
        //lekerdezzes az actualPlayertol
        Label lifePointsLabel = new Label();
        lifePointsLabel.setText("Health points: "+actualPlayer.getHealthPoints());
        lifePointsLabel.setAlignment(Pos.TOP_LEFT);
        lifePointsLabel.setFont(new Font("Arial", 20));
        lifePointsLabel.setMaxSize(350, 25);
        lifePointsLabel.setMinSize(350, 25);
        playerInfoPane.getChildren().add(lifePointsLabel);
        lifePointsLabel.setTranslateY(70);
        lifePointsLabel.setTranslateX(5);
        //
    }

    private void BuildButtons()
    {
        //Gombokat tarolo panel letrehozasa, meret,
        //hatterszin, keret, elhelyezes beallitasa
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
        //

        //A gombokhoz tartozo commandok beallitasa
        String[] commands = {"p turn a", "p turn d", "p move", "p special", "p skip", "p pickup", "p dig"};
        String[] buttonNames ={"turn ->", "turn <-", "go", "+power", "pass", "pickup", "dig"};

        //jobbra fordulas gomb beallitasa
        //meret, elhelyezkedes, command, szin
        Button b1 = new Button(buttonNames[0]);
        b1.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        b1.setStyle(
                "-fx-background-color: #4B4BC8;" +
                "-fx-border-color: black; "
        );
        b1.setMaxSize(80,30);
        b1.setMinSize(80,30);
        b1.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[0]));
        b1.setTranslateY(-75);
        b1.setTranslateX(-125);
        getChildren().add(b1);
        //

        //balra fordulas gomb beallitasa
        //meret, elhelyezkedes, command, szin
        Button b2 = new Button(buttonNames[1]);
        b2.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        b2.setStyle(
                "-fx-background-color: #4B4BC8; "+
                "-fx-border-color: black;"
        );
        b2.setMaxSize(80,30);
        b2.setMinSize(80,30);
        b2.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[1]));
        b2.setTranslateY(-75);
        b2.setTranslateX(125);
        getChildren().add(b2);
        //

        //mozgas button beallitasa
        //meret, elhelyezkedes, command, szin
        Button b3 = new Button(buttonNames[2]);
        b3.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        b3.setStyle(
                "-fx-background-color: #4B4BC8; "+
                "-fx-border-color: black;"
        );
        b3.setMaxSize(80,30);
        b3.setMinSize(80,30);
        b3.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[2]));
        b3.setTranslateY(-120);
        b3.setTranslateX(0);
        getChildren().add(b3);
        //

        //passzolas button beallitasa
        //meret, elhelyezkedes, command, szin
        Button b4 = new Button(buttonNames[3]);
        b4.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        b4.setStyle(
                "-fx-background-color: #4B4BC8; "+
                "-fx-border-color: black;"
        );
        b4.setMaxSize(80,30);
        b4.setMinSize(60,30);
        b4.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[3]));
        b4.setTranslateY(-30);
        b4.setTranslateX(-125);
        getChildren().add(b4);

        //specialis kepesseg button beallitasa
        //meret, elhelyezkedes, command, szin
        Button b5 = new Button(buttonNames[4]);
        b5.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        b5.setStyle(
                "-fx-background-color: #4B4BC8; "+
                "-fx-border-color: black;"
        );
        b5.setMaxSize(80,30);
        b5.setMinSize(80,30);
        b5.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[4]));
        b5.setTranslateY(-120);
        b5.setTranslateX(-125);
        getChildren().add(b5);
        //

        //item felvetel button beallitasa
        //meret, elhelyezkedes, command, szin
        Button b6 = new Button(buttonNames[5]);
        b6.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        b6.setStyle(
                "-fx-background-color: #4B4BC8; "+
                "-fx-border-color: black;"
        );
        b6.setMaxSize(80,30);
        b6.setMinSize(80,30);
        b6.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[5]));
        b6.setTranslateY(-30);
        b6.setTranslateX(125);
        getChildren().add(b6);
        //

        //asas button beallitasa
        //meret, elhelyezkedes, command, szin
        Button b7 = new Button(buttonNames[6]);
        b7.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        b7.setStyle(
                "-fx-background-color: #4B4BC8; "+
                "-fx-border-color: black;"
        );
        b7.setMaxSize(80,30);
        b7.setMinSize(80,30);
        b7.setOnMouseClicked(e -> GameController.GetInstance().Execute(commands[6]));
        b7.setTranslateY(-120);
        b7.setTranslateX(125);
        getChildren().add(b7);

        //Player megjelenitese a panel kozepen
        //Playertol kerjuk le a kepet
        //meret es elhelyezkedes beallitasa
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

