package scene;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialog {
    public static PrintStream OutStream = System.out;
    public static Scanner InStream = new Scanner(System.in);

    private String question;
    private ArrayList<String> options;

    public Dialog(String question, ArrayList<String> options) {
        this.question = question;
        this.options = options;
    }

    public int Show() {
        while (true) {
            OutStream.println(question);
            for (int i = 0; i < options.size(); i++)
                OutStream.println(String.valueOf(i) + ": " + options.get(i));

            String sAns = InStream.nextLine();
            int iAns = Integer.parseInt(sAns);

            if (iAns > 0 && iAns < options.size())
                break;
            else
                OutStream.println("Invalid answer.");

            return iAns;
        }
        return 0;
    }





}
