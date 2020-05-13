package views;

import fields.Field;

public class FieldView extends ViewBase {
    private Field data;
    public FieldView(Field f) {
        super(f.GetTexturePath());
        this.data = f;
    }

    @Override
    public void Update() {
        //TODO: Implement this.
    }
}
