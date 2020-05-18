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

import java.io.IOException;
import java.io.InputStream;

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

    private Button bStart = new Button(Language.Selected().MenuStart());
    private Button bQuit = new Button(Language.Selected().MenuExit());
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
                    "2 "+ Language.Selected().Players(),
                    "3 "+ Language.Selected().Players(),
                    "4 "+ Language.Selected().Players(),
                    "5 "+ Language.Selected().Players(),
                    "6 "+ Language.Selected().Players()
            );

    /**
     * A pálya beállítására használható lista
     */
    private ObservableList<Map> mapOptions =
            FXCollections.observableArrayList(
                    new Map("Mega", "mega.txt", 6),
                    new Map("IIT fogsz meghalni!", "tanszeki.txt", 3),
                    new Map("Globális felmelegedés","floating.txt",2),
                    new Map("Konferencia", "konference.txt",6),
                    new Map("Россия", "russia.txt", 3),
                    new Map("DevRoom", "devroom.txt",2)
            );

    /**
     * Nyelvek listája
     */
    private ObservableList<Language.Languages> langOptions =
            FXCollections.observableArrayList(
                    Language.Languages.Magyar,
                    Language.Languages.English,
                    Language.Languages.Русский,
                    Language.Languages.Română
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
        aNumPlayerRow.getChildren().add(new Label(Language.Selected().MenuPlayerCount()));
        aNumPlayerRow.getChildren().add(cbPlayerCountSelect = new ComboBox<>(playerNumbers));

        //aMapInfoRow
        aMapInfoRow.setSpacing(5);
        aMapInfoRow.getChildren().add(new Label(Language.Selected().MenuSelectedMap()));
        aMapInfoRow.getChildren().add(cbMapSelect = new ComboBox<>(mapOptions));

        //aLanguage
        aLanguageRow.setSpacing(5);
        aLanguageRow.getChildren().add(new Label(Language.Selected().MenuChangeLang()));
        aLanguageRow.getChildren().add(cbLangSelect = new ComboBox<>(langOptions));
        cbLangSelect.getSelectionModel().select(Language.GetSelected());

        setCbChangeHandle();

        //aStartExitRow
        bStart.setOnMouseClicked(mouseEvent -> {
            Stage stage = ((Stage) getWindow());
            stage.setTitle(cbMapSelect.getValue().toString(getPlayerCount()));

            try(InputStream is = getMapFile()) {
                GameController.Initialise(is, getPlayerCount());
            }
            catch(IOException e){

            }

            try(InputStream is = getMapLayoutFile()){
                GameScene gs = new GameScene(is);
                stage.setScene(gs);
            }catch(IOException e){

            }
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
            Language.Select(cbLangSelect.getValue());
            Main.ExitToMenu();
        });
    }

    /**
     * Megadja a kiválasztott játékosok számát
     * @return A kiválasztott játékosok
     */
    private int getPlayerCount() {
        return cbPlayerCountSelect.getValue().charAt(0)-'0';
    }

    /**
     * Megadja a kiválasztott pálya fájlát
     * @return A kiválaszott fájl
     */
    private InputStream getMapFile() {
        int i = cbMapSelect.getSelectionModel().getSelectedIndex();
        String mapPath = "maps_release/"+mapOptions.get(i).modelPath;
        return getClass().getClassLoader().getResourceAsStream(mapPath);
    }

    /**
     * Megadja a kiválasztott pálya layout fájlát
     * @return A kiválaszott layout fájl
     */
    private InputStream getMapLayoutFile() {
        int i = cbMapSelect.getSelectionModel().getSelectedIndex();
        String mapPath = "maps_release/"+mapOptions.get(i).layoutPath;
        return getClass().getClassLoader().getResourceAsStream(mapPath);
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
