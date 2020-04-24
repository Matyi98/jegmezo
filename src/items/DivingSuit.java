package items;

import scene.writer.SceneWriter;

//Búvárruhát reprezentáló osztály.
public class DivingSuit extends Item {
    public void use() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Búvárruha átöltözés.
        this.owner.swapDivingSuit();
        System.out.println("Sikeres DivingSuit hasznalat");
    }

    public void Show() {
        SceneWriter.OutStream.print("DivingSuit");
    }
    public void ShowShort() { SceneWriter.OutStream.print("d"); }
}
