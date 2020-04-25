import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.GameController;
import scene.writer.SceneWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class QuestItemTest {
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
        addCommand("tst loadmap quest.txt");
        addCommand("p pickup");
        addCommand("p move");
        addCommand("p move");
        addCommand("p skip");
        addCommand("p pickup");
        addCommand("p move");
        addCommand("p skip");
        addCommand("p pickup");
        addCommand("p use 0");

        setInputString();
    }

    @Test
    public void test() {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Pistol picked up", scanner.nextLine());
        assertEquals("Successful move: 2", scanner.nextLine());
        assertEquals("Successful move: 3", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Flare picked up", scanner.nextLine());
        assertEquals("Successful move: 3", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Cartridge picked up", scanner.nextLine());
        assertEquals("Quest item used", scanner.nextLine());
        assertEquals("Victory", scanner.nextLine());
    }
}
