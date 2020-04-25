package entities.behaviours;

import entities.Player;

public class DrowningState extends PlayerState{
    public DrowningState(Player player) {
        super(player);
    }

    @Override
    public void makeDrown(){
        player.die();
    }

    @Override
    public void makeWalk(){
        player.setState(new NormalState(player));
    }
}
