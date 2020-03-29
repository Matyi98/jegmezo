package player;
import enums.Direction;
import fields.Field;
import items.Item;
import main.GameController;
import items.Inventory;
import player.behaviours.PlayerState;

import javax.crypto.spec.IvParameterSpec;
import java.util.List;

public abstract class Player {
    protected int maxHealthPoints;
    protected int healthPoints;
    private Direction actualDirection;
    private PlayerState actualState;
    private int actionPoints = 4;
    private GameController gameController;
    private Inventory inventory;
    protected Field fieldUnderPlayer;

    public Player(){
        this.actualDirection = Direction.UP;
    }

    public Player(Field fieldUnderPlayer, int maxHealthPoints){
        this.actualDirection = Direction.UP;
        this.fieldUnderPlayer = fieldUnderPlayer;
    }

    public Player(int maxHealthPoints){

    }

    public Player(GameController gc, Field f) {
        gameController = gc;
        fieldUnderPlayer = f;
        inventory = new Inventory(this);
    }


    private void incrementHP(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    public void swapDivingSuit() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    public void setState(PlayerState nextState){

    }

    public void turn(Direction newDirection){

    }

    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        fieldUnderPlayer.placePlayerToNextField(Direction.UP, this);
    }

    public void useItem(int itemIndex){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        inventory.useItem(itemIndex);
    }

    public void makePlayerWalk(){
        //A játékos state változását valósítja meg
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    public void drown(){

    }

    public void die(){

    }

    //Eszköz felvétele.
    public boolean pickUpItem(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Kiveszi az itemet a mezőből.
        Item i = fieldUnderPlayer.getItem();
        //Beleteszi az Inventoryba.
        boolean accepted = inventory.add(i);

        //Ha az Inventory befogadta, akkor törli a mezőről.
        if(accepted)
            fieldUnderPlayer.removeItem();

        return false;
    }

    //Ennyi hószintet takarít el a mezőről.
    public void shovel(int snowLevel){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Ha sikeres volt, akkor csökkenti az akciópontot.
        if(fieldUnderPlayer.changeSnowLevel(-snowLevel))
            actionPoints--;
    }

    //Evés.
    public void eat(Item food){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        if(healthPoints < maxHealthPoints){
            inventory.removeSpecificItem( food );
            this.incrementHP();
        }
    }

    public void decrementHP(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

    }

    List<Item> getItems(){
        return null;
    }

    public void rescueFriend(Direction rescueFromDirection){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Szól a mezőjének, hogy a kijelölt irányban akar kihúzni valakit
        fieldUnderPlayer.pullOutPlayerFrom(rescueFromDirection);
    }

    public void pulledOut(){

    }

    public void changeActionPointsBy(int difference){

    }

    public void useFlareGun(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        int count = fieldUnderPlayer.getPlayerCount();
        gameController.win(count);
    }

    public abstract void specialPower();

    public void questItemFound() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        gameController.questItemFound();
    }

}
