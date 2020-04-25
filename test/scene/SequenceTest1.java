package scene;

import org.junit.Before;
import org.junit.Test;
import scene.reader.SceneReader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import java.io.*;
import java.util.Scanner;

public class SequenceTest1 {
    GameController gc;
    Scanner InStream;
    ByteArrayOutputStream baos;

    private void setInputString() {
        InputStream targetStream = new ByteArrayInputStream(sInput.getBytes());
        InStream = new Scanner(targetStream);
    }

    String sInput;
    private void addCommand(String s) {
        s = s.trim();
        sInput += s;
    }

    @Before
    public void initialise() throws FileNotFoundException, UnsupportedEncodingException {
        final String pwd = System.getProperty("user.dir");
        File f = new File(pwd+"/maps/map0.txt");
        FileInputStream fis = new FileInputStream(f);

        SceneReader sceneReader = new SceneReader(fis);
        gc = sceneReader.LoadScene();

        GameController.OutStream = new PrintStream(
                baos = new ByteArrayOutputStream(), true,
                StandardCharsets.UTF_8.name()
        );

        addCommand("tst loadmap map0.txt");
        addCommand("p turn a");
        addCommand("p move");
        addCommand("s map");
        addCommand("p move");
        addCommand("s map");
        addCommand("s stats");

        setInputString();
    }

    @Test
    public void test1() throws UnsupportedEncodingException {
        gc.Start(InStream);
        System.out.println(baos.toString(StandardCharsets.UTF_8.name()));
    }


}
