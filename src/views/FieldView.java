package views;

import entities.Entity;
import fields.Field;
import game.GameController;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class FieldView extends ViewBase {
    private Field data;
    private final int radius;

    private Circle selectionCircle;
    private ItemView itemView = null;
    private ArrayList<EntityView> entityViews = new ArrayList<>();

    private HBox rows = new HBox(2);

    public FieldView(Field f, int radius) {
        super(f.GetTexturePath());
        this.radius = radius;
        this.data = f;
        initialise();
    }

    private void initialise(){
        selectionCircle = new Circle(0, 0, radius + 5);

        Circle circle = new Circle(0, 0, radius);
        circle.setFill(new ImagePattern(image));
        getChildren().add(circle);

        refreshItem();
        refreshEntities();

        getChildren().add(rows);
    }

    private void refreshItem(){
        getChildren().remove(itemView);

        if(data.getItem() != null){
            itemView = new ItemView(data.getItem());
            setItemViewOpacity();
            itemView.setAlignment(Pos.BOTTOM_CENTER);
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
            rows.getChildren().remove(view);
        }

        entityViews.clear();

        for (Entity entity : data.getEntities()) {
            EntityView entityView = new EntityView(entity);
            entityViews.add(entityView);
            rows.getChildren().add(entityView);

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
