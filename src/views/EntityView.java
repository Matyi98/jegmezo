package views;

import entities.Entity;
import game.GameController;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;

public class EntityView extends ViewBase {
    private Entity data;
    private final int dimensions = 50;

    public EntityView(Entity e) {
        super(e.GetTexturePath());
        this.data = e;

        setMaxHeight(dimensions);

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(dimensions);
        imageView.setFitWidth(dimensions);
        imageView.setPreserveRatio(true);

        getChildren().add(imageView);

        selectIfActive();
    }

    //Lehet nem is kell használni?
    @Override
    public void Update() {

    }

    private void selectIfActive(){
        if(GameController.GetInstance().GetActivePlayer() == data){
            enableBorder();
        }
        else{
            disableBorder();
        }
    }

    private void disableBorder(){
        setStyle( "-fx-border-style: solid inside;" +
                "-fx-border-width: 0;" +
                "-fx-border-radius: 10;" +
                "-fx-border-color: green;");
    }

    private void enableBorder(){
        setStyle("-fx-border-style: solid inside;"+
                "-fx-border-width: 4;" +
                "-fx-border-radius: 10;" +
                "-fx-border-color: green;");
    }

}
