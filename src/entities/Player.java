package entities;

import items.*;
import entities.behaviours.*;
import game.GameController;
import localization.Language;

import java.util.List;

/**
 * A játékban szereplő különböző emberi karakterek őse.
 * Képes közlekedni a Fieldeken, Itemeket felvenni és használni azokat,
 * illetve különböző speciális képességekkel is rendelkeznek a leszármazott
 * típustól függően.
 */
public abstract class Player extends Entity {

    /**
     * A játékos jelenlegi állapota.
     */
    protected PlayerState currentState = new NormalState(this);
    /**
     * A Player maximális akciópontjainak száma.
     */
    private final int MAX_ACTION_POINTS = 4;
    /**
     * A játékos akciópontjainak a száma, annyi tevékenységet tud végrehajtani, ahány pontja van.
     */
    protected int actionPoints = MAX_ACTION_POINTS;
    /**
     * A játékos táskája, amiben tárgyakat tud tárolni.
     */
    private Inventory inventory = new Inventory(this);
    /**
     * Ennyi életereje lehet. Leszármazott típusonként ez különbözhet.
     */
    protected int maxHealthPoints;
    /**
     * Jelenlegi életerő pontjai.
     */
    protected int healthPoints;

    /**
     * Létrehozza az objektumot.
     */
    public Player() {
        super();
    }

    /**
     * Az argumentumként kapott parancs alapján cselekszik.
     * @param action A játékost különböző cselekvésre késztető adat vektor.
     * @return  Amennyiben maradt még a cselekvése után akciópontja, úgy igaz,
     * máskülönben hamis értékkel tér vissza.
     */
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
                        GameController.OutStream.println("Invalid parameter.");
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
            case "dig":
                this.digByHand();
                break;
            default:
                GameController.OutStream.println("Invalid action");
        }
        return actionPoints > 0;
    }

    /**
     * Kiiratja a GameController OutStreamjére a Player élet és akció pontjainak számát.
     */
    public void ShowStats() {
        GameController.OutStream.println("HP: " + healthPoints);
        GameController.OutStream.println("AP: " + actionPoints);
    }

    /**
     * Kiiratja a GameController OutStreamjére a Player Inventoryjában található tárgyakat.
     */
    public void ShowInventory() {
        inventory.Show();
    }

    /**
     * Visszaállítja a játékos akciópontjainak a számát a maximális értékre.
     */
    public void resetActionPoints(){
        actionPoints = MAX_ACTION_POINTS;
    }

    /**
     * Megnöveli a Player életét.
     */
    private void incrementHP(){
        healthPoints++;
    }

    /**
     * Átöltözeteti a Plyert búvárruhába, amit a currentState
     * módosításával ér.
     */
    public void swapDivingSuit() {
        currentState.swapDivingSuit();
    }

    /**
     *  A Player ebben a metódusban találkozik azon Entityvel
     *  akivel egy Filden tartózkodik. Akivel találkozott,
     *  pedig bemutatkozik, meghívva annak a meetPlayer metódusát.
     * @param otherEntity másik entitás.
     */
    @Override
    public void collideWith(Entity otherEntity) {
        otherEntity.meetPlayer(this);
    }

    /**
     *  Ez a metódus hívódik meg, amikor Player Playerrel találkozik.
     *  Mivel egyelőre nem csinálnak egymással semmit, ezért üres implementációval rendelkezik.
     * @param player Azon Player, aki ezen Player mezójére lépett.
     */
    public void meetPlayer(Entity player){
        // Do nothing.
    }

    /**
     * Ezzel a metódussal lehet átállítani a Player állapotát.
     * @param nextState A Playernek beállítani kívánt állapot.
     */
    public void setState(PlayerState nextState){
        currentState = nextState;
    }

    /**
     * Eszkösz használat az inventoryban elfoglalt index szerint.
     * @param itemIndex A használandó eszköz inventoryban lévő indexe.
     */
    public void useItem(int itemIndex){
        inventory.useItem(itemIndex);
    }

    /**
     * A Player elhagyja a vizet, amit a currentState átállításával ér el.
     */
    @Override
    public void makeWalk(){
        currentState.makeWalk();
    }

    /**
     * A Player fulledó állapotba próbálja hozni. Amennyiben már
     * fulladó állapotban van, úgy megfullasztja, azaz megöli.
     */
    @Override
    public void makeDrown(){
        currentState.makeDrown();
    }

    /**
     * A Playert megöli.
     */
    @Override
    public void die(String deathMsg){
        gameController.gameOver(deathMsg);
    }

    /**
     * Arról a mezőről amelyen a Player áll, megpróbál felvenni egy tárgyat.
     * @return Amennyiben sikerült felvennie egy tárgyat, úgy true,
     * máskülönben false értékkel tér vissza.
     */
    public boolean pickUpItem(){
        boolean accepted = false; //bekerult-e az item az inventoryba
        if(actionPoints != 0 && fieldUnder.getSnowLevel() == 0) {
            Item pickedUpItem = fieldUnder.getItem(); //megprobalja kivenni az itemet a fieldrol
            if (pickedUpItem != null) {
                accepted = inventory.add(pickedUpItem); //megprobalja az itemet betenni az inventoryba
                if (accepted) {
                    fieldUnder.removeItem(); //eltavolitja az itemet a fieldrol
                    actionPoints--;//csokkenti az akciopontot
                }
            }
        }
        return accepted;
    }

    /**
     * A Player alapvető hótakarítási módszere.
     */
    public void digByHand(){
        if(fieldUnder.changeSnowLevel(-1)) {
            GameController.OutStream.println("Successfully digged " + 1 + " layer of snow");
            actionPoints--;
        }
    }

    /**
     * A Player ásóval végez hótakarítást az argumentumként átvett
     * értékkel csökkenti a hószintet azon a mezőn amin áll.
     * @param digValue Annak értéke, hogy mennyivel próbálja meg csökkenteni
     *                 a Player az alatta lévő Field hószintjét.
     */
    public void shovel(int digValue){
        if(fieldUnder.changeSnowLevel(-digValue)) {
            GameController.OutStream.println("Successfully shoveled " + digValue + " layer of snow");
            actionPoints--;
        }
    }

    /**
     * A Player életerő pontjainak számát növeli.
     * @param food Az étel amit megeszik evés közben.
     */
    public void eat(Item food){
        if(healthPoints < maxHealthPoints){
            removeItem(food);
            this.incrementHP();
            GameController.OutStream.println("Successful food use");
        } else {
            GameController.OutStream.println("Failed food use");
        }
    }

    /**
     * A Player Inventoryjából kitörli az argumentumként kapott Itemet.
     * @param item Azon Item amit ki kell törölni a Player inventoryjából.
     */
    public void removeItem(Item item){
        inventory.removeSpecificItem(item);
    }

    /**
     * Csökkenti a Player életét.
     */
    public void decrementHP(){
        healthPoints--;
        if(healthPoints <= 0)
            this.die(Language.Selected().ColdDeathMSG());
    }

    /**
     * A Player Inventoryjában lévő Itemek gyűjteményét adja vissza.
     * @return A Player Inventoryjában lévő Itemek gyűjteményét adja vissza.
     */
    public List<Item> getItems(){
        return inventory.getItems();
    }

    /**
     * A Player akciópontját adja meg
     * @return Player akciópontját
     */
    public int getActionPoints()
    {
        return this.actionPoints;
    }

    /**
     * A Player életerőpontját adja meg
     * @return A Player életerőpontja
     */
    public int getHealthPoints()
    {
        return this.healthPoints;
    }

    /**
     * Visszaadja a jatekos maximalis eleteropontjat
     * @return
     */
    public  int getMaxHealthPoints() {return this.maxHealthPoints;}

    /**
     * Visszaadja a jatekos maximalis akciopontjat
     * @return
     */
    public int getMaxActionPoints() {return this.MAX_ACTION_POINTS;}

    /**
     * Vissza adja hogy melyik írányba néz a játékos
     * @return Az írány
     */
    public int getDirection()
    {
        return actualDirection;
    }

    /**
     * Megpróbál kiementi egy társat arról a mezőről, amelyik irányba néz.
     */
    public void rescueFriend(){
       if(fieldUnder.pullOutPlayerFrom(actualDirection))
            actionPoints--;

    }

    /**
     * Jelzőpiyztoly használata.
     */
    public void useFlareGun(){
        gameController.win(fieldUnder);
    }

    /**
     * Speciális képesség használata.
     */
    public abstract void specialPower();

    /**
     * A talált item egy quest item.
     */
    public void questItemFound() {
        gameController.questItemFound();
    }

    /**
     * Sátrat próbál építeni a Player alatti mezőre.
     * @param tent A játékosnál lévő sátor, amelyet kitöröl
     *             a Player Inventoryjából.
     */
    public void buildTent(Item tent){
        if(fieldUnder.buildTent()){
            inventory.removeSpecificItem(tent);
            actionPoints--;
        }
    }

    /**
     * Amikor elindul a játékos köre, akkor a
     * maximálisan lehetséges akciópontokat állít be neki.
     */
    public void startTurn()
    {
        resetActionPoints();
    }

    /**
     * A játékos körének véget szab, a Player
     * akciópontjainak nullára állításával.
     */
    public void endTurn()
    {
        this.actionPoints = 0;
    }

    /**
     * A Playert mozgásra készteti abban az irányban, amerre aktuálisan néz.
     */
    @Override
    public void move(){
        super.move();
        actionPoints--;
    }
}
