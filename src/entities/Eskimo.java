package entities;

import game.GameController;
import localization.Language;

/**
 * Eszkimó, amelyet a játékos irányíthat. Képes iglukat építeni.
 */
public class Eskimo extends Player {
    private final int ID;

    public Eskimo() {
        super();
        ID = autoIncrementID++;
        maxHealthPoints = 5;
        healthPoints = maxHealthPoints;
    }

    @Override
    public String getFancyName() {
        return Language.Selected().EskimoName(ID);
    }

    @Override
    public void ShowShort() {
        GameController.OutStream.print("E");
    }


    /**
     * Eszkimó speciális képessége.
     * Igloot épít az alatta lévő Fieldre
     */
    @Override
    public void specialPower() {
        //iglut épít.
        if(actionPoints != 0)
        {
            if (fieldUnder.buildIgloo()) {
                actionPoints--;
            }
        }
    }

    /**
     * Az eszkimóhoz tartozó képfájl elérési útját adja meg
     * @return Az elérési út
     */
    @Override
    public String GetTexturePath() {
        return "textures/entity_textures/eskimo.png";
    }
}
