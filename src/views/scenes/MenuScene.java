package views.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import game.GameController;
import views.scenes.mainWindow.GameScene;

import java.io.File;
import java.util.Objects;

class Map {
    final String DisplayName;
    final String Path;

    Map(String displayName, String path) {
        DisplayName = displayName;
        Path = path;
    }

    @Override
    public String toString() {
        return DisplayName;
    }
}

public class MenuScene extends Scene {

    private Button bStart = new Button("Játék indítás");
    private Button bQuit = new Button("Kilépés");
    private Label lSelMap = new Label();
    private ComboBox<String> cbPlayerCountSelect;
    private ComboBox<Map> cbMapSelect;
    private VBox root = new VBox();

    private ObservableList<String> playerNumbers =
            FXCollections.observableArrayList(
                    "2 játékos",
                    "3 játékos",
                    "4 játékos",
                    "5 játékos",
                    "6 játékos"
            );

    private ObservableList<Map> mapOptions =
            FXCollections.observableArrayList(
                    new Map("Jégvarázs", "map0.txt"),
                    new Map("A Mikulás nyomában", "map0.txt"),
                    new Map("Maloy bosszúja", "map0.txt"),
                    new Map("Ötvös faszsága (max3 játékos)", "map0.txt")
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
        aMapInfoRow.getChildren().add(new Label("Kiválasztott pálya: "));
        aMapInfoRow.getChildren().add(cbMapSelect = new ComboBox<>(mapOptions));

        setCbChangeHandle();

        //aStartExitRow
        bStart.setOnMouseClicked(mouseEvent -> {
            GameController.Initialise(getMapFile(), getPlayerCount());
            Stage stage = ((Stage)getWindow());
            stage.setTitle(cbMapSelect.getValue().toString());
            stage.setScene(new GameScene());
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

    private int getPlayerCount() {
        int c = cbPlayerCountSelect.getValue().charAt(0)-'0';
        return c;
    }

    private File getMapFile() {
        int i = cbMapSelect.getSelectionModel().getSelectedIndex();
        String mapPath = mapOptions.get(i).Path;
        return new File(Objects.requireNonNull(getClass().getClassLoader().getResource(mapPath)).getFile());
    }

    public MenuScene() {
        super(new StackPane(),260, 300);
        initialize();
        setRoot(root);
    }


}
