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

    public boolean placePlayerToNextField(Direction direction, Player player){
        return false;
    }

    public boolean pullOutPlayerFrom(Direction direction, Player player){
        return false;
    }

    public Item getItem(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return item;
    }

    public void removeItem() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
    }

    public boolean changeSnowLevel(int delta){ return false; }

    public void snow(){

    }

    public int getPlayerCount(){
        return players.size();
    }

    public Player selectPlayer() {
        return null;
    }

    public abstract boolean acceptPlayer(Player player);

    public abstract boolean buildIgloo();

    public abstract String checkStability();

    public abstract String checkStability(Direction direction);
}
