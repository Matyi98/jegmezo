package entities.behaviours;

import entities.Player;

public class CanSwimState extends PlayerState{
    public CanSwimState(Player player) {
        super(player);
    }

    @Override
    public void makeDrown(){
        player.setState(new SwimmingState(player));
    }

    @Override
    public void swapDivingSuit(){
        player.setState(new NormalState(player));
    }
}
