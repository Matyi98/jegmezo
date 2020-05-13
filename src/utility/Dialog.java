package utility;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import scene.Board;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Dialógus osztály, amely lehetővé teszi, hogy előre megadott opciók közül
 * a felhasználó kiválassza a neki tetsző opciót.
 */
public class Dialog {
    /**
     * Kimeneti folyam. Erre a folyamra írnak a dialógusok.
     */
    public static PrintStream OutStream = System.out;
    /**
     * Bemeneti folyam. Erről a folyamról várnak inputot a dialógusok.
     */
    public static Scanner InStream = new Scanner(System.in);

    /**
     * Felhasználóhoz szegezett kérdés.
     */
    private String question;

    /**
     * Kérdésre adható válaszok.
     */
    private ArrayList<String> options;

    public static boolean AllowGUI = false;


    /**
     * Létrehoz egy új dialógust.
     * @param question A feltett kérdés.
     * @param options A lehetséges válaszok.
     */
    public Dialog(String question, ArrayList<String> options) {
        this.question = question;
        this.options = options;
    }


    /**
     * Kiírja a kérdést és a lehetséges opciókat. Számmal kell válaszolni az input streamen.
     * @return A kiválasztott menüpont.
     */
    public int ShowDialog() {
        if (AllowGUI)
            return showGUI();
        else
            return showNoGUI();
    }

    private int showNoGUI() {
        while (true) {
            OutStream.println(question);
            for (int i = 0; i < options.size(); i++)
                OutStream.println(String.valueOf(i) + ": " + options.get(i));

            String sAns = InStream.nextLine();
            int iAns = Integer.parseInt(sAns);

            if (iAns >= 0 && iAns < options.size())
                return iAns;
            else
                OutStream.println("Invalid answer.");
        }
    }

    private int showGUI() {
        AtomicInteger selected = new AtomicInteger();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");

        StackPane root = new StackPane();
        root.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label lQuestion = new Label(question);
        StackPane.setAlignment(lQuestion, Pos.TOP_LEFT);
        StackPane.setMargin(lQuestion, new Insets(8));
        root.getChildren().add(lQuestion);
        for (int i = 0; i < options.size(); i++) {
            String s = options.get(i);
            Button b = new Button(s);
            int finalI = i;
            b.setOnMouseClicked(mouseEvent -> {
                selected.set(finalI);
                stage.close();
            });

            StackPane.setAlignment(b, Pos.TOP_CENTER);
            StackPane.setMargin(b, new Insets(40*(i+1),0,0,0));
            root.getChildren().add(b);
        }

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(new Scene(root, 160, (options.size()+1)*40));
        stage.showAndWait();

        System.out.println(selected.get());
        return selected.get();
    }

}
