package fields;

import entities.Entity;

import fields.behaviours.FieldBehaviour;
import items.Item;
import entities.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Field {
    protected int snowLevel;
    private static int MAX_SNOWLEVEL = 9;
    protected ArrayList<Field> neighbors;
    protected List<Entity> entities = new ArrayList<>();
    protected Item item;

    private static int staticIndex = 0;
    private int fieldIndex;
    protected FieldBehaviour behaviour;

    public Field(){
        fieldIndex = staticIndex++;
    }

    /**
     * Megjeleníti a Fieldet a SceneWirterben meghatározott folyamon.
     */
    public abstract void Show();

    /**
     * Visszaadja a mező sorszámát. Ez a kirajzoláshoz fontos.
     * @return A mező indexe-
     */
    public int GetIndex() {
        return fieldIndex;
    }

    /**
     * Lekérdezi a mező szomszédjait.
     * @return A mező összes szomszédja.
     */
    public ArrayList<Field> GetNeighbours() {
        return neighbors;
    }

    /**
     *
     * @param w A mező által elbírt entitások száma.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.
     */
    public abstract void Setup(int w, int s, Item i, Entity e);

    /**
     * Beregisztrál egy szomszédságot.
     * @param neighbour A mező új szomszédja.
     */
    public void ConnectTo(Field neighbour) {
        //TODO: implement connections
    }

    //Ezen fielden lévő player átmozgatása egy szomszédos fieldre
    public boolean placeEntityToNextField(int direction, Entity entity){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return neighbors.get(direction).acceptEntity(entity);
    }

    //Ezen fielden lévő player átmozgatása egy szomszédos fieldre user által kiválasztott alapon
    public boolean placeEntityToNextField(int direction){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Áthelyezi a játékost az adott irányban lévő mezőre
        boolean success = neighbors.get(direction).acceptEntity(entities.get(0));
        return success;
    }

    //Áthúz egy playert egy szomszédos mezőről saját magához
    public boolean pullOutPlayerFrom(int direction){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //A kijelölt szomszédban lévő mezőt felszólítja, hogy adja át valamelyik játékosát
        boolean success = neighbors.get(direction).placeEntityToNextField(fieldIndex);
        //A játékos állapotváltozását idézi elő
        entities.get(1).walk();
        return success;
    }

    //Visszaadja a fielden lévő itemet
    public Item getItem(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return item;
    }

    //Item eltávolítása a fieldről
    public void removeItem() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }


    //Hószint megváltoztatása.
    public final boolean changeSnowLevel(int delta){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Ha ásni próbálnak, de már nincs több hó, akkor hamissal visszatér.
        if (snowLevel <= 0 && delta < 0)
            return false;

        //Változtatja a hószintet.
        snowLevel = snowLevel + delta;
        return true;
    }

    //Havazik az adott mezőn
    public void snow(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Hotakaro ratevese a fieldre
        this.changeSnowLevel(3);
        //A fielden lévő játékosok életének csökkentése
        for(Entity e: entities)
        {
            e.decrementHP();
        }


    }

    //Megmondja, hogy hány játékos áll a mezőn.
    public int getEntityCount(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return entities.size();
    }

    //Egy játékos kiválasztása a fielden
    public Player selectEntity() {
        return null;
    }

    //Adott playert helyez a mezőre
    public abstract boolean acceptEntity(Entity entity);

    //Iglut épít a mezőre
    public abstract boolean buildIgloo();

    public abstract boolean buildTent();

    public void destroyTent() { }

    //Megnézi a mező stabilitását
    public abstract String checkStability();

    //Megnézi szomszédos mező stabilitását.
    public final String checkStability(int direction) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        Field neighbour = neighbors.get(direction);
        return neighbour.checkStability();
    }

    public void step(){

    }

}
