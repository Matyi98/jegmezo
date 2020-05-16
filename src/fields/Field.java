package fields;

import entities.Entity;
import fields.behaviours.FieldBehaviour;
import fields.behaviours.StandardFieldBehaviour;
import items.Item;
import game.Board;
import utility.ITextured;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Field, amelyen az Entity-k lépkednek és magát az egész Board-ot képezik.
 */
public abstract class Field implements ITextured {
    /**
     * Field-en lévő hómennyiség.
     */
    protected int snowLevel;

    /**
     * Maximum hómennyiség, amely egy Field-en lehet.
     */
    private static int MAX_SNOWLEVEL = 9;

    /**
     * Szomszédos Field-ek.
     */
    protected ArrayList<Field> neighbors = new ArrayList<>();

    /**
     * Field-en álló Entity-k.
     */
    protected ArrayList<Entity> entities = new ArrayList<>();

    /**
     * Referencia a Board-ra, amely ezt a Field-et tartalmazza.
     */
    protected Board board;

    /**
     * Field UID generálásához szükséges.
     */
    protected static int autoIncrementID = 0;

    /**
     * Egyedi azonosító.
     */
    protected int UID;

    /**
     * Field viselkedése.
     */
    protected FieldBehaviour behaviour;

    /**
     * Default konstruktor.
     */
    public Field() {
        this.behaviour = new StandardFieldBehaviour(this);
        this.UID = autoIncrementID++;
    }

    /**
     * Reseteli a kezdő egyedi azonosítót.
     */
    public static void resetAutoIncrement(){
        autoIncrementID = 0;
    }

    /**
     * Megjeleníti a Fieldet a SceneWriterben meghatározott folyamon.
     */
    public abstract void Show();

    /**
     * Behaviour megjelenítése
     */
    public void ShowState() {
        behaviour.ShowShort();
    }

    /**
     * Visszaadja a mező sorszámát. Ez a kirajzoláshoz fontos.
     * @return A mező indexe.
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

    public Field getNeighbourByDirection(int direction){
        return neighbors.get(direction);
    }

    public ArrayList<Integer> GetNeighboursUIDs(){
        ArrayList<Integer> UIDs = new ArrayList<>();
        for(Field neighbor: neighbors){
            UIDs.add(neighbor.GetUID());
        }

        return UIDs;
    }

    /**
     * A pálya fájlból való inicializálása közben a már példányosodott Field objektumok
     * paraméterek alapján megfelelő állapotba hozását szolgálja.
     * @param b A pálya.
     * @param w A mező által elbírt entitások száma.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitások.
     */
    public abstract void Setup(Board b, int w, int s, Optional<Item> i, ArrayList<Entity> e);

    /**
     * Beregisztrál egy szomszédot.
     * @param neighbour A mező új szomszédja.
     */
    public void ConnectTo(Field neighbour) {
        this.neighbors.add(neighbour);
    }

    /**
     * Adott szomszéd lecserélése.
     * @param newNeighbor új szomszéd referenciája.
     * @param oldNeighbor régi szomszéd referenciája.
     */
    public void changeNeighbor(Field newNeighbor, Field oldNeighbor)
    {
        this.neighbors.remove(oldNeighbor);
        this.neighbors.add(newNeighbor);
    }

    /**
     * A Field FieldBehaviour referenciáját állítja át.
     * @param fb A beállítani kívánt FieldBehaviour.
     */
    public void setBehaviour(FieldBehaviour fb){
        behaviour = fb;
    }

    /**
     * Ezen Field-en lévő Player átmozgatása egy szomszédos fieldre.
     * @param direction A Field szomszédjai közül való a megfelelő
     *                  irányban lévő kiválasztásáhot.
     * @param entity    Arra az Entity-re referencia, amelyik Entity-t
     *                  át kell helyezni ennek a metódusnak egy másik
     *                  Field-re.
     */
    public void placeEntityToNextField(int direction, Entity entity){
         neighbors.get(direction).acceptEntity(entity);
         this.entities.remove(entity);
    }

    /**
     * Adott szomszédos Field-re mozgat egy Entity-t.
     * @param whereTo A szomszédos Field referenciája, ahova mozgatjuk az Entity-t.
     * @param entity Az Entity referenciája, akit mozgatunk.
     */
    public void placeEntityToNextField(Field whereTo, Entity entity){
        int direction = neighbors.indexOf(whereTo);
        placeEntityToNextField(direction, entity);
    }

    /**
     * Argumentumként kapott irányba lévő Fieldről kezdeményi egy Entity
     * átmozgatását erre a Fieldre.
     * @param direction Azon irány emerről kezdeményezzük egy Entity kimentését.
     * @return Amennyiben sikerült áthelyezni Entityt true, máskülönben false értékkel tér vissza.
     */
    public boolean pullOutPlayerFrom(int direction){
        Entity entity = neighbors.get(direction).selectEntity();
        if(entity != null)
        {
            neighbors.get(direction).placeEntityToNextField(this, entity);
            return true;
        }
        return false;

    }

    /**
     * Field-en lévő hómennyiség megváltoztatása.
     * @param delta mennyiségváltozás
     * @return ha próbáljuk csökkenteni a hómennyiséget, amikor nincs a Fielden hó,
     *          akkor false-al tér vissza.
     */
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

    public static int getMaxSnowLevel(){
        return MAX_SNOWLEVEL;
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }

    /**
     * Entitások száma az adott mezőn.
     * @return entitások száma.
     */
    public int getEntityCount(){
        return entities.size();
    }

    /**
     * Felhasználói input-ra történő kiválasztása egy adott Field-en található Entity-nek.
     * @return kiválasztott Entity.
     */
    public abstract Entity selectEntity();

    /**
     * Field-en található hómennyiség lekérdezése.
     * @return hómennyiség.
     */
    public int getSnowLevel(){
        return snowLevel;
    }

    /**
     * Új Entity befogadása.
     * @param entity Field-re lépő Entity referenciája.
     */
    public abstract void acceptEntity(Entity entity);

    /**
     * Iglu építése. Ha sikeres az építés True-val tér vissza.
     * @return sikeres építés.
     */
    public abstract boolean buildIgloo();

    /**
     * Sátor építése a Field-re. Ha sikeres az építés True-val tér vissza.
     * @return sikeres építés.
     */
    public abstract boolean buildTent();

    /**
     * Sátor elpusztítása.
     */
    public abstract void destroyTent();

    /**
     * Havazás a Field-en.
     */
    public final void performSnow() {
        behaviour.performSnow(entities);
    }

    /**
     * A Field-re lépő Entity-t interakcióba lépteti a már Field-en álló Entity-kkel.
     * @param enteringEntity
     */
    public void collideEntities(Entity enteringEntity){
        behaviour.collideEntities(enteringEntity, entities);
    }

    /**
     * Lekérdezi a Field stabilitását.
     * @return stabilitás.
     */
    public abstract String checkStability();

    /**
     * Lekérdezi egy adott szomszédos Field stabilitását.
     * @param direction irány, amerre a szomszédos Field található.
     * @return stabilitás.
     */
    public final String checkStability(int direction) {
        Field neighbour = neighbors.get(direction);
        return neighbour.checkStability();
    }

    /**
     * Kör végén a Field-en lévő Entity-k léptetése, és ha van sátor, azt elpusztítjuk.
     */
    public void step(){
        // direkt nem foreach!
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).step();
        }

        destroyTent();
    }

    /**
     * Befejezi az Entitások körét.
     */
    public void endEntitiesTurn() {
        for(Entity e: entities) {
            e.endTurn();
        }
    }

    /**
     * Visszaadja a szomszédok számát.
     * @return szomszédos Field-ek száma.
     */
    public int getNeighbourCount() {
        return neighbors.size();
    }

    /**
     * A Field-en lévő Item lekérdezése.
     * @return item.
     */
    public abstract Item getItem();

    /**
     * A Field-en lévő Item eltávolítása.
     */
    public abstract void removeItem();

}
