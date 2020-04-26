import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.Dialog;
import scene.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PlayerRescueTest {
    Scanner InStream;
    ByteArrayOutputStream baos;

    private void setInputString() throws UnsupportedEncodingException {
        GameController.OutStream = new PrintStream(
                baos = new ByteArrayOutputStream(), true,
                StandardCharsets.UTF_8.name()
        );

        InputStream targetStream = new ByteArrayInputStream(sInput.getBytes());
        InStream = new Scanner(targetStream);
        Dialog.InStream = InStream;
    }

    String sInput = "";
    private void addCommand(String s) {
        s = s.trim();
        sInput += s + '\n';
    }

    @Before
    public void initialise() throws UnsupportedEncodingException {
        addCommand("tst loadmap ropetest.txt");
        addCommand("p pickup");
        addCommand("p skip");
        addCommand("p move");
        addCommand("p use 0");
        addCommand("1");
        addCommand("s map");
        setInputString();
    }

    @Test
    public void test() {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn", scanner.nextLine());
        assertEquals("Rope picked up", scanner.nextLine());
        assertEquals("A skip", scanner.nextLine());
        assertEquals("B's turn", scanner.nextLine());
        assertEquals("B fell into hole", scanner.nextLine());
        assertEquals("B successful move: 2", scanner.nextLine());
        // Rope Dialog
        assertEquals("Successful rope usage", scanner.nextLine());
        assertEquals("S00KK; H0000; ", scanner.nextLine());

    }
}
