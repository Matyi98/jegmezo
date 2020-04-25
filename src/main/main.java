package main;

import scene.GameController;
import scene.reader.SceneReader;

import java.io.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("A program elindult. Szia Uram!");

        final String pwd = System.getProperty("user.dir");
        File f = new File(pwd+"\\maps\\map0.txt");
        FileInputStream fis = new FileInputStream(f);

        SceneReader sceneReader = new SceneReader(fis);
        GameController gc = sceneReader.LoadScene();

        System.out.println("");
        System.out.println("");
        System.out.println("Pálya betöltve Sikeresen");

        gc.ShowMap();

        System.out.print("A program leáll, viszlát!");
    }
}
