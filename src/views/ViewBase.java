package views;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class ViewBase extends StackPane implements IView {
    protected Image image;

    public ViewBase(String imagePath) {


        Image img = null;
        try(InputStream is = Files.newInputStream(Paths.get(imagePath))){
            img = new Image(is);
        } catch (IOException e) {}

        ImageView imgView = new ImageView(img);

//        if (!imagePath.equals(""))
//            this.image = new Image(imagePath);
//        else
//            this.image = null;

        getChildren().add(imgView);
    }
}
