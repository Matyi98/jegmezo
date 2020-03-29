package fields;

import enums.Direction;
import player.Player;

public class OceanField extends Field {

    @Override
    public boolean acceptPlayer(Player player) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        return false;
    }

    @Override
    public boolean buildIgloo(){
        return false;
    }

    @Override
    public String checkStability() {
        return null;
    }

    @Override
    public String checkStability(Direction direction) {
        return null;
    }

}
