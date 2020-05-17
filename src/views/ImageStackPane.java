package views;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Képet tartalmazó nézetek ősosztálya.
 */
public abstract class ImageStackPane extends StackPane {
    /**
     * A megjelenítendő kép.
     */
    protected Image image;

    /**
     * Konstruktor.
     * @param imagePath A kép elérési útja.
     */
    public ImageStackPane(String imagePath) {
        image = null;
        try(InputStream is = Files.newInputStream(Paths.get(imagePath))){
            image = new Image(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
