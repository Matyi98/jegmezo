package main;
import fields.*;
import items.*;
import items.quest.*;
import player.*;

import java.util.Scanner;

/*
* Szkeleton tesztelésre szolgáló osztály
* A felhasználónak kiírja, hogy milyen szekvenciákat lehet tesztelni.
* A felhasználó megadja szekvencia sorszámát.
*  Majd lefut a szekvencia.
* A Futás eredménye a sztenderd outputon látható.
* A függvény hívások kiírják: csomag.Osztály.függvény formátumban a nevüket.
* Előbbi alapján visszakövethető a szekvenciák helyes lefutása.
* */

public class SequenceSelector {

    final int NO_INPUT = 200;
    final int EXIT = 0;

    //felhasználói bemenet kérése.
    public int getUserInput(){
        Scanner s = new Scanner(System.in);
        int inp = NO_INPUT;
        try {
            inp = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e){

        }

        return inp;
    }

    /*
    Kommunikác a felhasználóval.
    Kiírja, hogy milyen szekvenciákat lehet tesztelni.
     */
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
        System.out.println("11: Ásás kézzel.");
        System.out.println("12: Ásás lapáttal.");
        System.out.println("13: Kötél használata");
    }

    /*
    Szekvencia választó.
    A kiválsztott szekvenciákat ez a függvény futtatja.
     */
    public void selectSequence(){
        int userInput = NO_INPUT;
        //Lehetséges szekvenciák kilistázása.
        showSequenceCases();

        while(EXIT != (userInput = getUserInput())){

            switch (userInput) {
                case NO_INPUT:
                    break;
                case 1:
                    //Jégtábla stabilitás ellenőrzés.
                    checkStability();
                    break;
                case 2:
                    //Iglu építés
                    buildIgloo();
                    break;
                case 3:
                    //Havazás.
                    changeSnowLevel();
                    break;
                case 4:
                    //Sikertelen mozgás
                    moveUnsuccessful();
                    break;
                case 5:
                    //Sikeres mozgás.
                    moveSuccessful();
                    break;
                case 6:
                    //Eszkösz felvétele.
                    pickUpItem();
                    break;
                case 7:
                    //Küldetési eszküöz felvétele.
                    pickUpQuestItem();
                    break;
                case 8:
                    //küldetési eszköz használata.
                    useQuestItem();
                    break;
                case 9:
                    //játékosok sebzése.
                    damagePlayer();
                    break;
                case 10:
                    //Evés.
                    eating();
                    break;
                case 11:
                    //Ásás kézzel.
                    digByHand();
                    break;
                case 12:
                    //Ásó használata.
                    useShovel();
                    break;
                case 13:
                    //Kötél használata.
                    useRope();
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

        GameController gameController = initOneEskimoWithAFieldAboveThem(new UnstableIceField() );

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

    public void digByHand() {
        //Szekvencia inicializálása.
        System.out.println("<<digByHand Inicializálás kezdete:>>");
        //Teszt gameController létrehozása.
        GameController gc = new GameController();
        //Ideiglenes mező létrehozása, egy tetszőleges Itemmel.
        IceField f = new StableIceField(new Rope());
        //Alap hószint beállítása.
        f.changeSnowLevel(1);
        //Player Inicializálása.
        Player p = new Eskimo(gc, f);

        System.out.println("<<digByHand szekvencia kezdete:>>");
        //Szekvencia kezdete.

        //Ásás kézzel
        p.shovel(1);
        //Ásás kézzel, hó nélküli mezőn.
        p.shovel(1);
    }

    public void useShovel() {
        //Szekvencia inicializálása.
        System.out.println("<<useShovel Inicializálás kezdete:>>");
        //Teszt gameController létrehozása.
        GameController gc = new GameController();
        //Ideiglenes mező létrehozása, egy tetszőleges Itemmel.
        IceField f = new StableIceField(new Shovel());
        //Alap hószint beállítása.
        f.changeSnowLevel(2);
        //Player Inicializálása.
        Player p = new Eskimo(gc, f);
        p.pickUpItem();

        System.out.println("<<useShovel szekvencia kezdete:>>");
        //Szekvencia kezdete.

        p.useItem(0);
    }

    public void damagePlayer()
    {
        System.out.println("<<damagePlayer Inicializálás kezdete:>>");
        GameController gc = new GameController();
        Field f1 = new StableIceField();
        //A playert létrehozzuk, és beállítjuk a hozzá tartozó gc-t és fieldet
        Player e1 = new Eskimo(gc, f1);
        //A fieldre rátesszük a playert
        f1.acceptPlayer(e1);
        //A fielden havazást idézünk elő
        System.out.println("<<damagePlayer szekvencia kezdete:>>");
        for (int i = 0; i<5; i++) {
            f1.snow();
        }
    }

    public void eating(){
        System.out.println("<<eating Inicializálás kezdete:>>");
        GameController gc = new GameController();
        Field fieldUnderPlayer = new StableIceField(new Food());
        Player player = new Eskimo(gc, fieldUnderPlayer);
        player.pickUpItem();
        System.out.println("<<eating szekvencia kezdete:>>");
        player.useItem(0);
    }

    public void divingSuit() {
        //Szekvencia inicializálása.
        System.out.println("<<divingSuit Inicializálás kezdete:>>");
        //Teszt gameController létrehozása.
        GameController gc = new GameController();
        //Ideiglenes mező létrehozása, egy tetszőleges Itemmel.
        IceField f = new StableIceField(new DivingSuit());
        //Player Inicializálása.
        Player p = new Eskimo(gc, f);
        p.pickUpItem();

        System.out.println("<<divingSuit szekvencia kezdete:>>");
        //Szekvencia kezdete.

        p.useItem(0);
    }

    public void useRope()
    {
        System.out.println("<<useRope Inicializálás kezdete:>>");
        //A kötél használatában lévő mezők inicializálása
        Field f2 = new Hole();
        Field f1 = new StableIceField(new Rope());
        //A mezők szomszédainak beállítása
        f1.setNeighbourLeftSide(f2);
        f2.setNeighbourRightSide(f1);
        //Controller inicializálása
        GameController gc = new GameController();
        //A kötél használatában résztvevő játékosok inicializálása
        Player p1 = new Eskimo(gc, f1);
        Player p2 = new ArcticExplorer(gc, f2);
        //A játékosok mezőre helyezése
        f1.acceptPlayer(p1);
        f2.acceptPlayer(p2);
        //Az első játékosnak a kötél odaadása
        p1.pickUpItem();
        //lényegi működés
        System.out.println("<<useRope szekvencia kezdete:>>");
        p1.useItem(0);
    }

}
