import main.Main;
import org.junit.Test;
import scene.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DrownTests {
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
    public void Megfulladas() throws UnsupportedEncodingException {
        addCommand("tst loadmap fullad.txt");

        addCommand("p move");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn",scanner.nextLine());
        assertEquals("A fell into hole",scanner.nextLine());
        assertEquals("A successful move: 1",scanner.nextLine());

        assertEquals("End of round",scanner.nextLine());
        assertEquals("A's turn",scanner.nextLine());
        assertEquals("A drowned",scanner.nextLine());
        assertEquals("Game Over",scanner.nextLine());
    }

}
