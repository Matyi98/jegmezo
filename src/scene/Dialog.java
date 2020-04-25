package scene;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialog {
    /**
     * Kimeneti folyam. Erre a folyamra írnak a dialógusok.
     */
    public static PrintStream OutStream = System.out;
    /**
     * Bemeneti folyam. Erről a folyamról várnak inputot a dialógusok.
     */
    public static Scanner InStream = new Scanner(System.in);

    private String question;
    private ArrayList<String> options;


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
        while (true) {
            OutStream.println(question);
            for (int i = 0; i < options.size(); i++)
                OutStream.println(String.valueOf(i) + ": " + options.get(i));

            String sAns = InStream.nextLine();
            int iAns = Integer.parseInt(sAns);

            if (iAns > 0 && iAns < options.size())
                return iAns;
            else
                OutStream.println("Invalid answer.");
        }
    }





}
