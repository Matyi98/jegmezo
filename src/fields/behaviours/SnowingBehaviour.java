package fields.behaviours;

import entities.Player;

import java.util.List;

public abstract class SnowingBehaviour {
    protected int snowDamageValue;

    protected SnowingBehaviour(int snowDamageValue){
        this.snowDamageValue = snowDamageValue;
    }

    //Havazás elvégzése a játékosokon
    public abstract void performSnow(List<Player> players);
}
