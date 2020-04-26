import org.junit.Before;
import org.junit.Test;
import scene.Dialog;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DialogTest {

    Dialog d;

    private void setInputString(String s) {
        InputStream targetStream = new ByteArrayInputStream(s.getBytes());
        Dialog.InStream = new Scanner(targetStream);
    }


    /*
    How to USE:
        String question = "What is your favourite colour?";
        ArrayList<String> options = new ArrayList<>();
        options.add("red");
        options.add("green");
        options.add("blue");

        d = new Dialog(question,options);
        d.ShowDialog();   <- ki fogja írni a kérdést és a válaszokat is.
                                     Addig nem lép tovább, míg a specifikált folyamon nem kap értelmes választ.
    */

    @Before
    public void init() {
        String question = "What is your favourite colour?";
        ArrayList<String> options = new ArrayList<>();
        options.add("red");
        options.add("green");
        options.add("blue");

        d = new Dialog(question,options);
    }

    @Test
    public void red() {
        String input = "0";
        setInputString(input);

        assertEquals(0, d.ShowDialog());
    }

    @Test
    public void green() {
        String input = "1";
        setInputString(input);

        assertEquals(1, d.ShowDialog());
    }


}