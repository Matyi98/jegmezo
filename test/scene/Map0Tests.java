package scene;

import main.Main;
import org.junit.Before;
import org.junit.Test;
import utility.Dialog;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Megrendelő által kért pályát  tesztelő tesztosztály.
 */
public class Map0Tests {
    Scanner InStream;
    ByteArrayOutputStream baos;

    /**
     * A bemeneti tesztvektort egybefűzi egy teszt adatfolyammá.
     * @throws UnsupportedEncodingException Nem megfelelő a karakterkódolása
     * a bemeneti teszt adategységnek.
     */
    private void setInputString() throws UnsupportedEncodingException {
        GameController.OutStream = new PrintStream(
                baos = new ByteArrayOutputStream(), true,
                StandardCharsets.UTF_8.name()
        );

        InputStream targetStream = new ByteArrayInputStream(sInput.getBytes());
        InStream = new Scanner(targetStream);
        Dialog.InStream = this.InStream;
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

        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("B's turn",scanner.nextLine());
        assertEquals("B successful turn: 5",scanner.nextLine());
        assertEquals("B successful move: 5",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00cE; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K; ",scanner.nextLine());
        assertEquals("B successful move: 2",scanner.nextLine());
        assertEquals("U20p0; S000ME; H0000; H0000; S00c0; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K; ",scanner.nextLine());
        assertEquals("HP: 5",scanner.nextLine());
        assertEquals("AP: 2",scanner.nextLine());
    }

    @Test
    public void MezoBeszakadasa() throws UnsupportedEncodingException {
        addCommand("tst random");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("p skip");
        addCommand("p skip");
        addCommand("p turn a");
        addCommand("p move");

        for (int i = 0; i < 13; i++)
            addCommand("0");

        addCommand("2");
        setInputString();

        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("B's turn",scanner.nextLine());
        assertEquals("RNG: false", scanner.nextLine());
        assertEquals("B successful turn: 13",scanner.nextLine());
        assertEquals("B successful move: 13",scanner.nextLine());
        assertEquals("B successful turn: 12",scanner.nextLine());
        assertEquals("B successful move: 12",scanner.nextLine());
        assertEquals("B skip",scanner.nextLine());
        assertEquals("C's turn",scanner.nextLine());
        assertEquals("C skip",scanner.nextLine());
        assertEquals("D's turn",scanner.nextLine());
        assertEquals("D successful turn: 12",scanner.nextLine());
        assertEquals("D fell into hole",scanner.nextLine());
        assertEquals("D successful move: 12",scanner.nextLine());
        assertEquals("End of round",scanner.nextLine());
        assertEquals("A successful move: 5",scanner.nextLine());
        assertEquals("B's turn",scanner.nextLine());
    }

    @Test
    public void JegesmedveFunkcionalitasa() throws UnsupportedEncodingException {
        addCommand("tst random");
        addCommand("p turn d");
        addCommand("p move");
        addCommand("p special");
        addCommand("p skip");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("p skip");
        addCommand("p move");
        addCommand("p skip");

        for (int i = 0; i < 13; i++)
            addCommand("0");

        addCommand("2");

        addCommand("p skip");
        addCommand("p skip");
        addCommand("p skip");

        for (int i = 0; i < 13; i++)
            addCommand("0");

        addCommand("5");
        setInputString();

        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("B's turn",scanner.nextLine());
        assertEquals("RNG: false", scanner.nextLine());
        assertEquals("B successful turn: 5", scanner.nextLine());
        assertEquals("B successful move: 5", scanner.nextLine());
        assertEquals("Successful IglooBuild", scanner.nextLine());
        assertEquals("B skip", scanner.nextLine());
        assertEquals("C's turn",scanner.nextLine());
        assertEquals("C successful turn: 13", scanner.nextLine());
        assertEquals("C successful move: 13", scanner.nextLine());
        assertEquals("C skip", scanner.nextLine());
        assertEquals("D's turn",scanner.nextLine());
        assertEquals("D successful move: 6", scanner.nextLine());
        assertEquals("D skip", scanner.nextLine());
        assertEquals("End of round", scanner.nextLine());
        // snow storm + bear dialog
        assertEquals("A successful move: 5", scanner.nextLine());
        assertEquals("B's turn",scanner.nextLine());
        assertEquals("B skip", scanner.nextLine());
        assertEquals("C's turn",scanner.nextLine());
        assertEquals("C skip", scanner.nextLine());
        assertEquals("D's turn",scanner.nextLine());
        assertEquals("D skip",scanner.nextLine());
        assertEquals("End of round", scanner.nextLine());
        // snow storm + bear dialog
        assertEquals("Game Over", scanner.nextLine());
        assertEquals("A successful move: 6", scanner.nextLine());
    }


    @Test
    public void EszkimoSpecKepessege() throws UnsupportedEncodingException {
        addCommand("p turn d");
        addCommand("p move");
        addCommand("p special");
        addCommand("s map");
        setInputString();

        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("B's turn",scanner.nextLine());
        assertEquals("B successful turn: 5",scanner.nextLine());
        assertEquals("B successful move: 5",scanner.nextLine());
        assertEquals("Successful IglooBuild",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00cEi; U3000; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K; ",scanner.nextLine());
    }
}
