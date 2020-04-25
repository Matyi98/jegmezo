package scene;

import org.junit.Before;
import org.junit.Test;
import scene.reader.SceneReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SequenceTest1 {
    GameController gc;

    @Before
    public void initialise() throws FileNotFoundException {
        final String pwd = System.getProperty("user.dir");
        File f = new File(pwd+"/maps/map0.txt");
        FileInputStream fis = new FileInputStream(f);

        SceneReader sceneReader = new SceneReader(fis);
        gc = sceneReader.LoadScene();
    }

    @Test
    public void test() {

    }


}
