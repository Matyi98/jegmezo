package items;

import scene.writer.SceneWriter;

//Lapátot reprezentáló osztály.
public class Shovel extends Item {
    //Ennyi hóréteget takarít el a lapát.
    private int shovelSpeedIncrease = 2;

    @Override
    protected void showPickup() {
        SceneWriter.OutStream.println("Shovel picked up");
    }

    //Lapát használata.
    public void use(){
        owner.shovel(shovelSpeedIncrease);
    }

    public void Show() {
        SceneWriter.OutStream.print("Shovel");
    }
    public void ShowShort() { SceneWriter.OutStream.print("s"); }
}
