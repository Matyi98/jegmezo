package main;
import fields.*;
import items.Flare;
import items.Food;
import items.Inventory;
import items.Shovel;
import items.*;
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
        System.out.println("10: Evés");
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
                    buildIgloo();
                    break;
                case 3:
                    changeSnowLevel();
                    break;
                case 4:
                    moveUnsuccessful();
                    break;
                case 5:
                    moveSuccessful();
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
                case 10:
                    eating();
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
        //Field amin a player áll
        Field fieldUnderPlayer = new StableIceField();
        //GameController, amely irányítja a playert
        GameController gc = new GameController();
        //ArcticExplorer player létrehozása
        Player player = new Eskimo(gc, fieldUnderPlayer);
        //GameControllerhez hozzáadjuk a játékost
        gc.addPlayer(player);
        //Beállítjuk, hogy a mezők szomszédosak legyenek
        fieldUnderPlayer.setNeighborAbove(fieldAbove);

        return gc;
    }

    public GameController initOneArcticExplorerWithAFieldAboveThem( Field fieldAbove){
        //Field amin a player áll
        Field fieldUnderPlayer = new StableIceField();

        //GameController, amely irányítja a playert
        GameController gc = new GameController();

        //ArcticExplorer player létrehozása
        Player player = new ArcticExplorer(gc, fieldUnderPlayer);

        //GameControllerhez hozzáadjuk a játékost
        gc.addPlayer(player);

        //Beállítjuk, hogy a mezők szomszédosak legyenek
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
         *  'c' mint speciális képesség meghívása.
         */
        gameController.start('c');
    }

    public void moveUnsuccessful(){
        GameController gameController = initOneArcticExplorerWithAFieldAboveThem( new UnstableIceField() );

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'w' mint speciális képesség meghívása.
         */
        gameController.start('w');
    }

    public void moveSuccessful(){
        GameController gameController = initOneArcticExplorerWithAFieldAboveThem( new StableIceField() );

        /** Paraméterként kapja meg most a gamecontroller a user inputot.
         *  'w' mint speciális képesség meghívása.
         */
        gameController.start('w');
    }

    //Item felvétele szekvencia.
    public void pickUpItem() {
        //Szekvencia inicializálása.
        System.out.println("<<pickUpItem Inicializálás kezdete:>>");
        //Teszt gameController létrehozása.
        GameController gc = new GameController();
        //Ideiglenes mező létrehozása, egy sima Itemmel.
        IceField f = new StableIceField(new Shovel());
        //Player Inicializálása.
        Player p = new Eskimo(gc, f);

        System.out.println("<<pickUpItem szekvencia kezdete:>>");
        //Szekvencia kezdete.
        p.pickUpItem();
    }

    //Quest Item felvétele szekvencia.
    public void pickUpQuestItem() {
        //Szekvencia inicializálása.
        System.out.println("<<pickUpQuestItem Inicializálás kezdete:>>");
        //Teszt gameController létrehozása.
        GameController gc = new GameController();
        //Ideiglenes mező létrehozása, egy QuestItemmel.
        IceField f = new StableIceField(new Flare());
        //Player Inicializálása.
        Player p = new Eskimo(gc, f);

        System.out.println("<<pickUpQuestItem szekvencia kezdete:>>");

        //Szekvencia kezdete.
        p.pickUpItem();
    }

    //Quest Item használata szekvencia.
    public void useQuestItem() {
        //Szekvencia inicializálása.
        System.out.println("<<useQuestItem Inicializálás kezdete:>>");
        //Teszt gameController létrehozása.
        GameController gc = new GameController();
        //Ideiglenes mező létrehozása, egy QuestItemmel.
        IceField f = new StableIceField(new Flare());
        //Player Inicializálása.
        Player p = new Eskimo(gc, f);
        //Quest Item felvétele a p inventoryjába.
        p.pickUpItem();

        IceField f1 = new StableIceField(new Cartridge());
        Player p1= new Eskimo(gc, f1);
        p1.pickUpItem();

        IceField f2 = new StableIceField(new Pistol());
        Player p2 = new Eskimo(gc, f2);
        p2.pickUpItem();

        //Playerek ráhelyezése a f2 mezőre.
        f2._AddPlayer(p);
        f2._AddPlayer(p1);
        f2._AddPlayer(p2);

        /*
            Playerek beregisztrálása a gameControllerbe.
            Ez egy ideiglenes megoldás az egyszerű inicializálás és tesztelés érdekében.
        */
        gc.addPlayer(p);
        gc.addPlayer(p1);
        gc.addPlayer(p2);

        System.out.println("<<useQuestItem szekvencia kezdete:>>");

        //Szekvencia kezdete.
        p2.useItem(0);
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

    public void eating(){
        GameController gc = new GameController();
        Field fieldUnderPlayer = new StableIceField(new Food());
        Player player = new Eskimo(gc, fieldUnderPlayer);
        player.pickUpItem();
        player.useItem(0);
    }

}
