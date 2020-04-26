package entities;

import items.*;
import entities.behaviours.*;
import scene.GameController;

import java.util.List;

public abstract class Player extends Entity {
    private PlayerState currentState = new NormalState(this);
    private final int MAX_ACTION_POINTS = 4;
    protected int actionPoints = MAX_ACTION_POINTS;
    private Inventory inventory = new Inventory(this);
    protected int maxHealthPoints;
    protected int healthPoints;

    /**
     * Létrehozza az objektumot.
     */
    public Player() {
    }

    public boolean Action(String action) {
        switch (action.split(" ")[1]) {
            case "turn":
                String parameter = action.split(" ")[2].toLowerCase();
                switch (parameter) {
                    case "a":
                        this.turn(-1);
                        break;
                    case "d":
                        this.turn(1);
                        break;
                    default:
                        GameController.OutStream.println("bad parameter.");
                }
                break;
            case "move":
                this.move();
                break;
            case "use":
                int itemIndex = Integer.parseInt(action.split(" ")[2]);
                this.useItem(itemIndex);
                break;
            case "special":
                this.specialPower();
                break;
            case "skip":
                GameController.OutStream.println(getName() + " skip");
                return false;
            case "shovel":
                this.shovel(1);
                break;
            case "pickup":
                this.pickUpItem();
                break;
            default:
                GameController.OutStream.println("bad action");
        }
        return actionPoints > 0;
    }
    
    
    public void ShowStats() {
        GameController.OutStream.println("HP: " + String.valueOf(healthPoints));
        GameController.OutStream.println("AP: " + String.valueOf(actionPoints));
    }

    public void ShowInventory() {
        inventory.Show();
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void resetActionPoints(){
        actionPoints = MAX_ACTION_POINTS;
    }

    //Megnöveli a játékos életét.
    private void incrementHP(){
        healthPoints++;
    }

    //Átöltözés búvárruhba.
    public void swapDivingSuit() {
        currentState.swapDivingSuit();
    }

    public void setState(PlayerState nextState){
        currentState = nextState;
    }

    //Eszkösz használat az inventoryban elfoglalt index szerint.
    public void useItem(int itemIndex){
        inventory.useItem(itemIndex);
    }

    //Játékos elhagyja a vizet.
    @Override
    public void makeWalk(){
        currentState.makeWalk();
    }

    //Játékos megfullad.
    @Override
    public void makeDrown(){
        currentState.makeDrown();
    }

    //Játékos meghal.
    @Override
    public void die(){
        gameController.gameOver();
    }

    /**
     *
     * @return a targyfelvetel sikeressege
     */
    public boolean pickUpItem(){
        boolean accepted = false; //bekerult-e az item az inventoryba
        if(actionPoints != 0 && fieldUnder.getSnowLevel() == 0) {
            Item i = fieldUnder.getItem(); //megprobalja kivenni az itemet a fieldrol
            if (i != null) {
                accepted = inventory.add(i); //megprobalja az itemet betenni az inventoryba
                if (accepted) {
                    fieldUnder.removeItem(); //eltavolitja az itemet a fieldrol
                    actionPoints--;//csokkenti az akciopontot
                }
            }
        }
        return accepted;
    }

    public void digByHand(){
        if(fieldUnder.changeSnowLevel(-1)) {
            actionPoints--;
        }
    }

    public void shovel(int digValue){
        if(fieldUnder.changeSnowLevel(-digValue)) {
            actionPoints--;
        }
    }

    //Evés.
    public void eat(Item food){
        if(healthPoints < maxHealthPoints){
            removeItem(food);
            this.incrementHP();
        }
    }

    public void removeItem(Item item){
        inventory.removeSpecificItem(item);
    }

    //Játékos életének csökkentése.
    public void decrementHP(){
        healthPoints--;
        if(healthPoints <= 0)
            this.die();
    }

    List<Item> getItems(){
        return null;
    }

    public void rescueFriend(){
       if(fieldUnder.pullOutPlayerFrom(actualDirection));
            actionPoints--;

    }

    //Játékost kimentették a lyukból.
    public void pulledOut(){

    }

    //Jelzőpiyztoly használata.
    public void useFlareGun(){
        int numOfPlayersOnField = fieldUnder.getEntityCount();
        gameController.win(numOfPlayersOnField);
    }

    //Speciális képesség használata.
    public abstract void specialPower();

    //A talált item egy quest item.
    public void questItemFound() {
        //Jelez a gc-nek, hogy quest itemet találtak.
        gameController.questItemFound();
    }

    public void buildTent(Item tent){
        if(fieldUnder.buildTent()){
            inventory.removeSpecificItem(tent);
            actionPoints--;
        }
    }

    @Override
    public void move(){
        super.move();
        actionPoints--;
    }

}
