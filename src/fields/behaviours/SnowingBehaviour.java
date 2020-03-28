package fields.behaviours;

import player.Player;

import java.util.List;

public abstract class SnowingBehaviour {
    protected int snowDamageValue;

    protected SnowingBehaviour(int snowDamageValue){
        this.snowDamageValue = snowDamageValue;
    }

    public abstract void performSnow(List<Player> players);
}
