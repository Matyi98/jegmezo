package main;
import fields.Field;
import fields.StableIceField;
import fields.UnstableIceField;
import player.ArcticExplorer;
import player.Player;

import java.io.IOException;

public class Sequence {

    final int NO_INPUT = 200;
    final int EXIT = 0;

    public int getUserInput(){
        int input = NO_INPUT;
        try{
            input = System.in.read();
        } catch (IOException e){

        }
        return input;
    }

    public void seqSelector(){
        int userInput;
        while(EXIT != (userInput = getUserInput())){

            switch (userInput) {
                case NO_INPUT:
                    break;
                case 1:
                    checkStability();
                    break;
            }
        }
    }

    public void checkStability(){
        // Szomszédos mező, amin el szeretnénk végezni a stabilitás vizsgálatot.
        Field neighbourField = new UnstableIceField();

        /** Mező, amin a játékos áll.
         *  Konstruktorban kapott Fieldet beállítja minden irányba szomszédnak.
          */

        Field fieldUnderPlayer = new StableIceField(neighbourField);

        // Stabilitás vizsgálatot csak kutató tudja végrehajtani.
        Player player = new ArcticExplorer(fieldUnderPlayer);

        // GameController beteszi a listájába a lokálisan inicializált kutatót.
        GameController gameController = new GameController(player);

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
          */
        gameController.start('p');
    }
}
