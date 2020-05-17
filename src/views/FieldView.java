package views;

import entities.Entity;
import fields.Field;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * A Játékban lévő Fieldek megjelenítésért felős osztály.
 * Ezen osztályból képzett példány tartalmazza a megjelenésben
 * rajta lévő más megjelenítést szolgáló osztályok példányokat.
 */
public class FieldView extends ImageStackPane {
    /**
     * Azon Fieldre referencia, amely Field megjelenítésért felelős
     * ezen osztály aktuális példánya.
     */
    private Field data;

    /**
     * A képernyőn megjelelő kör alakó Field sugara.
     */
    private final int radius;

    /**
     * FielViewhoz tartozó Filden lévő Itemnek a kinézetéért
     * felőlős ItemView.
     */
    private ItemView itemView = null;

    /**
     * FielViewhoz tartozó Filden lévő Entityk a kinézetéért
     * felőlős ItemView.
     */
    private ArrayList<EntityView> entityViews = new ArrayList<>();

    /**
     * Vertikális konténer, amely azon sorokat tartalmazza, amely
     * sorok a FildViewn lévő EntityViewkat tárolják.
     */
    private VBox entityLayoutContainer = new VBox(2);

    /**
     * Horizontális konténer, amely a FildViewn lévő EntityViewkból
     * az első hármat tárolja felső sorként.
     */
    private HBox firstRow = new HBox(2);
    /**
     * Horizontális konténer, amely a FildViewn lévő EntityViewkból
     * az első hármat tárolja felső sorként.
     */
    private HBox secondRow = new HBox(2);

    /**
     * Konstruktor.
     * @param f Azon Field amelyiknek a megjelenéséért felőlős.
     * @param radius A képernyőn megjelelő kör alakó Field sugara.
     */
    public FieldView(Field f, int radius) {
        super(f.GetTexturePath());
        this.radius = radius;
        this.data = f;
        initialise();
    }

    /**
     * Inicializálja a FieldViewn lévő más megjelenítést
     * szolgáló elemeket.
     */
    private void initialise(){
        Circle cMain = new Circle(0, 0, radius);
        cMain.setFill(new ImagePattern(image));
        getChildren().add(cMain);

        refreshBuildings();
        refreshItem();
        refreshEntities();

        entityLayoutContainer.getChildren().addAll(firstRow, secondRow);
        entityLayoutContainer.setTranslateY(-20);
        getChildren().addAll(entityLayoutContainer);
    }

    /**
     * A Fildek állapotát jelőlő kis ICON szerű kép
     * létrehozása, amennyibe arra szükség van, azaz
     * ha a Field állapota nem Standard.
     */
    private void refreshBuildings(){
        if(data.GetStateTexturePath() != null) {
            Circle cState = new Circle(0, 0, radius * 0.30);
            cState.setFill(Color.BLACK);
            StackPane.setAlignment(cState, Pos.BOTTOM_LEFT);
            cState.setTranslateX(-10);
            String imagePath = data.GetStateTexturePath();

            Image stateImage = null;
            try(InputStream is = Files.newInputStream(Paths.get(imagePath))){
                stateImage = new Image(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cState.setFill(new ImagePattern(stateImage));
            cState.setStrokeWidth(2);
            cState.setStroke(Color.rgb(40, 40, 60));
            cState.setScaleX(1.2);
            cState.setScaleY(1.2);
            getChildren().add(cState);
        }
    }

    /**
     * FielViewhoz tartozó Filden lévő Itemnek a kinézetét tölti be.
     */
    private void refreshItem(){
        getChildren().remove(itemView);

        if(data.getItem() != null){
            itemView = new ItemView(data.getItem());
            setItemViewOpacity();
            itemView.setAlignment(Pos.BOTTOM_CENTER);
            itemView.setOnMouseEntered(e -> {
                itemView.setScaleX(1.2);
                itemView.setScaleY(1.2);
            });
            itemView.setOnMouseExited(e -> {
                itemView.setScaleX(1.0);
                itemView.setScaleY(1.0);

            });
            getChildren().add(itemView);
        }
    }

    /**
     * A FielViewhoz tartozó Filden lévő Itemnek a kinézetét átlátszóságát állítja
     * annak függvényében, hogy a Filden mennyi hú van.
     */
    private void setItemViewOpacity(){
        double intensity = 6;
        itemView.setOpacity(Math.pow(
                ((double)(Field.getMaxSnowLevel()-data.getSnowLevel())
                        /(double)Field.getMaxSnowLevel())
                , intensity));
    }

    /**
     * FielViewhoz tartozó Filden lévő Entityk kinézetét tölti be.
     */
    private void refreshEntities() {
        for (EntityView view : entityViews) {
            firstRow.getChildren().remove(view);
            secondRow.getChildren().remove(view);
        }

        entityViews.clear();

        for (Entity entity : data.getEntities()) {
            EntityView entityView = new EntityView(entity);
            entityViews.add(entityView);
            if(firstRow.getChildren().size() < 3)
                firstRow.getChildren().add(entityView);
            else
                secondRow.getChildren().add(entityView);
        }
    }

    /**
     * Egy kört rajzol azon FildView köré, amelyik
     * FildView Fildje felé néz az aktuális Player.
     */
    public void showSelect(){
        Circle selectionCircle = new Circle(0, 0, radius + 5);
        selectionCircle.setFill(Color.RED);

        getChildren().add(selectionCircle);
        getChildren().get(getChildren().size()-1).toBack();
    }

}
