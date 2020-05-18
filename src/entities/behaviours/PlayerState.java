package entities.behaviours;

import entities.Player;
import utility.IOptionTextured;

/**
 * A Player által képviselt állapotokat megvalósító implementációs osztályok őse.
 * Ezt a referencia típust tartalmazza a Player, ami tud különböző leszármazott
 * típusokra mutatni, lehetővé téve a Player különböző állapotaiba való áttérést.
 */
public abstract class PlayerState implements IOptionTextured {
    /**
     * Azon Playerre referencia, amelyik Player állapotát megvalósítja
     * a PlayerState leszármazott osztálya.
     */
    protected Player player;

    /**
     * Konstruktor
     * @param player Referencia ezzel a PlayerStattel rendelkező játékosra
     */
    public PlayerState(Player player) {
        this.player = player;
    }

    /**
     * Implementációval nem rendelkező metódus. A leszármazott osztály
     * implementációja alapján más állapotba helyezheti a Playert.
     */
    public void makeDrown(){


    }

    /**
     * Implementációval nem rendelkező metódus. A leszármazott osztály
     * implementációja alapján más állapotba helyezheti a Playert.
     */
    public void makeWalk(){

    }

    /**
     * Implementációval nem rendelkező metódus. A leszármazott osztály
     * implementációja alapján más állapotba helyezheti a Playert.
     */
    public void swapDivingSuit(){

    }
}
