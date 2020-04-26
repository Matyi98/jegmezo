import main.Main;
import org.junit.Test;
import scene.GameController;
import scene.writer.SceneWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class UseTentTest {
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

    @Test
    public void SatorHasznalata() throws UnsupportedEncodingException {
        //TODO: helyesen implementálni ezt a tesztet.

        addCommand("tst loadmap sator.txt");

        addCommand("p special");
        addCommand("s map");
        setInputString();

        Main.NewGame(InStream);
        Scanner scanner = new Scanner(baos.toString());
        System.out.println(baos.toString());

        assertEquals("Successful TentBuild",scanner.nextLine());
        assertEquals("U20p0; S000M; H0000; H0000; S00c0; U300Ei; H0000; S00e0; S00s0; H0000; H0000; U200K; S000K;",scanner.nextLine());
    }
}
