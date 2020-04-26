package scene;

import entities.*;
import main.RandomNumber;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    private int questItemCount = 0;
    private ArrayList<Player> players;
    private Board board;

    static public PrintStream OutStream = System.out;

    public GameController() {
    }

    public void ShowMap(boolean showEdges) {
        board.Show(showEdges);
    }

    /**
     * Beállítja a kezdőállapotot.
     * @param board   A pálya.
     * @param players A játékosok listája.
     */
    public void Setup(Board board, ArrayList<Player> players) {
        this.board = board;
        this.players = players;
    }

    private int currentPlayer = -1;
    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer >= players.size()) {
            currentPlayer = 0;
            board.letItSnow(new RandomNumber());
        }
        OutStream.println(players.get(currentPlayer).getName()+"'s turn");
    }

    /**
     * A játék fő ciklusa itt található, amely minden egyes iterációval
     * az argumentumként átvett bemeneti adatfolyamból kiemeli a következő
     * parancsot, amit továbbít értelmezésre az interpretUserInput
     * segédmetódusának, amely ha false értékkel tér vissza jelezvén, hogy
     * játék vége parancsot talált, akkor kilépésre készteti a metódust
     * a fő játékciklusból.
     * @param stdin
     */
    public void Start(Scanner stdin) {
        nextPlayer();
        while (stdin.hasNextLine()) {
            String next = stdin.nextLine();
            if (!interpretUserInput(next)) {
                return;
            }
        }
    }

    /**
     * Egy-egy argumentumként átvett a játékba beérkező parancsot értelmez.
     * A feldolgozandó parancs alapján meghívhatja az aktuális játékos
     * Action nevű metódusát vagy false visszatérési értékkel jelzi, hogy
     * a programot termináló parancsot talált vagy beállítja, hogy a
     * véletlen szerű történések véletlen alapján történjenek-e vagy sem.
     * Ezeken kívül még különböző a játék állapotával kapcsolatos különböző
     * kiiratásokat kezelő metódusokat is meghívhat szintén a kapott parancs
     * alapján.
     * @param userInput A játékba érkező string parancs vektor, amelyben
     *                  a fő parancs és annak paraméterei szóközzel vannak
     *                  elválasztva.
     * @return  Hamis értékkel tér vissza jelezve, ha a játékot termináló exit
     *          parancsot talált. Minden más esetben igaz értékkel tér vissza.
     */
    private boolean interpretUserInput(String userInput) {
        String type = userInput.split(" ")[0].toLowerCase();
        switch (type) {
            case "p":
                boolean hasMorePoints = players.get(currentPlayer).Action(userInput.toLowerCase());
                if (!hasMorePoints)
                    nextPlayer();
                break;
            case "tst":
                String command = userInput.split(" ")[1].toLowerCase();
                if (command.equals("exit"))
                    return false;
                if (command.equals("random")) {
                    RandomNumber.isRandomEnabled = !RandomNumber.isRandomEnabled;
                    OutStream.println("RNG: " + RandomNumber.isRandomEnabled);
                }
                break;
            case "s":
                String data = userInput.split(" ")[1].toLowerCase();
                switch (data) {
                    case "map":
                        this.ShowMap(false);
                        break;
                    case "stats":
                        players.get(currentPlayer).ShowStats();
                        break;
                    case "inv":
                        players.get(currentPlayer).ShowInventory();
                        break;
                    default:
                        OutStream.println("bad command.");
                }
                break;
            default:
                OutStream.println("bad command.");
                break;
        }
        return true;
    }

    public void win(int count) {
        if (count == players.size() && questItemCount == 3)
            OutStream.println("Victory");
        else
            OutStream.println("Win conditions not met");
    }

    public void gameOver() {
        OutStream.println("Game Over");
    }

    public void questItemFound() {
        questItemCount = questItemCount + 1;
    }
}
