package views;

import entities.Entity;
import fields.Field;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class FieldView extends ViewBase {
    private Field data;
    private final int radius;

    public FieldView(Field f, int radius) {
        super(f.GetTexturePath());

        this.radius = radius;
        this.data = f;

        initialise();
    }

    public void initialise(){
        Circle circle = new Circle(0, 0, radius);
        circle.setFill(new ImagePattern(image));

        ItemView itemView = null;
        if(data.getItem() != null)
             itemView = new ItemView(data.getItem());

        for(Entity entity : data.getEntities()){

        }

        getChildren().add(circle);
        if(itemView != null)
            getChildren().add(itemView);
    }

    @Override
    public void Update() {
        //TODO: Implement this.
    }
}
