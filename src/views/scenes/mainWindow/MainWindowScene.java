package views.scenes.mainWindow;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import scene.GameController;
import views.BoardView;
import views.InfoPanelView;


public class MainWindowScene extends Scene {
    private static final double WIDTH = 1280;
    private static final double HEIGHT = 720;

    private Pane root = new Pane();
    private BoardView boardView = new BoardView(GameController.GetInstance().GetBoard());
    private InfoPanelView infoPanelView = new InfoPanelView();

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

        root.setOnKeyTyped(new MainWindowKeyEvents());
    }


    public MainWindowScene() {
        super(new StackPane(), WIDTH, HEIGHT);
        initialize();
        setRoot(root);
    }


}
