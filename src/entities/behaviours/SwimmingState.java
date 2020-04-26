package entities.behaviours;

import entities.Player;
import scene.GameController;

/**
 * A játékosokat megvalósító Player osztály,
 * úszó állapotának viselkedését reprezentáló
 * implementációs osztály.
 */
public class SwimmingState extends PlayerState{
    public SwimmingState(Player player) {
        super(player);
    }

    /**
     * A Playernek CanSwimState állapotot állít be a Player setState metódusának segítségével.
     * Így a Player SwimmingState állapotból CanSwimState állapotba kerülhet, amennyiben olyan esemény
     * következik be, amely a Playert SwimmingState állapotból NormalState állapotba akarja hozni.
     */
    @Override
    public void makeWalk(){
        GameController.OutStream.println(player.getName() + " Climbed out");
        player.setState(new CanSwimState(player));
    }
}
