package items;

public class Food extends Item {
    int calorieLevel = 1;

    public void use(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        owner.eat(this);
    }
}
