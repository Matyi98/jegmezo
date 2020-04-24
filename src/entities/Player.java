package entities;

import items.*;
import entities.behaviours.*;

import java.util.List;

public abstract class Player extends Entity {
    private PlayerState actualState;
    private final int MAX_ACTION_POINTS = 4;
    private int actionPoints = MAX_ACTION_POINTS;
    private Inventory inventory;


    /**
     * Létrehozza az objektumot.
     */
    public Player() {
    }

    //Megnöveli a játékos életét.
    private void incrementHP(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    //Átöltözés búvárruhba.
    public void swapDivingSuit() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        actualState.swapDivingSuit();
    }

    private void setState(PlayerState nextState){

    }

    public void turn(int newDirection){

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

    //Eszköz felvétele.
    public boolean pickUpItem(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Kiveszi az itemet a mezőből.
        Item i = fieldUnder.getItem();
        //Beleteszi az Inventoryba.
        boolean accepted = inventory.add(i);

        //Ha az Inventory befogadta, akkor törli a mezőről.
        if(accepted)
            fieldUnder.removeItem();
        return false;
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
