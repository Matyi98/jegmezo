package game;

import entities.*;
import javafx.scene.control.Alert;
import main.Main;
import utility.RandomNumber;
import reader.SceneReader;
import utility.Dialog;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * GameController osztály, ami a játék lefolyását menedzseli.
 */
public class GameController {

    private static GameController instance;

    public static void Initialise(File mapPath, int numberOfPlayers) {
        try {
            SceneReader sceneReader = new SceneReader(new FileInputStream(mapPath));
            sceneReader.LimitPlayerCount(numberOfPlayers);
            instance = sceneReader.LoadScene();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static GameController GetInstance() {
        return instance;
    }

    public Player GetActivePlayer() { return players.get(currentPlayer); }

    /**
     * Player-ek által megtalált QuestItem-ek száma.
     */
    private int questItemCount = 0;

    /**
     * Player-ek listája.
     */
    private ArrayList<Player> players;


    public Board GetBoard() {
        return board;
    }

    /**
     * Játéktábla, amelyen a játék folyik.
     */
    private Board board;

    /**
     * Folyamatban van-e még a játék.
     */
    private boolean gameRunning = true;

    /**
     * Megjelenítéshez szükséges output stream.
     */
    static public PrintStream OutStream = System.out;
    /**
     * Soron lévő Player.
     */
    private static int currentPlayer = 0;

    /**
     * Reseteli a kezdő játékos indexét.
     */
    public static void resetAutoIncrement(){
        currentPlayer = 0;
    }

    /**
     * Tábla megjelenítése egy gráf formájában.
     * @param showEdges True - Field-ek megjelenítése (pontok)
     *                  False - Field-ek és hozzájuk tartozó szomszédok (élek) megjelenítése
     */
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

    /**
     * Jelenlegi Player körének befejezése és következő Player körének elindítása.
     */
    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer >= players.size()) {
            currentPlayer = 0;
            GameController.OutStream.println("End of round");
            board.letItSnow();
            board.stepEntities();
        }
        if (gameRunning) {
            players.get(currentPlayer).startTurn();
            OutStream.println(players.get(currentPlayer).getName() + "'s turn");
        }
        if(players.get(currentPlayer).isInHole())
            players.get(currentPlayer).makeDrown();

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
        currentPlayer = -1;
        nextPlayer();
        while (stdin.hasNextLine() && gameRunning) {
            String next = stdin.nextLine();
            if (!parseCommand(next)) {
                return;
            }
        }
    }

    /**
     * A grafikus felület ezen keresztül tud parancsokat adni a játéklogikának.
     * @param command szöveges parancs, megegyezik a program parancssoros változatában használt parancsokkal.
     */
    public void Execute(String command) {
        parseCommand(command);
        //TODO: Update Views here!!!!!
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
     * @param sCommand A játékba érkező string parancs vektor, amelyben
     *                  a fő parancs és annak paraméterei szóközzel vannak
     *                  elválasztva.
     * @return  Hamis értékkel tér vissza jelezve, ha a játékot termináló exit
     *          parancsot talált. Minden más esetben igaz értékkel tér vissza.
     */
    private boolean parseCommand(String sCommand) {
        try {
            String type = sCommand.split(" ")[0].toLowerCase();
            switch (type) {
                case "p":
                    boolean hasMorePoints = GetActivePlayer().Action(sCommand.toLowerCase());
                    if (!hasMorePoints)
                        nextPlayer();
                    break;
                case "tst":
                    String command = sCommand.split(" ")[1].toLowerCase();
                    if (command.equals("exit"))
                        return false;
                    if (command.equals("random")) {
                        RandomNumber.isRandomEnabled = !RandomNumber.isRandomEnabled;
                        OutStream.println("RNG: " + RandomNumber.isRandomEnabled);
                    }
                    break;
                case "s":
                    String data = sCommand.split(" ")[1].toLowerCase();
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
                            OutStream.println("Invalid command.");
                    }
                    break;
                default:
                    OutStream.println("Invalid command.");
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            OutStream.println("Invalid command");
        }
        return true;
    }

    /**
     * A játék megnyerése, ha a Player-ek eleget tettek a nyerési követelményeknek:
     * 1. Minden játékos legyen egyetlen egy mezőn.
     * 2. Legyen a játékosoknál az összes QuestItem.
     * @param count játékosok száma egy adott mezőn.
     */
    public void win(int count) {
        if (count == players.size() && questItemCount == 3) {
            OutStream.println("Victory");
            exit("Kongratulatione, you won!");
        }
        else
            OutStream.println("Win conditions not met");
    }

    /**
     * Vereség.
     */
    public void gameOver() {
        OutStream.println("Game Over");
        exit("You lost :(");
    }

    public void EXIT() {
        exit("Exit Button pressed.");
    }

    private void exit(String message) {
        if (gameRunning && Dialog.AllowGUI) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("GameOver");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
            Main.ExitToMenu();
        }
        gameRunning = false;
    }

    /**
     * QuestItem-et találtak a játékosok.
     */
    public void questItemFound() {
        questItemCount = questItemCount + 1;
    }
}
