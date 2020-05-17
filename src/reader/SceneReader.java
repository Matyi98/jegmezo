package reader;

import entities.*;
import fields.*;
import items.*;
import items.quest.*;
import utility.RandomNumber;
import game.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * SceneReader osztály, amely fájlban rögzített játékállapotokat képes beolvasni és
 * ezáltal inicializálni a játékmenetet.
 */
public class SceneReader {
    /**
     * Játéktábla.
     */
    private Board board;
    /**
     * GameController.
     */
    private GameController gc;
    /**
     * Játékállapot összes field-je.
     */
    private ArrayList<Field> fields = new ArrayList<>();

    /**
     * Játékállapot összes játékosa.
     */
    private ArrayList<Player> players = new ArrayList<>();

    /**
     * Olvasáshoz szükséges.
     */
    private BufferedReader reader;

    /**
     * boolean tömb melybe a true érték jelzi hogy a megfelelő indexnél lévő
     * játékost el kell távolítani a játékból.
     */
    private boolean[] removes;

    /**
     * Boolean mely megadja hogy kell-e limitálnunk a játékosok számát
     */
    private boolean playerCountLimited = false;

    /**
     * A pályához tartozó játékos korlát
     */
    private int playerCountLimit = 10;

    /**
     * Konstruktor, amiben beolvassa a játékállapot fájlját.
     * @param inputStream inputStream ami tartalmazza a beolvasni kívánt játékállapotot.
     */
    public SceneReader(InputStream inputStream) {
        this.reader =
                new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * Fájlból beolvas adatokat, amelyek alapján inicializálja
     * a Boardot Fieldekkel, Entitykkel és Itemekkel, valamint
     * inicializálja a GameControllert.
     * @return GameController objektummal, amely ütemezi,
     *         értelmezi, majd a parancsokhoz hozzárendelt
     *         metódusokat meghívja.
     */
    public GameController LoadScene() {
        board = new Board();
        gc = new GameController();
        Entity.resetAutoIncrement();
        Field.resetAutoIncrement();
        GameController.resetAutoIncrement();
        RandomNumber.resetAutoIncrement();
        try {
            readAll();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        board.Setup(fields);
        gc.Setup(board, players);
        return gc;
    }

    /**
     * Random kiválasztjuk eltávolításra a pályán lévő játékosokat ha a számuk több
     * mint amennyi játékost a menüben beállítottunk
     * @throws IOException
     */
    private void generateRemoves() throws IOException {
        if (playerCountLimited) {
            String sPlayerInfo = this.reader.readLine();
            int initialPlayerCount = Integer.parseInt(sPlayerInfo);

            boolean[] ret = new boolean[initialPlayerCount];
            for (int i = 0; i < initialPlayerCount; i++)
                ret[i] = false;

            for (int i = 0; i < initialPlayerCount - playerCountLimit; i++) {
                int removedID;
                do {
                    removedID = RandomNumber.getNumber(initialPlayerCount - 1);
                } while (ret[removedID]);
                ret[removedID] = true;
            }
            removes = ret;
        }
    }

    /**
     * Fájlból beolvasott adatok alapján Field objektumokat hoz létre,
     * amelyeket eltárol az osztály fields gyűjteményében. Ezen kívül
     * beállítja a Fieldek közötti szomszédsági kapcsolatokat is.
     * @throws IOException A pálya leírást tartlamzó fájl beolvasása
     *                      közben technikai jellegű hiba adódott.
     */
    private void readAll() throws IOException {
        String sNodes = this.reader.readLine();
        String sEdges = this.reader.readLine();
        generateRemoves();

        String[] aNodes = sNodes.split(";");
        String[] aEdges = sEdges.split(";");

        for (String i : aNodes)
            fields.add(makeNode(i.trim()));

        for (String i : aEdges) {
            i = i.trim();
            String[] s = i.split(" ");
            int a = Integer.parseInt(s[0])-1;
            int b = Integer.parseInt(s[1])-1;
            Field fA = fields.get(a);
            Field fB = fields.get(b);
            fA.ConnectTo(fB);
            fB.ConnectTo(fA);
        }
    }

    /**
     * Fieldeket, Entityket és Itemeket hoz létre az argumentumként kapott
     * adatok alapján. A Fieldeket az agrumentum alapján meghatározott
     * állapotba inicializálja.
     * @param sNode Egy fájlból beolvasott bemeneti adategység, ami
     *              egy Field típust, annak snowLevel értékét, a Fielden
     *              lévő Itemet és a Fielden lévő Entityket határozza meg.
     * @return A paraméterként átvett adatok alapján példányosított Field.
     */
    private Field makeNode(String sNode) {
        Field f = null;
        try {
            f = parseField(sNode.charAt(0));
            int weightLimit = Character.getNumericValue(sNode.charAt(1));
            int snowLevel = Character.getNumericValue(sNode.charAt(2));
            Item item = parseItem(sNode.charAt(3));

            ArrayList<Entity> ents = new ArrayList<>();
            for (int i = 4; i < sNode.length(); i++) {
                Entity entity = parseEntity(sNode.charAt(i));
                if(entity != null) {
                    ents.add(entity);
                    entity.Setup(gc, f);
                }
            }

            f.Setup(board, weightLimit, snowLevel, Optional.ofNullable(item), ents);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return f;
    }

    /**
     * Az argumentum alapján azonosítható Field osztály
     * egy leszármazott osztályából hoz létre példányt.
     * @param c A beolvasott adategység egyik karaktere,
     *          ami alapján meghatározható egy Field pontos
     *          leszármazott típusa.
     * @return  Az argumentumként meghatározott típusú,
     *          a metóduson belül példányosított Field.
     * @throws Exception Szemantikailag vagy szintaktikailag
     *                   hibás a pályát tartalmazó fájl.
     */
    private Field parseField(char c) throws Exception {
        Field f;
        switch (c) {
            case 'S':
                f = new StableIceField();
                break;
            case 'U':
                f = new UnstableIceField();
                break;
            case 'H':
                f = new Hole();
                break;
            default:
                throw new Exception("Hibás input fájl. Értelmezhetetlen mezőtípus.");
        }
        return f;
    }

    /**
     * Az argumentum alapján azonosítható Item osztály
     * egy leszármazott osztályából hoz létre példányt.
     * @param c A beolvasott adategység egyik karaktere,
     *          ami alapján meghatározható egy Item
     *          pontos leszármazott típusa.
     * @return  Az argumentumként meghatározott típusú.
     *          a metóduson belül példányosított Item.
     * @throws Exception Szemantikailag vagy szintaktikailag
     *                   hibás a pályát tartalmazó fájl.
     */
    private Item parseItem(char c) throws Exception {
        Item i;
        switch (c) {
            case 'd':
                i = new DivingSuit();
                break;
            case 'f':
                i = new Food();
                break;
            case 'r':
                i = new Rope();
                break;
            case 's':
                i = new Shovel();
                break;
            case 'g':
                i = new FragileShovel();
                break;
            case 'p':
                i = new Pistol();
                break;
            case 'c':
                i = new Cartridge();
                break;
            case 'e':
                i = new Flare();
                break;
            case 't':
                i = new Tent();
                break;
            case '0':
                i = null;
                break;
            default:
                throw new Exception("Hibás input fájl. Értelmezhetetlen item.");
        }
        return i;
    }

    /**
     * eltávolítjuk a korábban kiválasztott játékosokat
     */
    private int parsedPlayerID = 0;
    private Player removePlayer(Player p) {
        if (playerCountLimited) {
            if (removes[parsedPlayerID])
                p = null;
            parsedPlayerID++;
        }
        return p;
    }

    /**
     * Az argumentum alapján azonosítható Entity osztály
     * egy leszármazott osztályából hoz létre példányt.
     * @param c A beolvasott adategység egyik karaktere,
     *          ami alapján meghatározható egy Entity
     *          pontos leszármazott típusa.
     * @return  Az argumentumként meghatározott típusú.
     *          a metóduson belül példányosított Item.
     * @throws Exception Szemantikailag vagy szintaktikailag
     *                   hibás a pályát tartalmazó fájl.
     */
    private Entity parseEntity(char c) throws Exception {
        Entity e;
        Player p;
        switch (c) {
            case 'E':
                p = removePlayer(new Eskimo());
                if (p == null) return null;
                players.add(p);
                e = p;
                break;
            case 'K':
                p = removePlayer(new ArcticExplorer());
                if (p == null) return null;
                players.add(p);
                e = p;
                break;
            case 'M':
                e = new Bear();
                break;
            case '0':
                e = null;
                break;
            default:
                throw new Exception("Hibás input fájl. Értelmezhetetlen entitás.");
        }
        return e;
    }

    /**
     * Beállítja a játékosok számát a pályához tartozó értékkel.
     * @param numberOfPlayers a pályához tartozó értékkel.
     */
    public void LimitPlayerCount(int numberOfPlayers) {
        playerCountLimited = true;
        playerCountLimit = numberOfPlayers;
    }
}
