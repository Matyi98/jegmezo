package entities.behaviours;

import entities.Player;
import scene.GameController;

public class SwimmingState extends PlayerState{

    public SwimmingState(Player player) {
        super(player);
        GameController.OutStream.println("Fell into hole");
    }

    @Override
    public void makeWalk(){
        player.setState(new CanSwimState(player));
    }
}
