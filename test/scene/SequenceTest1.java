package scene;

import org.junit.Before;
import org.junit.Test;
import scene.reader.SceneReader;

import java.io.*;
import java.util.Scanner;

public class SequenceTest1 {
    GameController gc;
    Scanner InStream;

    private void setInputString(String s) {
        InputStream targetStream = new ByteArrayInputStream(s.getBytes());
        InStream = new Scanner(targetStream);
    }

    @Before
    public void initialise() throws FileNotFoundException {
        final String pwd = System.getProperty("user.dir");
        File f = new File(pwd+"/maps/map0.txt");
        FileInputStream fis = new FileInputStream(f);

        SceneReader sceneReader = new SceneReader(fis);
        gc = sceneReader.LoadScene();

        setInputString("");

    }

    @Test
    public void test() {
        gc.Start(InStream);
    }


}
