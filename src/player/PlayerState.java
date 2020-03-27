package player;

public abstract class PlayerState {
    private Player player;

    public abstract void drown();
    public abstract void makePlayerWalk();
    public abstract void swapDivingSuit();
    public abstract void makePLayerDrowning();
}
