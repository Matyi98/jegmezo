package scene;

import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.writer.SceneWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
    public void initialise() {
        addCommand("tst loadmap map0.txt");
    }

    @Test
    public void AltalanosFunkciok() throws UnsupportedEncodingException {
        addCommand("p turn d");
        addCommand("p move");
        addCommand("s map");
        addCommand("p move");
        addCommand("s map");
        addCommand("s stats");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Successful turn: 5",scanner.nextLine());
        assertEquals("Successful move: 5",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00cE; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K; ",scanner.nextLine());
        assertEquals("Successful move: 2",scanner.nextLine());
        assertEquals("U20p0; S000ME; H0000; H0000; S00c0; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K; ",scanner.nextLine());
        assertEquals("HP: 5",scanner.nextLine());
        assertEquals("AP: 2",scanner.nextLine());
    }

    @Test
    public void MezoBeszakadasa() throws UnsupportedEncodingException {
        addCommand("p turn d");
        addCommand("p turn d");
        addCommand("p turn d");
        addCommand("p move");
        addCommand("p turn a");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("p skip");
        addCommand("p skip");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("s map");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Successful turn: 5",scanner.nextLine());
        assertEquals("Successful turn: 7",scanner.nextLine());
        assertEquals("Successful turn: 10",scanner.nextLine());
        assertEquals("Successful move: 10",scanner.nextLine());
        assertEquals("Successful turn: 13",scanner.nextLine());
        assertEquals("Successful turn: 12",scanner.nextLine());
        assertEquals("Successful move: 12",scanner.nextLine());
        assertEquals("Skip",scanner.nextLine());
        assertEquals("Skip",scanner.nextLine());

        assertEquals("Successful turn: 12",scanner.nextLine());
        assertEquals("Successful move: 12",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00c0; U3000; H0000; S00e0; S00s0; H0000; H0000; U200KEK; S0000;",scanner.nextLine());
        assertEquals("Game Over",scanner.nextLine());


    }

    @Test
    public void JegesmedveFunkcionalitasa() throws UnsupportedEncodingException {
        addCommand("tst random");
        addCommand("p special");
        addCommand("p skip");
        addCommand("p turn d");
        addCommand("p turn d");
        addCommand("p move");
        addCommand("p skip");
        addCommand("p move");
        addCommand("p skip");
        addCommand("5");
        addCommand("p skip");
        addCommand("p skip");
        addCommand("p skip");
        addCommand("6");
        addCommand("p skip");
        addCommand("p skip");
        addCommand("p skip");
        addCommand("13");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("RNG: off", scanner.nextLine());
        assertEquals("Successful IglooBuild", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Successful turn: 10", scanner.nextLine());
        assertEquals("Successful turn: 13", scanner.nextLine());
        assertEquals("Successful move: 13", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Successful move: 6", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        // bear dialog
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        // bear dialog
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        assertEquals("Skip", scanner.nextLine());
        assertEquals("U20p0; S0000; H0000; H0000; S00c0; U300EKMi; H0000; S00e0; S00s0; H0000; H0000; U2000; S000K", scanner.nextLine());
        // bear dialog
        assertEquals("Game Over", scanner.nextLine());
    }


    @Test
    public void EszkimoSpecKepessege() throws UnsupportedEncodingException {
        addCommand("p special");
        addCommand("s map");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Successful IglooBuild",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00c0; U300Ei; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K;",scanner.nextLine());
    }
}
