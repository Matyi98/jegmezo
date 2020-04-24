package scene;

import scene.Board;
import entities.*;

import java.util.ArrayList;

public class GameController {
    private int questItemCount = 0;
    private ArrayList<Player> players;
    private Board board;

    public GameController() {
    }

    public void SetBoard(Board board) {
        this.board = board;
    }

    public void AddPlayer( Player player ) {
        players.add(player);
    }

    public void start(char userInput)
    {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        switch (userInput) {
            case 'p':
                players.get(0).specialPower();
                break;
            case 'c':
                players.get(0).shovel(1);
                break;
            case 'w':
                players.get(0).move();
                break;
            default:
                break;
        }

    }

    public void win(int count){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        if(count == players.size() && questItemCount == 3)
            System.out.println("WIN");
        else
            System.out.println("not WIN");
    }

    public void gameOver()
    {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Lose");
    }

    public void questItemFound() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        questItemCount = questItemCount + 1;
    }
}
