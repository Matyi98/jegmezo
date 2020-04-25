package scene;

import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.writer.SceneWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DivingSuitTest {
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
        addCommand("tst loadmap suittest.txt");
        addCommand("p pickup");
        addCommand("p use 0");
        addCommand("p move");
        addCommand("p move");
        addCommand("s map");
        setInputString();
    }

    @Test
    public void test() {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Diving suit picked up", scanner.nextLine());
        assertEquals("Diving suit used", scanner.nextLine());
        assertEquals("Successful move: 2", scanner.nextLine());
        assertEquals("Successful move: 3", scanner.nextLine());
        assertEquals("S0000; H0000; S000K", scanner.nextLine());
    }
}
