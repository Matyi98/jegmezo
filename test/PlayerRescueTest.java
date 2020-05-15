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
 * Játékostárs megmentést tesztelő tesztosztály.
 */
public class PlayerRescueTest {
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
        Dialog.InStream = InStream;
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
        addCommand("tst loadmap ropetest.txt");
        addCommand("tst random");
        addCommand("p pickup");
        addCommand("p skip");
        addCommand("p move");
        addCommand("9");
        addCommand("9");
        addCommand("p use 0");
        addCommand("0");
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
        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn", scanner.nextLine());
        assertEquals("RNG: false",scanner.nextLine());
        assertEquals("Rope picked up", scanner.nextLine());
        assertEquals("A skip", scanner.nextLine());
        assertEquals("B's turn", scanner.nextLine());
        assertEquals("B fell into hole", scanner.nextLine());
        assertEquals("B successful move: 2", scanner.nextLine());
        assertEquals("End of round", scanner.nextLine());
        // Blizzard random dialog
        assertEquals("A's turn", scanner.nextLine());
        // Rope Dialog
        assertEquals("B rescued", scanner.nextLine());
        assertEquals("S000KK; H0000; ", scanner.nextLine());

    }
}
