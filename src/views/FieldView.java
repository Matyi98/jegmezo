package views;

import entities.Entity;
import fields.Field;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class FieldView extends ViewBase {
    private Field data;
    private final int radius;
    ItemView itemView = null;
    ArrayList<EntityView> entityViews = new ArrayList<>();

    HBox rows = new HBox(2);

    public FieldView(Field f, int radius) {
        super(f.GetTexturePath());

        this.radius = radius;
        this.data = f;

        initialise();
    }

    public void initialise(){
        Circle circle = new Circle(0, 0, radius);
        circle.setFill(new ImagePattern(image));
        getChildren().add(circle);

        refreshEntities();

        getChildren().add(rows);
    }

    public void refreshItem(){
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

    public void refreshEntities() {
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

    @Override
    public void Update() {
        refreshItem();
        refreshEntities();
    }
}
