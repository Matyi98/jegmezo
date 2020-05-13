package views.scenes;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import scene.GameController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MenuScene extends Scene {

    private Button bStart = new Button("StartGame");
    private Button bQuit = new Button("Quit");
    private StackPane root = new StackPane();

    private void initialize() {
        Pane bottom = new Pane();

        bStart.setOnMouseClicked(mouseEvent -> {
            GameController.Initialise(getMapFile());
            Stage stage = ((Stage)getWindow());
            stage.setScene(new MainScene());
            stage.setTitle("JegmezoGame");
        });
        bStart.setLayoutX(50);
        bStart.setLayoutY(50);

        bottom.getChildren().add(bStart);

        bQuit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });
        bQuit.setLayoutX(150);
        bQuit.setLayoutY(50);
        bottom.getChildren().add(bQuit);

        root.getChildren().add(bottom);

    }

    private String mapPath = "map0.txt";
    private File getMapFile() {
        final String pwd = System.getProperty("user.dir");
        return new File(pwd+"/maps/"+ mapPath);
    }

    public MenuScene() {
        super(new StackPane(),500, 600);
        initialize();
        setRoot(root);
    }

    private void addChildren(Node e) {
        root.getChildren().add(e);
    }
}
