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
    private int actionPoints;
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


    public void swapDivingSuit() {

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

    }

    public void makePlayerDrowning(){

    }

    public void makePlayerWalk(){

    }

    public void drown(){

    }

    public void die(){

    }

    public boolean pickUpItem(){
        Item i = fieldUnderPlayer.getItem();

        boolean accepted = inventory.add(i);

        if(accepted) {
            fieldUnderPlayer.removeItem();
            i.setOwner(this);
        }


        return false;
    }

    public void shovel(int snowLevel){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        fieldUnderPlayer.changeSnowLevel(-1);
    }

    public void eat(Item food){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        if(healthPoints < maxHealthPoints){
            inventory.removeSpecificItem( food );
        }
    }

    public void decrementHP(){

    }

    List<Item> getItems(){
        return null;
    }

    public void rescueFriend(Direction rescueFromDirection){

    }

    public void pulledOut(){

    }

    public void changeActionPointsBy(int difference){

    }

    public void useFlareGun(){

    }

    public abstract void specialPower();

    public void questItemFound() {
        gameController.questItemFound();
    }

}
