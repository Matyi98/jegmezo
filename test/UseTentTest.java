import main.Main;
import org.junit.Test;
import utility.Dialog;
import game.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Sátor építést tesztelő tesztosztály.
 */
public class UseTentTest {
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
     * Új játék létrehozása és annak elindítása a már létrehozott
     * bemeneti teszt adatfolyammal, majd a játék lezajlása közben
     * létrejött kimenet ellenőrzése az elvártakkal összehasonlítva.
     * @throws UnsupportedEncodingException Nem megfelelő a karakterkódolása
     * a bemeneti teszt adategységnek.
     */
    @Test
    public void SatorHasznalata() throws UnsupportedEncodingException {
        addCommand("tst loadmap sator.txt");
        addCommand("tst random");
        addCommand("p pickup");
        addCommand("s inv");
        addCommand("p use 0");
        addCommand("s inv");
        addCommand("s stats");
        addCommand("s map");
        addCommand("p skip");
        addCommand("1");
        addCommand("1");
        addCommand("s map");
        addCommand("s stats");
        setInputString();

        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn",scanner.nextLine());
        assertEquals("RNG: false", scanner.nextLine());
        assertEquals("Tent picked up",scanner.nextLine());
        assertEquals("Inventory:",scanner.nextLine());
        assertEquals("0: Tent",scanner.nextLine());
        assertEquals("Successful TentBuild",scanner.nextLine());
        assertEquals("Inventory empty",scanner.nextLine());
        assertEquals("HP: 5",scanner.nextLine());
        assertEquals("AP: 2",scanner.nextLine());
        assertEquals("S000Et; S0000; ",scanner.nextLine());
        assertEquals("A skip",scanner.nextLine());
        assertEquals("End of round",scanner.nextLine());
        assertEquals("A's turn",scanner.nextLine());
        assertEquals("S000E; S0200; ",scanner.nextLine());
        assertEquals("HP: 5",scanner.nextLine());
        assertEquals("AP: 4",scanner.nextLine());
    }
}
