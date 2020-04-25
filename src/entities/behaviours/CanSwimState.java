package entities.behaviours;

public class CanSwimState extends PlayerState{
    @Override
    public void drown(){
        player.setState(new SwimmingState());
    }

    @Override
    public void swapDivingSuit(){
        player.setState(new NormalState());
    }
}
