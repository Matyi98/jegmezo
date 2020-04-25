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

    private void setInputString(String s) {
        InputStream targetStream = new ByteArrayInputStream(s.getBytes());
        InStream = new Scanner(targetStream);
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

        setInputString("p turn a\np move\ns map\np move\np move\ns map\ns stats");
    }

    @Test
    public void test1() throws UnsupportedEncodingException {
        gc.Start(InStream);
        System.out.println(baos.toString(StandardCharsets.UTF_8.name()));
    }


}
