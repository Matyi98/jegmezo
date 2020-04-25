package entities.behaviours;

import entities.Player;

public class DrowningState extends PlayerState{
    public DrowningState(Player player) {
        super(player);
    }

    @Override
    public void drown(){
        player.die();
    }

    @Override
    public void walk(){
        player.setState(new NormalState(player));
    }
}
