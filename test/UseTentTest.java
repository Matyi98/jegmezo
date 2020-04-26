import main.Main;
import org.junit.Test;
import scene.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class UseTentTest {
    Scanner InStream;
    ByteArrayOutputStream baos;

    private void setInputString() throws UnsupportedEncodingException {
        GameController.OutStream = new PrintStream(
                baos = new ByteArrayOutputStream(), true,
                StandardCharsets.UTF_8.name()
        );

        InputStream targetStream = new ByteArrayInputStream(sInput.getBytes());
        InStream = new Scanner(targetStream);
    }

    String sInput = "";
    private void addCommand(String s) {
        s = s.trim();
        sInput += s + '\n';
    }

    @Test
    public void SatorHasznalata() throws UnsupportedEncodingException {
        addCommand("tst loadmap sator.txt");
        addCommand("p pickup");
        addCommand("s inv");
        addCommand("p use 0");
        addCommand("s inv");
        addCommand("s stats");
        addCommand("s map");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn",scanner.nextLine());
        assertEquals("Tent picked up",scanner.nextLine());
        assertEquals("Inventory:",scanner.nextLine());
        assertEquals("0: Tent",scanner.nextLine());
        assertEquals("Successful TentBuild",scanner.nextLine());
        assertEquals("Inventory empty",scanner.nextLine());
        assertEquals("HP: 5",scanner.nextLine());
        assertEquals("AP: 2",scanner.nextLine());
        assertEquals("S000Et; S0000; ",scanner.nextLine());
    }
}
