package fields;

import enums.Direction;
import player.Player;

public abstract class IceField extends Field {
    public IceField(){
        super();
    }

    //Iglu építése
    @Override
    public boolean buildIgloo() {
        return false;
    }
}
