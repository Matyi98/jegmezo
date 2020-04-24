package items;

import scene.writer.SceneWriter;

//Lapátot reprezentáló osztály.
public class Shovel extends Item {
    //Ennyi hóréteget takarít el a lapát.
    private int shovelSpeedIncrease = 2;

    //Lapát használata.
    public void use(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        owner.shovel(shovelSpeedIncrease);
        System.out.println("Sikeres aso hasznalat");
    }


    public void Show() {
        SceneWriter.OutStream.print("Shovel");
    }
    public void ShowShort() { SceneWriter.OutStream.print("s"); }
}
