package items;

//Lapátot reprezentáló osztály.
public class Shovel extends Item {
    //Ennyi hóréteget takarít el a lapát.
    private int shovelSpeedIncrease = 2;

    //Lapát használata.
    public void use(){
        owner.shovel(shovelSpeedIncrease);
    }

}
