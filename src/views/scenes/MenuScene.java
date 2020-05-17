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
import localization.Language;
import main.Main;
import views.scenes.mainWindow.GameScene;

import java.io.File;
import java.util.Objects;

/**
 * Egy pályát reprezentáló osztály
 */
class Map {
    final String DisplayName;
    final String modelPath;
    final String layoutPath;
    final int PlayerCount;

    /**
     * A pálya osztály konstruktora
     * @param displayName A pálya neve
     * @param modelPath A pálya modelljét tartalmazó fájl neve
     * @param playerCount A pálya maximum játékos száma
     */
    Map(String displayName, String modelPath, int playerCount) {
        DisplayName = displayName;
        this.modelPath = modelPath;
        this.layoutPath = createLayoutPath();
        PlayerCount = playerCount;
    }

    /**
     * Megadja a pályahoz tartozó layout fájl nevét, ebbe tatálhatóak a
     * kirajzoláshoz szükséges adatok
     * @return A layout fájl neve
     */
    private String createLayoutPath() {
        StringBuilder sb = new StringBuilder(modelPath);
        sb.insert(0,"layout_");
        return sb.toString();
    }

    /**
     * Megadja egy pálya kiírási formátumát, ami tartalmaza a
     * pálya nevét és a maximum játékos számot
     * @return A megadott string formátum
     */
    @Override
    public String toString() {
        return DisplayName + " ("+PlayerCount+")";
    }

    /**
     * Megadja egy pálya kiírási formátumát, ami tartalmaza a
     * pálya nevét és az aktuális játékos számot
     * @param actualPlayerCount Az aktuális játkos szám
     * @return A megadott string formátum
     */
    public String toString(int actualPlayerCount) {
        return DisplayName + " ("+actualPlayerCount+")";
    }
}

/**
 * A menü ablakát és annok müködési logikáját megvalósító osztály
 */
public class MenuScene extends Scene {

    private Button bStart = new Button(Language.Instance().MenuStart());
    private Button bQuit = new Button(Language.Instance().MenuExit());
    private Label lSelMap = new Label();
    private ComboBox<String> cbPlayerCountSelect;
    private ComboBox<Map> cbMapSelect;
    private ComboBox<Language.Languages> cbLangSelect;
    private VBox root = new VBox();

    /**
     * A játékosok számának beállítására használható lista
     */
    private ObservableList<String> playerNumbers =
            FXCollections.observableArrayList(
                    "2 "+ Language.Instance().Players(),
                    "3 "+ Language.Instance().Players(),
                    "4 "+ Language.Instance().Players(),
                    "5 "+ Language.Instance().Players(),
                    "6 "+ Language.Instance().Players()
            );

    /**
     * A pálya beállítására használható lista
     */
    private ObservableList<Map> mapOptions =
            FXCollections.observableArrayList(
                    new Map("Mega", "mega.txt", 6),
                    new Map("Tanszéki minta", "map0.txt", 3),
                    new Map("demo", "demo.txt", 2)
            );

    private ObservableList<Language.Languages> langOptions =
            FXCollections.observableArrayList(
                    Language.Languages.Magyar,
                    Language.Languages.English
            );

    private VBox aMapInfoRow = new VBox();
    private VBox aNumPlayerRow = new VBox();
    private VBox aLanguageRow = new VBox();
    private StackPane aStartExitRow = new  StackPane();

    /**
     * Inicializálja a menü elemeit, beállítja a tulajdonságait,
     * poziciójait, event listenerjeit
     */
    private void initialize() {
        bStart.setDisable(true);
        root.setPadding(new Insets(16));
        root.setSpacing(20);


        root.getChildren().add(aMapInfoRow);
        root.getChildren().add(aNumPlayerRow);
        root.getChildren().add(aLanguageRow);
        Pane placeholder = new Pane();
        VBox.setVgrow(placeholder, Priority.ALWAYS);
        root.getChildren().add(placeholder);
        root.getChildren().add(aStartExitRow);

        //aNumPlayerRow
        aNumPlayerRow.setSpacing(5);
        aNumPlayerRow.getChildren().add(new Label(Language.Instance().MenuPlayerCount()));
        aNumPlayerRow.getChildren().add(cbPlayerCountSelect = new ComboBox<>(playerNumbers));

        //aMapInfoRow
        aMapInfoRow.setSpacing(5);
        aMapInfoRow.getChildren().add(new Label(Language.Instance().MenuSelectedMap()));
        aMapInfoRow.getChildren().add(cbMapSelect = new ComboBox<>(mapOptions));

        //aLanguage
        aLanguageRow.setSpacing(5);
        aLanguageRow.getChildren().add(new Label(Language.Instance().MenuSchangeLang()));
        aLanguageRow.getChildren().add(cbLangSelect = new ComboBox<>(langOptions));
        cbLangSelect.getSelectionModel().select(Language.GetSelected());

        setCbChangeHandle();

        //aStartExitRow
        bStart.setOnMouseClicked(mouseEvent -> {
            GameController.Initialise(getMapFile(), getPlayerCount());
            Stage stage = ((Stage)getWindow());
            stage.setTitle(cbMapSelect.getValue().toString(getPlayerCount()));
            GameScene gs = new GameScene(getMapLayoutFile());

            stage.setScene(gs);

        });
        aStartExitRow.getChildren().add(bStart);
        StackPane.setAlignment(bStart, Pos.TOP_LEFT);

        bQuit.setOnMouseClicked(mouseEvent -> System.exit(0));
        aStartExitRow.getChildren().add(bQuit);
        StackPane.setAlignment(bQuit, Pos.TOP_RIGHT);
    }

    /**
     * A listák tartalmának frissítése, a start game gomb müködésének szabályozása
     */
    private void setCbChangeHandle() {
        cbMapSelect.setOnAction(e ->   {
            if (cbMapSelect.getValue() != null) {
                int c = cbMapSelect.getValue().PlayerCount;
                ObservableList<String> limited = FXCollections.observableArrayList();
                for (int i = 0; i < c-1; i++)
                    limited.add(playerNumbers.get(i));

                cbPlayerCountSelect.setItems(limited);
            }
            if(cbMapSelect.getValue() != null && cbPlayerCountSelect.getValue() != null)
                bStart.setDisable(false);
            else
                bStart.setDisable(true);
        });
        cbPlayerCountSelect.setOnAction(e ->   {
            if(cbMapSelect.getValue() != null && cbPlayerCountSelect.getValue() != null)
                bStart.setDisable(false);
            else
                bStart.setDisable(true);
        });
        cbLangSelect.setOnAction(e ->   {
            Language.Initialise(cbLangSelect.getValue());
            Main.ExitToMenu();
        });
    }

    /**
     * Megadja a kiválasztott játékosok számát
     * @return A kiválasztott játékosok
     */
    private int getPlayerCount() {
        int c = cbPlayerCountSelect.getValue().charAt(0)-'0';
        return c;
    }

    /**
     * Megadja a kiválasztott pálya fájlát
     * @return A kiválaszott fájl
     */
    private File getMapFile() {
        int i = cbMapSelect.getSelectionModel().getSelectedIndex();
        String mapPath = mapOptions.get(i).modelPath;
        return new File(Objects.requireNonNull(getClass().getClassLoader().getResource(mapPath)).getFile());
    }

    /**
     * Megadja a kiválasztott pálya layout fájlát
     * @return A kiválaszott layout fájl
     */
    private File getMapLayoutFile() {
        int i = cbMapSelect.getSelectionModel().getSelectedIndex();
        String mapPath = mapOptions.get(i).layoutPath;
        return new File(Objects.requireNonNull(getClass().getClassLoader().getResource(mapPath)).getFile());
    }

    /**
     * Létrehozza és inicializálja a menüt
     */
    public MenuScene() {
        super(new StackPane(),260, 300);
        initialize();
        setRoot(root);
    }


}
