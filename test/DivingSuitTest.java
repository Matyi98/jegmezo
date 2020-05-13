import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Búvárruha és úszást tesztelő tesztosztály.
 */
public class DivingSuitTest {
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
        addCommand("tst loadmap suittest.txt");
        addCommand("p pickup");
        addCommand("p use 0");
        addCommand("p move");
        addCommand("p turn d");
        addCommand("p move");
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
        Main.NewTestGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn", scanner.nextLine());
        assertEquals("DivingSuit picked up", scanner.nextLine());
        assertEquals("A equiped DivingSuit", scanner.nextLine());
        assertEquals("A started swimming", scanner.nextLine());
        assertEquals("A successful move: 2", scanner.nextLine());
        assertEquals("A successful turn: 3", scanner.nextLine());
        assertEquals("A climbed out", scanner.nextLine());
        assertEquals("A successful move: 3", scanner.nextLine());
        assertEquals("S0000; H0000; S000K; ", scanner.nextLine());
    }
}
