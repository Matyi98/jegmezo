package views.scenes.mainWindow;

import javafx.event.EventHandler;
import scene.GameController;

import javafx.scene.input.KeyEvent;



public class GameKeyEvents implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCharacter().toUpperCase()) {
            case "D":
                GameController.GetInstance().Execute("p turn D");
                break;
            case "A":
                GameController.GetInstance().Execute("p turn A");
                break;
        }
    }


}
