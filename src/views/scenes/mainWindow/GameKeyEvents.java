package views.scenes.mainWindow;

import javafx.event.EventHandler;
import game.GameController;

import javafx.scene.input.KeyEvent;



public class GameKeyEvents implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        String input = keyEvent.getCharacter().toUpperCase();

        if(isItemIndex(input) != -1) {
            GameController.GetInstance().Execute("p use " + isItemIndex(input));
            System.out.println("p use " + isItemIndex(input));
        }

        switch (input) {
            case "D":
                GameController.GetInstance().Execute("p turn D");
                break;
            case "A":
                GameController.GetInstance().Execute("p turn A");
                break;
            case "W":
                GameController.GetInstance().Execute("p move");
                break;
            case "E": // End turn (skip)
                GameController.GetInstance().Execute("p skip");
                break;
            case "Q":
                GameController.GetInstance().Execute("p special");
                break;
            case "S":
                GameController.GetInstance().Execute("p shovel");
                break;
            case "P":
                GameController.GetInstance().Execute("p pickup");
                break;
        }
    }

    /**
     * Eldönti egy kapott szövegről hogy az egy megfelelő item index,
     * vagyis egy 1 és 6 között lévő egész szám.
     * @param str a kapott szöveg
     * @return ha megfelelő item index akkor maga az index, egyébként pedig -1
     */
    private int isItemIndex(String str) {
        try {
            int itemIndex = Integer.parseInt(str);
            if (itemIndex >= 1 && itemIndex <= 6)
                return itemIndex;
            else
                return -1;
        } catch(NumberFormatException e){
            return -1;
        }
    }
}
