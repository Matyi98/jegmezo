package items;

import scene.GameController;

public class Food extends Item {
    //étel kalória szintje, ennyi testhőpontot gyógyít a játékoson
    int calorieLevel = 1;

    @Override
    protected void showPickup() {
        GameController.OutStream.println("Food picked up");
    }

    //Étel használata, növeli a játékos testhőpontját a kalória szintnek megfelelően.
    public void use(){
        owner.eat(this);
    }

    public void Show() {
        GameController.OutStream.print("Food");
    }
    public void ShowShort() { GameController.OutStream.print("f"); }
}
