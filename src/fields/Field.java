package fields;

import enums.Direction;
import items.Item;
import player.Player;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public abstract class Field {
    private int snowLevel;
    private static int MAX_SNOWLEVEL;
    protected EnumMap<Direction, Field> neighbors;
    protected List<Player> players = new ArrayList<>();
    protected Item item;

    public Field(){
        neighbors = new EnumMap<>(Direction.class);

        neighbors.put(Direction.UP, null);
        neighbors.put(Direction.DOWN, null);
        neighbors.put(Direction.LEFT, null);
        neighbors.put(Direction.RIGHT, null);
    }

    //Felső szomszédmező beállítása
    public void setNeighborAbove( Field field ){
        neighbors.put(Direction.UP, field);
    }

    //Alsó szomszédmező beállítása
    public void setNeighborBelow( Field field ){
        neighbors.put(Direction.DOWN, field);
    }

    //Baloldali szomszédmező beállítása
    public void setNeighbourLeftSide( Field field ){
        neighbors.put(Direction.LEFT, field);
    }

    //Jobboldali szomszédmező beállítása
    public void setNeighbourRightSide( Field field ){
        neighbors.put(Direction.RIGHT, field);
    }

    //Ezen fielden lévő player átmozgatása egy szomszédos fieldre
    public boolean placePlayerToNextField(Direction direction, Player player){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return neighbors.get(direction).acceptPlayer(player);
    }

    //Ezen fielden lévő player átmozgatása egy szomszédos fieldre user által kiválasztott alapon
    public boolean placePlayerToNextField(Direction direction){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Áthelyezi a játékost az adott irányban lévő mezőre
        boolean success = neighbors.get(Direction.RIGHT).acceptPlayer(players.get(0));
        return success;
    }

    //Áthúz egy playert egy szomszédos mezőről saját magához
    public boolean pullOutPlayerFrom(Direction direction){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //A kijelölt szomszédban lévő mezőt felszólítja, hogy adja át valamelyik játékosát
        boolean success = neighbors.get(direction).placePlayerToNextField(Direction.RIGHT);
        //A játékos állapotváltozását idézi elő
        players.get(1).makePlayerWalk();
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
        for(Player p: players)
        {
            p.decrementHP();
        }


    }

    //Megmondja, hogy hány játékos áll a mezőn.
    public int getPlayerCount(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return players.size();
    }

    //Egy játékos kiválasztása a fielden
    public Player selectPlayer() {
        return null;
    }

    //Adott playert helyez a mezőre
    public abstract boolean acceptPlayer(Player player);

    //Iglut épít a mezőre
    public abstract boolean buildIgloo();

    //Megnézi a mező stabilitását
    public abstract String checkStability();

    //Megnézi szomszédos mező stabilitását.
    public final String checkStability(Direction direction) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        Field neighbour = neighbors.get(direction);
        return neighbour.checkStability();
    }

    //Ideiglenes függvény, szekvenciák inicializálásának segítésére.
    public void _AddPlayer(Player p) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        players.add(p);
    }
}
