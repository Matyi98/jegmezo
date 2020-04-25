package scene;

import entities.*;

import java.util.ArrayList;

public class GameController {
    private int questItemCount = 0;
    private ArrayList<Player> players;
    private Board board;

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

    public void start() {
        while (true) {
            


        }
    }

    private void interpretUserInput(String userInput, int currentPlayer) {
        String type = userInput.split(" ")[0].toLowerCase();
        switch (type) {
            case "p":
                String action = userInput.split(" ")[1].toLowerCase();
                switch (action) {
                    case "turn":
                        String parameter = userInput.split(" ")[2].toLowerCase();
                        switch (parameter) {
                            case "a":
                                players.get(currentPlayer).turn(-1);
                                break;
                            case "b":
                                players.get(currentPlayer).turn(1);
                                break;
                            default:
                                System.out.println("bad parameter.");
                        }
                        break;
                    case "move":
                        players.get(currentPlayer).move();
                        break;
                    case "use":
                        int itemIndex = Integer.parseInt(userInput.split(" ")[2]);
                        players.get(currentPlayer).useItem(itemIndex);
                        break;
                    case "special":
                        players.get(currentPlayer).specialPower();
                        break;
                    case "skip":
                        // TODO players.get(currentPlayer).skip();
                        break;
                    case "shovel":
                        players.get(currentPlayer).shovel(1);
                        break;
                    case "pickup":
                        players.get(currentPlayer).pickUpItem();
                        break;
                    default:
                        System.out.println("bad action");
                }
                break;
            case "s":
                String data = userInput.split(" ")[1].toLowerCase();
                switch (data) {
                    case "map":
                        // TODO pálya kirajzolása
                        break;
                    case "stats":
                        players.get(currentPlayer).showStats();
                        break;
                    case "inv":
                        players.get(currentPlayer).getInventory().show();
                        break;
                    default:
                        System.out.println("bad command.");
                }
                break;
            default:
                System.out.println("bad command.");
                break;
        }
    }

    public void win(int count) {
        System.out.println("[ " + new Object() {
        }.getClass().getEnclosingMethod() + " ]");
        if (count == players.size() && questItemCount == 3)
            System.out.println("WIN");
        else
            System.out.println("not WIN");
    }

    public void gameOver() {
        System.out.println("[ " + new Object() {
        }.getClass().getEnclosingMethod() + " ]");
        System.out.println("Lose");
    }

    public void questItemFound() {
        System.out.println("[ " + new Object() {
        }.getClass().getEnclosingMethod() + " ]");
        questItemCount = questItemCount + 1;
    }
}
