package views;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
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
     * @param img hivatkozás a képre
     */
    public ImageStackPane(Image img) {
        image = img;
    }
}
