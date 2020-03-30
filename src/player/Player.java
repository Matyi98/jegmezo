package player;
import enums.Direction;
import fields.Field;
import items.Item;
import main.GameController;
import items.Inventory;
import player.behaviours.CanSwimState;
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

    //Megnöveli a játékos életét.
    private void incrementHP(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    //Átöltözés búvárruhba.
    public void swapDivingSuit() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        actualState = new CanSwimState();
    }

    public void setState(PlayerState nextState){

    }

    public void turn(Direction newDirection){

    }

    //Játékos mozgása.
    public void move(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        fieldUnderPlayer.placePlayerToNextField(Direction.UP, this);
    }

    //Eszkösz használat az inventoryban elfoglalt index szerint.
    public void useItem(int itemIndex){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //inventoryn kesresztül item használata.
        inventory.useItem(itemIndex);
    }

    //Játékos elhagyja a vizet.
    public void makePlayerWalk(){
        //A játékos state változását valósítja meg
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    //Játékos megfullad.
    public void drown(){

    }

    //Játékos meghal.
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

    //Játékos életének csökkentése.
    public void decrementHP(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

    }

    /*
    Visszaadja a játékos itemeit.
     */
    List<Item> getItems(){
        return null;
    }

    public void rescueFriend(Direction rescueFromDirection){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Szól a mezőjének, hogy a kijelölt irányban akar kihúzni valakit
        fieldUnderPlayer.pullOutPlayerFrom(rescueFromDirection);
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
        int count = fieldUnderPlayer.getPlayerCount();
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

}
