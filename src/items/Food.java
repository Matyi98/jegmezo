package items;

import scene.writer.SceneWriter;

public class Food extends Item {
    //étel kalória szintje, ennyi testhőpontot gyógyít a játékoson
    int calorieLevel = 1;

    //Étel használata, növeli a játékos testhőpontját a kalória szintnek megfelelően.
    public void use(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Étel elfogyasztása.
        owner.eat(this);
        System.out.println("Sikeres eves");
    }

    public void Show() {
        SceneWriter.OutStream.print("Food");
    }
    public void ShowShort() { SceneWriter.OutStream.print("f"); }
}
