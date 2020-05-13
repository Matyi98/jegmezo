package main;

import scene.GameController;
import scene.reader.SceneReader;

import java.io.*;
import java.util.Scanner;

/**
 * A program belépési pontja.
 * Teszt esetek indítása után beolvassa a megfelelő pályát.
 */
public class Main {

    /**
     * A program belépési pontja. Beolvassa a pályát,
     * majd átadja a GameControllernek az irányítást.
     * @param args A játék elindítása során megadott paraméterek.
     * @throws FileNotFoundException Nem található a pálya.
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("A program elindult. Szia Uram!");




//        final String pwd = System.getProperty("user.dir");
//        File f = new File(pwd+"/maps/map0.txt");
//        FileInputStream fis = new FileInputStream(f);
//
//        SceneReader sceneReader = new SceneReader(fis);
//        GameController gc = sceneReader.LoadScene();
//
//
//        System.out.println("\n\nPálya betöltve Sikeresen");
//
//        gc.ShowMap(true);
//
//        gc.Start(new Scanner(System.in));

        System.out.print("A program leáll, viszlát!");
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

}
