package views;

import entities.Entity;

public class EntityView extends ViewBase {
    private Entity data;
    public EntityView(Entity e) {
        super(e.GetTexturePath());
        this.data = e;
    }

    @Override
    public void Update() {
        //TODO: Implement this.
    }
}
