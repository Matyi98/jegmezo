package views.scenes.mainWindow;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import game.GameController;
import views.BoardView;
import views.IUpdatable;
import views.InfoPanelView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Egy játékmenet ablakát reprezentáló osztály.
 */
public class GameScene extends Scene {
    /**
     * Abblak szélessége
     */
    private static final double WIDTH = 1280;
    /**
     * Ablak magassága
     */
    private static final double HEIGHT = 720;

    /**
     * Grafikus gyökér konténer.
     */
    private Pane root = new Pane();

    /**
     * Összes nézet listája.
     */
    private static ArrayList<IUpdatable> views = new ArrayList<>();

    /**
     * Konstrukto, létrehozza Játékjelenetet.
     * @param layoutFile A pálya kinézetét leíró nyelv.
     */
    public GameScene(InputStream layoutFile) {
        super(new StackPane(), WIDTH, HEIGHT);
        BoardView boardView = new BoardView(GameController.GetInstance().GetBoard(), layoutFile);
        InfoPanelView infoPanelView = new InfoPanelView();

        root.setStyle("-fx-background-color: rgb(40, 40, 60)");

        initBoardView(boardView);
        initInfoPanelView(infoPanelView);

        views.clear();
        views.add(boardView);
        views.add(infoPanelView);

        setOnKeyTyped(new GameKeyEvents());

        setRoot(root);
    }

    /**
     * BoardView inicializálása.
     * @param boardView BoardView példány.
     */
    private void initBoardView(BoardView boardView){
        boardView.setLayoutX(10);
        boardView.setLayoutY(10);
        boardView.setPrefSize(HEIGHT-20+100, HEIGHT-20);

        root.getChildren().add(boardView);
    }

    /**
     * InfoPanelView inicializálása
     * @param infoPanelView InfoPanelView példány.
     */
    private void initInfoPanelView(InfoPanelView infoPanelView){
        infoPanelView.setLayoutX(HEIGHT+100);
        infoPanelView.setLayoutY(10);
        infoPanelView.setPrefSize(WIDTH - 10 - HEIGHT-100,HEIGHT-20);

        root.getChildren().add(infoPanelView);
    }

    /**
     * Minden nézet frissítése.
     */
    public static void UpdateAllViews(){
        for(IUpdatable view: views){
            view.Update();
        }
    }


}
