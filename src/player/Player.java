package player;
import enums.Direction;
import main.GameController;

public abstract class Player {
    protected int maxHealthPoints;
    protected int healthPoints;
    private Direction actualDirection;
    private PlayerState actualState;
    private int actionPoints;
    private GameController gameController;

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

    //Collection<Item> getItems()

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
