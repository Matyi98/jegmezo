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
        System.out.println("8: QuestItem használata");
        System.out.println("9: Játékos sebzése/hóvihar");
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
                    damagePlayer();
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

    public GameController initOneEskimoWithAFieldAboveThem( Field fieldAbove){
        Field fieldUnderPlayer = new StableIceField();
        GameController gc = new GameController();
        Player player = new Eskimo(gc, fieldUnderPlayer);
        fieldUnderPlayer.setNeighborAbove(fieldAbove);

        return gc;
    }

    public GameController initOneArcticExplorerWithAFieldAboveThem( Field fieldAbove){
        Field fieldUnderPlayer = new StableIceField();
        GameController gc = new GameController();
        Player player = new ArcticExplorer(gc, fieldUnderPlayer);
        gc.addPlayer(player);
        fieldUnderPlayer.setNeighborAbove(fieldAbove);

        return gc;
    }

    public void checkStability(){

        GameController gameController = initOneArcticExplorerWithAFieldAboveThem( new UnstableIceField() );

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('p');
    }

    public void buildIgloo(){

        GameController gameController = initOneArcticExplorerWithAFieldAboveThem( new UnstableIceField() );

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('p');
    }

    public void changeSnowLevel(){

        GameController gameController = initOneArcticExplorerWithAFieldAboveThem( new UnstableIceField() );

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('c');
    }

    public void moveUnsuccessful(){
        GameController gameController = initOneArcticExplorerWithAFieldAboveThem( new UnstableIceField() );

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('w');
    }

    public void moveSuccessful(){
        GameController gameController = initOneArcticExplorerWithAFieldAboveThem( new StableIceField() );

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'p' mint speciális képesség meghívása.
         */
        gameController.start('w');
    }

    public void pickUpItem() {

        GameController gc = new GameController();
        IceField f = new StableIceField(new Shovel());
        Player p = new Eskimo(gc, f);

        p.pickUpItem();
    }

    public void pickUpQuestItem() {
        GameController gc = new GameController();
        IceField f = new StableIceField(new Flare());
        Player p = new Eskimo(gc, f);

        p.pickUpItem();
    }

    public void useQuestItem() {
        GameController gc = new GameController();
        IceField f = new StableIceField(new Flare());
        Player p = new Eskimo(gc, f);
        p.pickUpItem();

        p.pickUpItem();
    }

    public void damagePlayer()
    {
        GameController gc = new GameController();
        Field f1 = new StableIceField();
        //A playert létrehozzuk, és beállítjuk a hozzá tartozó gc-t és fieldet
        Player e1 = new Eskimo(gc, f1);
        //A fieldre rátesszük a playert
        f1.acceptPlayer(e1);
        //A fielden havazást idézünk elő
        f1.snow();
    }

}
