package items;



public class DivingSuit extends Item {
    public void use() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        this.owner.swapDivingSuit();
    }
}
