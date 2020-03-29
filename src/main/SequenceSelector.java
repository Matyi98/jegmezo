package main;
import fields.*;
import items.Flare;
import items.Inventory;
import items.Shovel;
import player.ArcticExplorer;
import player.Eskimo;
import player.Player;

import java.util.Scanner;

public class SequenceSelector {

    final int NO_INPUT = 200;
    final int EXIT = 0;

    public int getUserInput(){
        Scanner s = new Scanner(System.in);
        int inp = NO_INPUT;
        try {
            inp = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e){

        }

        return inp;
    }

    public void showSequenceCases(){
        System.out.println("Egy szám megnyomásával majd az Enter leütésével válassz teszt szekvenciát!");
        System.out.println("A " + "0 + Enter" + " leütésével pedig kiléphetsz a programból.");
        System.out.println("1.: Sarkkutató jégtáblát vizsgál.");
        System.out.println("2.: Eskimo iglu épít");
        System.out.println("3.: Eskimo havat takarít");
        System.out.println("4.: Eskimo UnstableIceFieldről OceanFieldre lép sikertelenül");
        System.out.println("5.: Sarkkutató UnstableIceFieldről StableIceFieldre lép sikeresen");
        System.out.println("6: Item felvétele");
        System.out.println("7: QuestItem felvétele");
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
                case 4:
                    moveUnsuccesfull();
                    break;
                case 5:
                moveSuccesfull();
                    break;
                case 6:
                    pickUpItem();
                    break;
                case 7:
                    pickUpQuestItem();
                    break;
                case 8:
                    useQuestItem();
                    break;
                case 9:
                    useQuestItemFail();
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

        // Mező, amin a játékos áll.
        Field fieldUnderPlayer = new StableIceField();

        //Beállítjuk, hogy a 2 létrehozott mező szomszédos legyen
        fieldUnderPlayer.setNeighborAbove(neighbourField);

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

    public void moveUnsuccesfull(){
        // Szomszédos OceanField, amire nem tudunk rálépni.
        Field neighbourField = new OceanField();

        Field fieldUnderPlayer = new UnstableIceField();

        fieldUnderPlayer.setNeighborAbove(neighbourField);

        // Stabilitás vizsgálatot csak kutató tudja végrehajtani.
        Player player = new Eskimo(fieldUnderPlayer);

        // GameController beteszi a listájába a lokálisan inicializált kutatót.
        GameController gameController = new GameController(player);

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('w');
    }

    public void moveSuccesfull(){
        // Szomszédos OceanField, amire nem tudunk rálépni.
        Field neighbourField = new StableIceField();

        Field fieldUnderPlayer = new UnstableIceField();

        fieldUnderPlayer.setNeighborAbove(neighbourField);

        // Stabilitás vizsgálatot csak kutató tudja végrehajtani.
        Player player = new ArcticExplorer(fieldUnderPlayer);

        // GameController beteszi a listájába a lokálisan inicializált kutatót.
        GameController gameController = new GameController(player);

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('w');
    }

    public void pickUpItem() {

        GameController gc = new GameController();
        IceField f = new StableIceField(new Shovel());
        Player p = new Eskimo(gc, f);

        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        p.pickUpItem();
    }

    public void pickUpQuestItem() {
        GameController gc = new GameController();
        IceField f = new StableIceField(new Flare());
        Player p = new Eskimo(gc, f);

        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        p.pickUpItem();
    }

    public void useQuestItem() {
        GameController gc = new GameController();
        IceField f = new StableIceField(new Flare());
        Player p = new Eskimo(gc, f);
        p.pickUpItem();
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        p.pickUpItem();
    }

}
