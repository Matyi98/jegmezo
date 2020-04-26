package entities.behaviours;

import entities.Player;
import scene.GameController;

/**
 * A játékosokat megvalósító Player osztály,
 * fuldokló állapotának viselkedését reprezentáló implementációs osztály.
 */
public class DrowningState extends PlayerState{

    /**
     * Konstruktor
     * @param player Referencia ezzel a PlayerStattel rendelkező játékosra
     */
    public DrowningState(Player player) {
        super(player);
    }

    /**
     * Amennyiben a Player DrowningState állapotban van és a Playeren egy
     * újabb megfullasztást indukáló metódus hívás következik be, akkor a
     * Playert megöli a metódus annak die() metódusának segítségével.
     */
    @Override
    public void makeDrown(){
        GameController.OutStream.println(player.getName() +" drowned");
        player.die();
    }

    /**
     * A Playernek NormalState állapotot állít be a Player setState metódusának segítségével.
     * Így a Player DrowningState állapotból NormalState állapotba kerülhet, amennyiben olyan esemény
     * következik be, amely a Playert DrowningState állapotból NormalState állapotba akarja hozni.
     */
    @Override
    public void makeWalk(){
        GameController.OutStream.println(player.getName() +" rescued");
        player.setState(new NormalState(player));
    }
}
