package entities.behaviours;

import entities.Player;
import game.GameController;

/**
 * A játékosokat megvalósító Player osztály, szárazföldön lévő és divingsuits nélküli
 * állapotának viselkedését reprezentáló implementációs osztály.
 */
public class NormalState extends PlayerState {

    /**
     * Konstruktor
     * @param player Referencia ezzel a PlayerStattel rendelkező játékosra
     */
    public NormalState(Player player) {
        super(player);
    }

    /**
     * A Playernek CanSwimState állapotot állít be a Player setState metódusának segítségével.
     * Így a Player NormalState állapotból CanSwimState állapotba kerülhet DivingSuit felvétele esetén.
     */
    @Override
    public void swapDivingSuit(){
        player.setState(new CanSwimState(player));
        GameController.OutStream.println(player.getName() + " equiped DivingSuit");
    }

    /**
     * A  Playernek DrowningState állapotot állít be a Player setState metódusának segítségével.
     * Így a Player NormalState állapotból DrowningState állapotba kerülhet, amennyiben olyan esemény
     * következik be, amely a Playert DrowningState állapotba akarja hozni.
     */
    @Override
    public void makeDrown() {
        GameController.OutStream.println(player.getName() + " fell into hole");
        player.setState(new DrowningState(player));
        player.endTurn();
    }
}
