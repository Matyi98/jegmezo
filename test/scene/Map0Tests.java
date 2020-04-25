package scene;

import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.reader.SceneReader;
import scene.writer.SceneWriter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Map0Tests {
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
        addCommand("tst loadmap map0.txt");
        addCommand("p turn d");
        addCommand("p move");
        addCommand("s map");
        addCommand("p move");
        addCommand("s map");
        addCommand("s stats");

        setInputString();
    }

    @Test
    public void AltalanosFunkciok() throws UnsupportedEncodingException {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Successful turn: 5",scanner.nextLine());
        assertEquals("Successful move: 5",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00cE; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K;",scanner.nextLine());
        assertEquals("Successful move: 2",scanner.nextLine());
        assertEquals("U20p0; S000ME; H0000; H0000; S00c0; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K",scanner.nextLine());
        assertEquals("HP: 5",scanner.nextLine());
        assertEquals("AP: 2",scanner.nextLine());
    }

    @Test
    public void MezoBeszakadasa() throws UnsupportedEncodingException {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Successful turn: 5",scanner.nextLine());
        assertEquals("Successful move: 5",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00cE; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K;",scanner.nextLine());
        assertEquals("Successful move: 2",scanner.nextLine());
        assertEquals("U20p0; S000ME; H0000; H0000; S00c0; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K",scanner.nextLine());
        assertEquals("HP: 5",scanner.nextLine());
        assertEquals("AP: 2",scanner.nextLine());
    }
}
