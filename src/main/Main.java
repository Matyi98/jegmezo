package main;

import scene.GameController;
import scene.reader.SceneReader;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("A program elindult. Szia Uram!");

        final String pwd = System.getProperty("user.dir");
        File f = new File(pwd+"/maps/map0.txt");
        FileInputStream fis = new FileInputStream(f);

        SceneReader sceneReader = new SceneReader(fis);
        GameController gc = sceneReader.LoadScene();

        System.out.println("");
        System.out.println("");
        System.out.println("Pálya betöltve Sikeresen");

        gc.ShowMap(false);

        System.out.print("A program leáll, viszlát!");
    }

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
