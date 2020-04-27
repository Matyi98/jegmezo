import main.Main;
import org.junit.Before;
import org.junit.Test;
import scene.Dialog;
import scene.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Hó lapátolást tesztelő tesztosztály.
 */
public class DigingTest {
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
        addCommand("tst loadmap digingtest.txt");
        addCommand("tst random");
        addCommand("p dig");
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
        assertEquals("Successfully digged 1 layer of snow", scanner.nextLine());
        assertEquals("S010K; S01g0; ", scanner.nextLine());
    }
}
