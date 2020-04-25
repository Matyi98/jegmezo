package scene;

import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.reader.SceneReader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SequenceTest1 {
    GameController gc;
    Scanner InStream;
    ByteArrayOutputStream baos;

    private void setInputString() {
        InputStream targetStream = new ByteArrayInputStream(sInput.getBytes());
        InStream = new Scanner(targetStream);
    }

    String sInput;
    private void addCommand(String s) {
        s = s.trim();
        sInput += s + '\n';
    }

    @Before
    public void initialise() throws FileNotFoundException, UnsupportedEncodingException {
        GameController.OutStream = new PrintStream(
                baos = new ByteArrayOutputStream(), true,
                StandardCharsets.UTF_8.name()
        );

        addCommand("tst loadmap map0.txt");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("s map");
        addCommand("p move");
        addCommand("s map");
        addCommand("s stats");

        setInputString();
    }

    @Test
    public void test1() throws UnsupportedEncodingException {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        scanner.nextLine();
    }


}
