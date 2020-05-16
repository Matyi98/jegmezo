package views.scenes.mainWindow;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import game.GameController;
import reader.LayoutReader;
import views.BoardView;
import views.InfoPanelView;

import java.io.File;

public class GameScene extends Scene {
    private static final double WIDTH = 1280;
    private static final double HEIGHT = 720;

    private Pane root = new Pane();
    private static BoardView boardView;
    private static InfoPanelView infoPanelView = new InfoPanelView();

    private void initialize() {
        root.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.rgb(40, 40, 60),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )));
        root.getChildren().add(boardView);
        root.getChildren().add(infoPanelView);

        boardView.setLayoutX(10);
        boardView.setLayoutY(10);
        boardView.setPrefSize(HEIGHT-20+100, HEIGHT-20);

        infoPanelView.setLayoutX(HEIGHT+100);
        infoPanelView.setLayoutY(10);
        infoPanelView.setPrefSize(WIDTH - 10 - HEIGHT-100,HEIGHT-20);

        setOnKeyTyped(new GameKeyEvents());
    }


    public GameScene(File file) {
        super(new StackPane(), WIDTH, HEIGHT);
        boardView = new BoardView(GameController.GetInstance().GetBoard(), file);
        initialize();
        setRoot(root);
    }

    public static void UpdateAllViews(){
        boardView.Update();
        infoPanelView.Update();
    }


}
