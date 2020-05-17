package views;

import entities.Entity;
import game.GameController;
import javafx.scene.image.ImageView;

/**
 * Entitások (medve, játékos) megjelenítésért felel.
 */
public class EntityView extends ImageStackPane {
    /**
     * Az a modell beli elem, aminek a nézete ez.
     */
    private Entity data;

    /**
     * Megjelenítendő kép mérete.
     */
    private final int dimensions = 50;

    /**
     * Konstruktor.
     * @param e Az az entity, amit megjelenít.
     */
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

    /**
     * Bekeretezés beállítása annak alapján, hogy ez-e az aktuális játékos.
     */
    private void selectIfActive(){
        if(GameController.GetInstance().GetActivePlayer() == data){
            enableBorder();
        }
        else{
            disableBorder();
        }
    }

    /**
     * Bekeretezés eltüntetése.
     */
    private void disableBorder(){
        setStyle( "-fx-border-style: solid inside;" +
                "-fx-border-width: 0;" +
                "-fx-border-radius: 10;" +
                "-fx-border-color: green;");
    }

    /**
     * Bekeretezés megjelenítése.
     */
    private void enableBorder(){
        setStyle("-fx-border-style: solid inside;"+
                "-fx-border-width: 3;" +
                "-fx-border-radius: 10;" +
                "-fx-border-color: green;");
    }

}
