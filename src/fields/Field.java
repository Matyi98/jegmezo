package fields;

import entities.Entity;

import fields.behaviours.FieldBehaviour;
import fields.behaviours.StandardFieldBehaviour;
import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Field {
    protected int snowLevel;
    private static int MAX_SNOWLEVEL = 9;
    protected ArrayList<Field> neighbors = new ArrayList<>();
    protected List<Entity> entities = new ArrayList<>();

    private static int staticIndex = 0;
    private int fieldIndex;
    protected FieldBehaviour behaviour;

    public Field() {
        this.behaviour = new StandardFieldBehaviour();
        this.fieldIndex = staticIndex++;
    }

    /**
     * Megjeleníti a Fieldet a SceneWriterben meghatározott folyamon.
     */
    public abstract void Show();

    public void ShowState() {
        behaviour.ShowShort();
    }

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
    public abstract void Setup(int w, int s, Optional<Item> i, Optional<Entity> e);

    /**
     * Beregisztrál egy szomszédságot.
     * @param neighbour A mező új szomszédja.
     */
    public void ConnectTo(Field neighbour) {
        this.neighbors.add(neighbour);
    }

    public boolean placeEntityToNextField(int direction, Entity entity){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return neighbors.get(direction).acceptEntity(entity);
    }

    public boolean placeEntityToNextField(int direction){
        boolean success = neighbors.get(direction).acceptEntity(entities.get(0));
        return success;
    }

    public boolean pullOutPlayerFrom(int direction){
        boolean success = neighbors.get(direction).placeEntityToNextField(fieldIndex);
        entities.get(1).walk();
        return success;
    }

    public void removeItem() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }


    public final boolean changeSnowLevel(int delta){
        if (snowLevel <= 0 && delta < 0)
            return false;
        snowLevel = snowLevel + delta;
        return true;
    }

    public void snow(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        this.changeSnowLevel(3);
        for(Entity e: entities)
        {
            e.decrementHP();
        }
    }

    public int getEntityCount(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return entities.size();
    }

    public Entity selectEntity() {
        return null;
    }

    public abstract boolean acceptEntity(Entity entity);

    public abstract boolean buildIgloo();

    public abstract boolean buildTent();

    public void destroyTent() { }

    //Megnézi a mező stabilitását
    public abstract String checkStability();

    //Megnézi szomszédos mező stabilitását.
    public final String checkStability(int direction) {
        Field neighbour = neighbors.get(direction);
        return neighbour.checkStability();
    }

    public void step(){

    }

    public int getNeighbourCount() {
        return neighbors.size();
    }

    public Item getItem(){ return null;}
}
