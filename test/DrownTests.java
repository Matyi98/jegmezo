import main.Main;
import org.junit.Test;
import game.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Fuldoklást tesztelő tesztosztály.
 */
public class DrownTests {
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
     * Új játék létrehozása és annak elindítása a már létrehozott
     * bemeneti teszt adatfolyammal, majd a játék lezajlása közben
     * létrejött kimenet ellenőrzése az elvártakkal összehasonlítva.
     * @throws UnsupportedEncodingException Nem megfelelő a karakterkódolása
     * a bemeneti teszt adategységnek.
     */
    @Test
    public void Megfulladas() throws UnsupportedEncodingException {
        addCommand("tst loadmap fullad.txt");

        addCommand("p move");
        setInputString();

        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn",scanner.nextLine());
        assertEquals("A fell into hole",scanner.nextLine());
        assertEquals("A successful move: 1",scanner.nextLine());

        assertEquals("End of round",scanner.nextLine());
        assertEquals("A's turn",scanner.nextLine());
        assertEquals("A drowned",scanner.nextLine());
        assertEquals("Game Over",scanner.nextLine());
    }

}
