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
    }

    public Field(Field neighbour){
        neighbors = new EnumMap<>(Direction.class);

        neighbors.put(Direction.UP, neighbour);
        neighbors.put(Direction.DOWN, neighbour);
        neighbors.put(Direction.LEFT, neighbour);
        neighbors.put(Direction.RIGHT, neighbour);
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
