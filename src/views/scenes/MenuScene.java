package views.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import scene.GameController;
import views.scenes.mainWindow.GameWindowScene;

import java.io.File;

public class MenuScene extends Scene {

    private Button bStart = new Button("StartGame");
    private Button bQuit = new Button("Quit");
    private Pane root = new Pane();

    private void initialize() {
        Pane bottom = new Pane();

        bStart.setOnMouseClicked(mouseEvent -> {
            GameController.Initialise(getMapFile());
            Stage stage = ((Stage)getWindow());
            stage.setScene(new GameWindowScene());
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
        super(new StackPane(),300, 400);
        initialize();
        setRoot(root);
    }


}
