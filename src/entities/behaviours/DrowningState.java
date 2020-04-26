package entities.behaviours;

import entities.Player;
import scene.GameController;

public class DrowningState extends PlayerState{
    public DrowningState(Player player) {
        super(player);
    }

    @Override
    public void makeDrown(){
        GameController.OutStream.println(player.getName() +" Drowned");
        player.die();
    }

    @Override
    public void makeWalk(){
        GameController.OutStream.println(player.getName() +" Rescued");
        player.setState(new NormalState(player));
    }
}
