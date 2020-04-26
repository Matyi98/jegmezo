package items;

import scene.writer.SceneWriter;

public class Food extends Item {
    //étel kalória szintje, ennyi testhőpontot gyógyít a játékoson
    int calorieLevel = 1;

    @Override
    protected void showPickup() {
        SceneWriter.OutStream.print("Food picked up");
    }

    //Étel használata, növeli a játékos testhőpontját a kalória szintnek megfelelően.
    public void use(){
        owner.eat(this);
    }

    public void Show() {
        SceneWriter.OutStream.print("Food");
    }
    public void ShowShort() { SceneWriter.OutStream.print("f"); }
}
