package views;

import entities.Entity;
import fields.Field;
import items.Item;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class FieldView extends ViewBase {
    private Field data;
    private final int radius;
    ItemView itemView = null;

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

        if(data.getItem() != null){
            itemView = new ItemView(data.getItem());
            setItemViewOpacity();
            itemView.setAlignment(Pos.BOTTOM_CENTER);
            getChildren().add(itemView);
        }

        HBox rows = new HBox(2);
        getChildren().add(rows);

        for(Entity entity : data.getEntities()){
            EntityView entityView = new EntityView(entity);
            rows.getChildren().add(entityView);
        }

    }

    private void setItemViewOpacity(){
        double intensity = 6;
        itemView.setOpacity(Math.pow(
                ((double)(Field.getMaxSnowLevel()-data.getSnowLevel())
                        /(double)Field.getMaxSnowLevel())
                , intensity));
    }

    @Override
    public void Update() {
        setItemViewOpacity();

        data.getEntities().forEach(e -> Update());
    }
}
