package views.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import scene.GameController;
import views.scenes.mainWindow.GameWindowScene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuScene extends Scene {

    private Button bStart = new Button("Játék indítás");
    private Button bQuit = new Button("Kilépés");
    private Label lSelMap = new Label();
    private ComboBox<String> cbPlayerCountSelect;
    private ComboBox<String> cbMapSelect;
    private VBox root = new VBox();

    private ObservableList<String> playerNumbers =
            FXCollections.observableArrayList(
                    "2 játékos",
                    "3 játékos",
                    "4 játékos",
                    "5 játékos",
                    "6 játékos"
            );

    private ObservableList<String> mapOptions =
            FXCollections.observableArrayList(
                    "Jégvarás",
                    "Dö frózön trón",
                    "Maloy bosszúja"
            );


    private void initialize() {
        bStart.setDisable(true);

        root.setPadding(new Insets(16));
        root.setSpacing(20);

        VBox aNumPlayerRow = new VBox();
        VBox aMapInfoRow = new VBox();
        StackPane aStartExitRow = new  StackPane();

        root.getChildren().add(aNumPlayerRow);
        root.getChildren().add(aMapInfoRow);
        Pane placeholder = new Pane();
        VBox.setVgrow(placeholder, Priority.ALWAYS);
        root.getChildren().add(placeholder);
        root.getChildren().add(aStartExitRow);

        //aNumPlayerRow
        aNumPlayerRow.setSpacing(5);
        aNumPlayerRow.getChildren().add(new Label("Játékosok száma: "));
        aNumPlayerRow.getChildren().add(cbPlayerCountSelect = new ComboBox<>(playerNumbers));

        //aMapInfoRow
        aMapInfoRow.setSpacing(5);
        aMapInfoRow.getChildren().add(new Label("Kiválasztott pálya:    "));
        aMapInfoRow.getChildren().add(cbMapSelect = new ComboBox<>(mapOptions));

        setCbChangeHandle();

        //aStartExitRow
        bStart.setOnMouseClicked(mouseEvent -> {
            GameController.Initialise(getMapFile());
            Stage stage = ((Stage)getWindow());
            stage.setScene(new GameWindowScene());
        });
        aStartExitRow.getChildren().add(bStart);
        StackPane.setAlignment(bStart, Pos.TOP_LEFT);

        bQuit.setOnMouseClicked(mouseEvent -> System.exit(0));
        aStartExitRow.getChildren().add(bQuit);
        StackPane.setAlignment(bQuit, Pos.TOP_RIGHT);
    }

    private void setCbChangeHandle() {
        cbMapSelect.setOnAction(e ->   {
            if(cbMapSelect.getValue() != null && cbPlayerCountSelect.getValue() != null)
                bStart.setDisable(false);
        });
        cbPlayerCountSelect.setOnAction(e ->   {
            if(cbMapSelect.getValue() != null && cbPlayerCountSelect.getValue() != null)
                bStart.setDisable(false);
        });
    }

    private String mapPath = "map0.txt";
    private File getMapFile() {
        final String pwd = System.getProperty("user.dir");
        return new File(pwd+"/maps/"+ mapPath);
    }

    public MenuScene() {
        super(new StackPane(),260, 300);
        initialize();
        setRoot(root);
    }


}
