package views;

import entities.Entity;
import fields.Field;
import items.Item;
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
            getChildren().add(itemView);
        }

        for(Entity entity : data.getEntities()){

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
    }
}
