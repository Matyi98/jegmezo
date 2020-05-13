package views;

import scene.Board;

public class BoardView extends ViewBase {
    private Board data;
    public BoardView(Board b) {
        super(b.GetTexturePath());
        this.data = b;
   }

    @Override
    public void Update() {
        //TODO: Implement this.
    }
}
