import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.GameController;
import scene.writer.SceneWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ShovelingTest {
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

    @Before
    public void initialise() throws UnsupportedEncodingException {
        addCommand("tst loadmap shovelingtest.txt");
        addCommand("p move");
        addCommand("p shovel");
        addCommand("p pickup");
        addCommand("p move");
        addCommand("p use 0");
        addCommand("p pickup");
        addCommand("p use 1");
        addCommand("p pickup");
        addCommand("s map");
        addCommand("p move");
        setInputString();
    }

    @Test
    public void test() {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Successful move: 2", scanner.nextLine());
        assertEquals("Successfully shoveled 1 layer of snow", scanner.nextLine());
        assertEquals("picked up fragile shovel", scanner.nextLine());
        assertEquals("Successful move: 3", scanner.nextLine());
        assertEquals("Successfully shoveled 2 layer of snow", scanner.nextLine());
        assertEquals("picked up food", scanner.nextLine());
        assertEquals("Failed food use", scanner.nextLine());
        assertEquals("Successful move: 4", scanner.nextLine());
        assertEquals("Successfully shoveled 2 layer of snow", scanner.nextLine());
        assertEquals("Failed food use", scanner.nextLine());
        assertEquals("Picked up shovel", scanner.nextLine());
        assertEquals("S0000; S0000; S0000; S000K;", scanner.nextLine());

    }
}
