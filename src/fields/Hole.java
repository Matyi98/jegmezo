package fields;

import enums.Direction;
import player.Player;

public class Hole extends Field {
    @Override
    public boolean acceptPlayer(Player player) {
        return false;
    }

    @Override
    public boolean buildIgloo() {
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
