package fields;

import enums.Direction;
import player.Player;

public abstract class IceField extends Field {
    @Override
    public boolean buildIgloo() {
        return false;
    }
}
