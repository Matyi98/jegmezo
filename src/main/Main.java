package main;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.GameController;
import scene.reader.SceneReader;
import views.scenes.MainScene;
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
     * @throws FileNotFoundException Nem található a pálya.
     */
    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }

    /**
     * Tesztelésnél e metódus olvassa be a pályát,
     * majd átadja a GameControllernek az irányítást.
     * @param stdin Bemeneti tesztvektor.
     */
    public static void NewGame(Scanner stdin) {
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

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JegmezoMenu");
        stage.setScene(new MenuScene());
        stage.show();
    }
}
