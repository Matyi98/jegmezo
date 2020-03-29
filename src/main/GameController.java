package main;

import fields.Board;
import player.ArcticExplorer;
import player.Player;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private int questItemCount = 0;
    private List<Player> players;
    private Board board;

    GameController(){

    }

    GameController(Player testPlayer) {
        board = new Board();
        players = new ArrayList<>();
        players.add(testPlayer);
    }

    public void start(char userInput)
    {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");

        switch (userInput) {
            case 'p':
                players.get(0).specialPower();
                break;
            default:
                break;
        }

    }

    public void win(){

    }

    public void gameOver()
    {
        
    }

}
