import main.Main;
import org.junit.Before;
import org.junit.Test;
import utility.Dialog;
import scene.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Hó lapáttal való ellepátolását tesztelő tesztosztály.
 */
public class ShovelingTest {
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

    /**
     * Bemeneti tesztvektor felállítása.
     * @throws UnsupportedEncodingException Nem megfelelő a karakterkódolása
     * a bemeneti teszt adategységnek.
     */
    @Before
    public void initialise() throws UnsupportedEncodingException {
        addCommand("tst loadmap shovelingtest.txt");
        addCommand("tst random");
        addCommand("p move");
        addCommand("p shovel");
        addCommand("p pickup");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("9");
        addCommand("9");
        addCommand("9");
        addCommand("9");
        addCommand("p use 0");
        addCommand("p pickup");
        addCommand("p use 1");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("p use 0");
        addCommand("9");
        addCommand("9");
        addCommand("9");
        addCommand("9");
        addCommand("p use 0");
        addCommand("p pickup");
        addCommand("s inv");
        addCommand("s map");
        setInputString();
    }

    /**
     * Új játék létrehozása és annak elindítása a már létrehozott
     * bemeneti teszt adatfolyammal, majd a játék lezajlása közben
     * létrejött kimenet ellenőrzése az elvártakkal összehasonlítva.
     */
    @Test
    public void test() {
        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());
        assertEquals("A's turn", scanner.nextLine());
        assertEquals("RNG: false", scanner.nextLine());
        assertEquals("A successful move: 2", scanner.nextLine());
        assertEquals("Successfully shoveled 1 layer of snow", scanner.nextLine());
        assertEquals("FragileShovel picked up", scanner.nextLine());
        assertEquals("A successful turn: 3", scanner.nextLine());
        assertEquals("A successful move: 3", scanner.nextLine());
        assertEquals("End of round", scanner.nextLine());
        assertEquals("A's turn", scanner.nextLine());
        assertEquals("Successfully shoveled 2 layer of snow", scanner.nextLine());
        assertEquals("Food picked up", scanner.nextLine());
        assertEquals("Failed food use", scanner.nextLine());
        assertEquals("A successful turn: 4", scanner.nextLine());
        assertEquals("A successful move: 4", scanner.nextLine());
        assertEquals("Successfully shoveled 2 layer of snow", scanner.nextLine());
        assertEquals("End of round", scanner.nextLine());
        assertEquals("A's turn", scanner.nextLine());
        assertEquals("Successfully shoveled 2 layer of snow", scanner.nextLine());
        assertEquals("Shovel picked up", scanner.nextLine());
        assertEquals("Inventory:", scanner.nextLine());
        assertEquals("0: Food", scanner.nextLine());
        assertEquals("1: Shovel", scanner.nextLine());
        assertEquals("S0000; S0000; S0000; S000K; ", scanner.nextLine());
    }
}
