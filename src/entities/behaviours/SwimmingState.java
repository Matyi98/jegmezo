package entities.behaviours;

import entities.Player;

public class SwimmingState extends PlayerState{

    public SwimmingState(Player player) {
        super(player);
    }

    @Override
    public void walk(){
        player.setState(new CanSwimState(player));
    }
}
