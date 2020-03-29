package main;
import fields.Field;
import fields.StableIceField;
import fields.UnstableIceField;
import player.ArcticExplorer;
import player.Eskimo;
import player.Player;

import java.util.Scanner;

public class SequenceSelector {

    final int NO_INPUT = 200;
    final int EXIT = 0;

    public int getUserInput(){
        Scanner s = new Scanner(System.in);
        int inp = 200;
        try {
            inp = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e){

        }

        return inp;
    }

    public void showSequenceCases(){
        System.out.println("Egy szám megnyomásával majd az Enter leütésével válassz teszt szekvenciát!");
        System.out.println("1.: Sarkkutató jégtáblát vizsgál.");
        System.out.println("2.: Eskimo iglu épít");
        System.out.println("3.: Eskimo havat takarít");
    }

    public void selectSequence(){
        int userInput = NO_INPUT;

        showSequenceCases();

        while(EXIT != (userInput = getUserInput())){

            switch (userInput) {
                case NO_INPUT:
                    break;
                case 1:
                    checkStability();
                    break;
                case 2:
                    buildIglu();
                    break;
                case 3:
                    changeSnowLevel();
                    break;
                default:
                    break;
            }

            System.out.println("\n");
            System.out.println("Egy gomb megnyomásával, majd az Enter leütésével újra indíthatod a programot.");
            System.out.println("A " + "0 + Enter" + " leütésével pedig kiléphetsz a programból.");
            if(0 == getUserInput())
                break;

            System.out.println("\n\n\n\n\n\n\n\n");
            showSequenceCases();
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

    public void buildIglu(){

        Field fieldUnderPlayer = new StableIceField();

        // Stabilitás vizsgálatot csak kutató tudja végrehajtani.
        Player player = new Eskimo(fieldUnderPlayer);

        // GameController beteszi a listájába a lokálisan inicializált kutatót.
        GameController gameController = new GameController(player);

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('p');
    }

    public void changeSnowLevel(){

        Field fieldUnderPlayer = new StableIceField();

        // Stabilitás vizsgálatot csak kutató tudja végrehajtani.
        Player player = new Eskimo(fieldUnderPlayer);

        // GameController beteszi a listájába a lokálisan inicializált kutatót.
        GameController gameController = new GameController(player);

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('c');
    }
}
