package entities.behaviours;

import entities.Player;
import scene.GameController;

public class CanSwimState extends PlayerState{
    public CanSwimState(Player player) {
        super(player);
    }

    @Override
    public void makeDrown(){
        GameController.OutStream.println(player.getName() +" Started swimming");
        player.setState(new SwimmingState(player));
    }

    @Override
    public void swapDivingSuit() {
        player.setState(new NormalState(player));
        GameController.OutStream.println(player.getName() + " DivingSuit unequiped");
    }
}
