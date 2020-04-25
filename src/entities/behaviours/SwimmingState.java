package entities.behaviours;

public class SwimmingState extends PlayerState{
    @Override
    public void walk(){
        player.setState(new CanSwimState());
    }
}
