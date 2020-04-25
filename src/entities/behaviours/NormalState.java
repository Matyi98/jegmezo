package entities.behaviours;

public class NormalState extends PlayerState {
    @Override
    public void swapDivingSuit(){
        player.setState(new CanSwimState());
    }

    @Override
    public void drown(){
        player.setState(new DrowningState());
    }
}
