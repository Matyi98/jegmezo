package scene;

import entities.*;

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

    public void ShowMap() {
        board.Show();
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

    private int currentPlayer = 0;
    private void nextPlayer() {
        currentPlayer++;
        if (currentPlayer >= players.size())
            currentPlayer = 0;
    }

    public void Start(Scanner stdin) {
        while (stdin.hasNextLine()) {
            String next = stdin.nextLine();
            interpretUserInput(next);
        }
    }

    private void interpretUserInput(String userInput) {
        String type = userInput.split(" ")[0].toLowerCase();
        switch (type) {
            case "p":
                boolean hasMorePoints = players.get(currentPlayer).Action(userInput.toLowerCase());
                if (!hasMorePoints)
                    nextPlayer();
                break;
            case "s":
                String data = userInput.split(" ")[1].toLowerCase();
                switch (data) {
                    case "map":
                        this.ShowMap();
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
    }

    public void win(int count) {
        OutStream.println("[ " + new Object() {
        }.getClass().getEnclosingMethod() + " ]");
        if (count == players.size() && questItemCount == 3)
            OutStream.println("WIN");
        else
            OutStream.println("not WIN");
    }

    public void gameOver() {
        OutStream.println("[ " + new Object() {
        }.getClass().getEnclosingMethod() + " ]");
        OutStream.println("Lose");
    }

    public void questItemFound() {
        OutStream.println("[ " + new Object() {
        }.getClass().getEnclosingMethod() + " ]");
        questItemCount = questItemCount + 1;
    }
}
