package items;
import enums.Direction;

//Kötelet reprezentáló osztály.
public class Rope extends Item {

    //Kötél használata.
        public void use() {
            System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
            //A játékos kimentés függvényének hívása
            owner.rescueFriend(Direction.LEFT);
            System.out.println("Sikeres kotel hasznalat");

        }
}
