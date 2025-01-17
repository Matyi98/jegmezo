import main.Main;
import org.junit.Test;
import utility.Dialog;
import game.GameController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Havazást tesztelő tesztosztály.
 */
public class HoviharTests {
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
    public void HoviharNoDMG() throws UnsupportedEncodingException {
        addCommand("tst loadmap stormtest.txt");
        addCommand("tst random");

        addCommand("p skip");
        addCommand("p pickup");
        addCommand("p use 0");
        addCommand("p skip");
        addCommand("p special");
        addCommand("p skip");
        addCommand("1");
        addCommand("1");
        addCommand("1");
        addCommand("s map");
        addCommand("s stats");
        setInputString();

        Main.NewCommandLineGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("A's turn", scanner.nextLine());
        assertEquals("RNG: false", scanner.nextLine());
        assertEquals("A skip",scanner.nextLine());
        assertEquals("B's turn", scanner.nextLine());
        assertEquals("Tent picked up",scanner.nextLine());
        assertEquals("Successful TentBuild",scanner.nextLine());
        assertEquals("B skip",scanner.nextLine());
        assertEquals("C's turn", scanner.nextLine());
        assertEquals("Successful IglooBuild",scanner.nextLine());
        assertEquals("C skip",scanner.nextLine());
        assertEquals("End of round", scanner.nextLine());
        assertEquals("A's turn", scanner.nextLine());
        //dialog here
        assertEquals("S020K; S000E; S000Ei; ",scanner.nextLine());
        assertEquals("HP: 3",scanner.nextLine());
        assertEquals("AP: 4",scanner.nextLine());

    }

}
