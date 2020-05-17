package views.scenes.mainWindow;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import game.GameController;
import views.BoardView;
import views.IUpdatable;
import views.InfoPanelView;

import java.io.File;
import java.util.ArrayList;

public class GameScene extends Scene {
    private static final double WIDTH = 1280;
    private static final double HEIGHT = 720;

    private Pane root = new Pane();

    private static ArrayList<IUpdatable> views = new ArrayList<>();

    public GameScene(File file) {
        super(new StackPane(), WIDTH, HEIGHT);
        BoardView boardView = new BoardView(GameController.GetInstance().GetBoard(), file);
        InfoPanelView infoPanelView = new InfoPanelView();

        setBackground();

        initBoardView(boardView);
        initInfoPanelView(infoPanelView);

        views.clear();
        views.add(boardView);
        views.add(infoPanelView);

        setOnKeyTyped(new GameKeyEvents());

        setRoot(root);
    }

    private void setBackground(){
        root.setStyle("-fx-background-color: rgb(40, 40, 60)");
    }

    private void initBoardView(BoardView boardView){
        boardView.setLayoutX(10);
        boardView.setLayoutY(10);
        boardView.setPrefSize(HEIGHT-20+100, HEIGHT-20);

        root.getChildren().add(boardView);
    }

    private void initInfoPanelView(InfoPanelView infoPanelView){
        infoPanelView.setLayoutX(HEIGHT+100);
        infoPanelView.setLayoutY(10);
        infoPanelView.setPrefSize(WIDTH - 10 - HEIGHT-100,HEIGHT-20);

        root.getChildren().add(infoPanelView);
    }

    public static void UpdateAllViews(){
        for(IUpdatable view: views){
            view.Update();
        }
    }


}
