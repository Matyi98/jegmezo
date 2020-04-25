package scene.reader;

import org.junit.Before;
import org.junit.Test;
import scene.GameController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class SceneReaderTest {
    GameController gc;

    @Before
    public void initialise() throws FileNotFoundException {
        final String pwd = System.getProperty("user.dir");
        File f = new File(pwd+"\\maps\\map0.txt");
        FileInputStream fis = new FileInputStream(f);

        SceneReader sceneReader = new SceneReader(fis);
        gc = sceneReader.LoadScene();
    }



    @Test
    public void loadScene() throws FileNotFoundException {
        assertNotNull(gc);
    }




}