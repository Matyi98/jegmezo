import main.Main;
import org.junit.Before;
import org.junit.Test;
import game.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Győzelmet tesztelő tesztosztály.
 */
public class QuestItemTest {
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
        addCommand("tst loadmap quest.txt");
        addCommand("p pickup");
        addCommand("p move");
        addCommand("p skip");
        addCommand("p pickup");
        addCommand("p move");
        addCommand("p use 0");
        addCommand("p skip");
        addCommand("p pickup");
        addCommand("p use 0");

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
        assertEquals("Pistol picked up", scanner.nextLine());
        assertEquals("A successful move: 3", scanner.nextLine());
        assertEquals("A skip", scanner.nextLine());
        assertEquals("B's turn", scanner.nextLine());
        assertEquals("Flare picked up", scanner.nextLine());
        assertEquals("B successful move: 3", scanner.nextLine());
        assertEquals("Quest item used", scanner.nextLine());
        assertEquals("Win conditions not met", scanner.nextLine());
        assertEquals("B skip", scanner.nextLine());
        assertEquals("C's turn", scanner.nextLine());
        assertEquals("Cartridge picked up", scanner.nextLine());
        assertEquals("Quest item used", scanner.nextLine());
        assertEquals("Victory", scanner.nextLine());
    }
}
