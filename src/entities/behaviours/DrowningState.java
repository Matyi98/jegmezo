package entities.behaviours;

import entities.Player;
import scene.GameController;

public class DrowningState extends PlayerState{
    public DrowningState(Player player) {
        super(player);
        GameController.OutStream.println("Fell into hole");
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
