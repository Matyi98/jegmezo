package scene.reader;

import entities.*;
import fields.*;
import items.*;
import items.quest.*;
import scene.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class SceneReader {
    private Board board;
    private GameController gc;
    private ArrayList<Field> fields = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    private BufferedReader reader;
    public SceneReader(InputStream inputStream) {
        this.reader =
                new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * Fájlból beolvas adatokat, amelyek alapján inicializálja
     * a Boardot Fildekkel, Entitykkel és Itemekkel, valamint
     * inicializálja a GameControllert.
     * @return GameController objektummal, amely ütemezi,
     *         értelmezi, majd a parancsokhoz hozzárendelt
     *         metódusokat meghívja.
     */
    public GameController LoadScene() {
        board = new Board();
        gc = new GameController();
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
     * Fájlból beolvasott adatok alapján Field objektumokat hoz létre,
     * amelyeket eltárol az osztály fields gyűjteményében. Ezen kívül
     * beállítja a Fieldek közötti szomszédsági kapcsolatokat is.
     * @throws IOException A pálya leírást tartlamzó fájl beolvasása
     *                      közben technikai jellegű hiba adódott.
     */
    private void readAll() throws IOException {
        String sNodes = this.reader.readLine();
        String sEdges = this.reader.readLine();

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
     * Fildeket, Entityket és Itemeket hoz létre az argumentumként kapott
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
                p = new Eskimo();
                players.add(p);
                e = p;
                break;
            case 'K':
                p = new ArcticExplorer();
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
}
