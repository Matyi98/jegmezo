package fields;

import entities.Entity;
import fields.behaviours.FieldBehaviour;
import fields.behaviours.StandardFieldBehaviour;
import items.Item;
import scene.Board;
import scene.Dialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class Field {
    protected int snowLevel;
    private static int MAX_SNOWLEVEL = 9;
    protected ArrayList<Field> neighbors = new ArrayList<>();
    protected ArrayList<Entity> entities = new ArrayList<>();
    protected Board board;

    protected static int autoIncrementID = 1;
    protected int UID;
    protected FieldBehaviour behaviour;

    public Field() {
        this.behaviour = new StandardFieldBehaviour();
        this.UID = autoIncrementID++;
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
    public int GetUID() {
        return UID;
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
     * @param b A pálya.
     * @param w A mező által elbírt entitások száma.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitások.
     */
    public abstract void Setup(Board b, int w, int s, Optional<Item> i, ArrayList<Entity> e);

    /**
     * Beregisztrál egy szomszédságot.
     * @param neighbour A mező új szomszédja.
     */
    public void ConnectTo(Field neighbour) {
        this.neighbors.add(neighbour);
    }
    
    public void changeNeighbor(Field newNeighbor, Field oldNeighbor)
    {
        this.neighbors.remove(oldNeighbor);
        this.neighbors.add(newNeighbor);
    }

    public void setBehaviour(FieldBehaviour fb){
        behaviour = fb;
    }

    //Ezen fielden lévő player átmozgatása egy szomszédos fieldre
    public void placeEntityToNextField(int direction, Entity entity){
         this.entities.remove(entity);
         neighbors.get(direction).acceptEntity(entity);
    }

    public void placeEntityToNextField(int direction){
        neighbors.get(direction).acceptEntity(entities.get(0));
    }

    public void pullOutPlayerFrom(int direction){
        neighbors.get(direction).placeEntityToNextField(UID);
        entities.get(1).walk();
    }

    public void removeItem() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    public final boolean changeSnowLevel(int delta){
        if(snowLevel <= 0 && delta < 0){
            return false;
        }

        int sum = snowLevel + delta;
        if(sum < 0){
            snowLevel = 0;
        }
        else if (sum > MAX_SNOWLEVEL){
            snowLevel = MAX_SNOWLEVEL;
        }
        else{
            snowLevel = sum;
        }

        return true;
    }

    public void snow(){
        behaviour.performSnow(entities);
    }

    public int getEntityCount(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return entities.size();
    }

    public Entity selectEntity() {
        ArrayList<String> names = new ArrayList<>();
        for(Entity e : entities){
            names.add(e.getName());
        }

        Dialog popup = new Dialog("Who will you rescue?", names);
        int choice = popup.ShowDialog();

        return entities.get(choice);
    }

    public int getSnowLevel(){
        return snowLevel;
    }

    public abstract void acceptEntity(Entity entity);

    public abstract boolean buildIgloo();

    public abstract boolean buildTent();

    public abstract void destroyTent();

    public abstract void performSnow();

    public abstract void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities);

    //Megnézi a mező stabilitását
    public abstract String checkStability();

    //Megnézi szomszédos mező stabilitását.
    public final String checkStability(int direction) {
        Field neighbour = neighbors.get(direction);
        return neighbour.checkStability();
    }

    public void step(){
        for(Entity e: entities)
            e.step();
    }

    public int getNeighbourCount() {
        return neighbors.size();
    }

    public Item getItem(){ return null;}
}
