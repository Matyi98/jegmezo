package entities.behaviours;

import entities.Player;
import scene.GameController;

public class SwimmingState extends PlayerState{

    public SwimmingState(Player player) {
        super(player);
    }

    @Override
    public void makeWalk(){
        GameController.OutStream.println(player.getName() + " climbed out");
        player.setState(new CanSwimState(player));
    }
}
