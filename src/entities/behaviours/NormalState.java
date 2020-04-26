package entities.behaviours;

import entities.Player;
import scene.GameController;

public class NormalState extends PlayerState {
    public NormalState(Player player) {
        super(player);
    }

    @Override
    public void swapDivingSuit(){
        player.setState(new CanSwimState(player));
        GameController.OutStream.println(player.getName() + " equiped DivingSuit");
    }

    @Override
    public void makeDrown() {
        GameController.OutStream.println(player.getName() + " fell into hole");
        player.setState(new DrowningState(player));
    }
}
