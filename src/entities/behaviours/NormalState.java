package entities.behaviours;

import entities.Player;

public class NormalState extends PlayerState {
    public NormalState(Player player) {
        super(player);
    }

    @Override
    public void swapDivingSuit(){
        player.setState(new CanSwimState(player));
    }

    @Override
    public void drown(){
        player.setState(new DrowningState(player));
    }
}
