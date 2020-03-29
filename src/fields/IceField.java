package fields;

import enums.Direction;
import player.Player;

public abstract class IceField extends Field {
    public IceField(){
    }

    public IceField(Field aboveNeighbor){
        super(aboveNeighbor);
    }

    @Override
    public boolean buildIgloo() {
        return false;
    }
}
