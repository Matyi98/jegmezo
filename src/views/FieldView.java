package views;

import entities.Entity;
import fields.Field;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class FieldView extends ViewBase {
    private Field data;
    private final int radius;

    private Circle selectionCircle;
    private ItemView itemView = null;
    private ArrayList<EntityView> entityViews = new ArrayList<>();

    private VBox entityLayoutContainer = new VBox(2);
    private HBox firstRow = new HBox(2);
    private HBox secondRow = new HBox(2);


    public FieldView(Field f, int radius) {
        super(f.GetTexturePath());
        this.radius = radius;
        this.data = f;
        initialise();
    }

    private void initialise(){
        selectionCircle = new Circle(0, 0, radius + 5);
        selectionCircle.setFill(Color.RED);

        Circle cMain = new Circle(0, 0, radius);
        cMain.setFill(new ImagePattern(image));
        getChildren().add(cMain);

        //jobb felső kör iglunak és sátornak
        Circle cState = new Circle(0, 0, radius*0.30);
        cState.setFill(Color.BLACK);
        StackPane.setAlignment(cState, Pos.BOTTOM_LEFT);
        getChildren().add(cState);
        //jobb felső kör iglunak és sátornak

        refreshItem();
        refreshEntities();

        entityLayoutContainer.getChildren().addAll(firstRow, secondRow);
        entityLayoutContainer.setTranslateY(-20);
        getChildren().addAll(entityLayoutContainer);
    }

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

    private void setItemViewOpacity(){
        double intensity = 6;
        itemView.setOpacity(Math.pow(
                ((double)(Field.getMaxSnowLevel()-data.getSnowLevel())
                        /(double)Field.getMaxSnowLevel())
                , intensity));
    }

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

    public void showSelect(){
        getChildren().add(selectionCircle);
        getChildren().get(getChildren().size()-1).toBack();
    }

    public void hideSelect(){
        getChildren().remove(selectionCircle);
    }

    //Kiderült hogy nem is kell használni?
    @Override
    public void Update() {
        //hideSelect();
        //refreshItem();
        //refreshEntities();
    }
}
