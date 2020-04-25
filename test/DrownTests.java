import main.Main;
import org.junit.Test;
import scene.GameController;
import scene.writer.SceneWriter;

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
        SceneWriter.OutStream = GameController.OutStream;

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
        addCommand("p skip");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Fell into hole",scanner.nextLine());
        assertEquals("Successful move: 1",scanner.nextLine());
        assertEquals("Skip",scanner.nextLine());
        assertEquals("Game Over",scanner.nextLine());
    }

}
