package entities;

import fields.Field;
import items.*;
import entities.behaviours.*;
import scene.GameController;
import scene.writer.SceneWriter;

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
                GameController.OutStream.println("Skip");
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
        SceneWriter.OutStream.println("HP: " + String.valueOf(healthPoints));
        SceneWriter.OutStream.println("AP: " + String.valueOf(actionPoints));
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
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    //Átöltözés búvárruhba.
    public void swapDivingSuit() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        currentState.swapDivingSuit();
    }

    public void setState(PlayerState nextState){
        currentState = nextState;
    }

    //Eszkösz használat az inventoryban elfoglalt index szerint.
    public void useItem(int itemIndex){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //inventoryn kesresztül item használata.
        inventory.useItem(itemIndex);
    }

    //Játékos elhagyja a vizet.
    @Override
    public void walk(){
        currentState.walk();
    }

    //Játékos megfullad.
    @Override
    public void drown(){
        currentState.drown();
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
        fieldUnder.pullOutPlayerFrom(actualDirection);
            actionPoints--;

    }

    //Játékost kimentették a lyukból.
    public void pulledOut(){

    }

    //Jelzőpiyztoly használata.
    public void useFlareGun(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Megszámolja hány játékos áll a mezőn.
        int count = fieldUnder.getEntityCount();
        /*
            Átadja a gc-nek, hogy hányan vannak.
            Arról, hogy valóban nyertek-e, a gc dönt.
        * */
        gameController.win(count);
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
            GameController.OutStream.println("Successful tent use.");
        }
    }

    @Override
    public void move(){
        super.move();
        actionPoints--;
    }

}
