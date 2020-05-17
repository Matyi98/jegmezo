package main;

import javafx.application.Application;
import javafx.stage.Stage;
import localization.Language;
import reader.SceneReader;
import utility.Dialog;
import views.scenes.MenuScene;

import java.io.*;
import java.util.Scanner;

/**
 * A program belépési pontja.
 * Teszt esetek indítása után beolvassa a megfelelő pályát.
 */
public class Main extends Application {

    /**
     * A program belépési pontja. Beolvassa a pályát,
     * majd átadja a GameControllernek az irányítást.
     * @param args A játék elindítása során megadott paraméterek.
     */
    public static void main(String[] args) {
        Language.Select(Language.Languages.Magyar);
        Dialog.AllowGUI = true;
        launch(args);
    }

    /**
     * Tesztelésnél e metódus olvassa be a pályát,
     * majd átadja a GameControllernek az irányítást.
     * @param stdin Bemeneti tesztvektor.
     */
    public static void NewCommandLineGame(Scanner stdin) {
        String first = stdin.nextLine();
        String sMap = first.trim().split(" ")[2];
        final String pwd = System.getProperty("user.dir");
        File f = new File(pwd+"/maps/"+ sMap);

        try {
            FileInputStream fis = new FileInputStream(f);
            SceneReader sceneReader = new SceneReader(fis);
            sceneReader.LoadScene().Start(stdin);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    /**
     * Fő ablak.
     */
    static private Stage stage;

    /**
     * Kilépés a menübe.
     */
    public static void ExitToMenu() {
        stage.setTitle("Jégmező by: The Council");
        stage.setScene(new MenuScene());
    }

    /**
     * JavaFX aplikáció belépési pont.
     * @param stage fő ablak
     */
    @Override
    public void start(Stage stage)  {
        stage.setResizable(false);
        Main.stage = stage;
        ExitToMenu();
        stage.show();
    }
}
