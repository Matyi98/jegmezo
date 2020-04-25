package entities.behaviours;

public class DrowningState extends PlayerState{
    @Override
    public void drown(){
        player.die();
    }

    @Override
    public void walk(){
        player.setState(new NormalState());
    }
}
