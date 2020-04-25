package entities;

import items.*;
import entities.behaviours.*;
import scene.writer.SceneWriter;

import java.util.List;

public abstract class Player extends Entity {
    private PlayerState actualState;
    private final int MAX_ACTION_POINTS = 4;
    protected int actionPoints = MAX_ACTION_POINTS;
    private Inventory inventory;
    protected int maxHealthPoints;
    protected int healthPoints;

    /**
     * Létrehozza az objektumot.
     */
    public Player() {
    }

    public void ShowStats() {
        SceneWriter.OutStream.println("HP: " + String.valueOf(healthPoints));
        SceneWriter.OutStream.println("AP: " + String.valueOf(actionPoints));
    }


    //Megnöveli a játékos életét.
    private void incrementHP(){
        healthPoints++;
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    //Átöltözés búvárruhba.
    public void swapDivingSuit() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        actualState.swapDivingSuit();
    }

    private void setState(PlayerState nextState){

    }

    //Játékos mozgása.
    public void move(){
//        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
//        fieldUnder.placePlayerToNextField(Direction.UP, this);
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
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        actualState.walk();
    }

    //Játékos megfullad.
    @Override
    public void drown(){
        actualState.drown();
    }

    //Játékos meghal.
    @Override
    public void die(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        gameController.gameOver();

    }

    /**
     *
     * @return a targyfelvetel sikeressege
     */
    public boolean pickUpItem(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        boolean accepted = false; //bekerult-e az item az inventoryba
        if(actionPoints != 0) {
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

    //Ennyi hószintet takarít el a mezőről.
    public void shovel(int snowLevel){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Ha sikeres volt, akkor csökkenti az akciópontot.
        if(fieldUnder.changeSnowLevel(-snowLevel)) {
            System.out.println("Sikeres hotakaritas");
            actionPoints--;
        }
    }

    //Evés.
    public void eat(Item food){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        if(healthPoints < maxHealthPoints){
            inventory.removeSpecificItem( food );
            this.incrementHP();
        }
    }

    //Játékos életének csökkentése.
    public void decrementHP(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("healthPoints: "+ healthPoints);
        healthPoints--;
        if(healthPoints == 0)
            this.die();

    }

    /*
    Visszaadja a játékos itemeit.
     */
    List<Item> getItems(){
        return null;
    }

    public void rescueFriend(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Szól a mezőjének, hogy a kijelölt irányban akar kihúzni valakit
        fieldUnder.pullOutPlayerFrom(actualDirection);
    }

    //Játékost kimentették a lyukból.
    public void pulledOut(){

    }

    //Akciópontok állítása, adott értékkel.
    public void changeActionPointsBy(int difference){

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
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Jelez a gc-nek, hogy quest itemet találtak.
        gameController.questItemFound();
    }

    public void builtTent(){

    }

}
