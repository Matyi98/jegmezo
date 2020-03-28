package player;
import enums.Direction;
import items.Item;
import main.GameController;
import items.Inventory;
import player.behaviours.PlayerState;

import java.util.List;

public abstract class Player {
    protected int maxHealthPoints;
    protected int healthPoints;
    private Direction actualDirection;
    private PlayerState actualState;
    private int actionPoints;
    private GameController gameController;
    private Inventory inventory;

    public Player(int maxHealthPoints){

    }

    public void swapDivingSuit() {

    }

    public void setState(PlayerState nextState){

    }

    public void turn(Direction newDirection){

    }

    public void move(){

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
        return false;
    }

    public void shovel(int snowLevel){

    }

    public void eat(int foodCalorie){

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

}
