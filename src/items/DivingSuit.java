package items;

//Búvárruhát reprezentáló osztály.
public class DivingSuit extends Item {
    public void use() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Búvárruha átöltözés.
        this.owner.swapDivingSuit();
        System.out.println("Sikeres DivingSuit hasznalat");
    }
}
