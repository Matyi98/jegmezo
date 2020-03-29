package items;

import player.Player;

public abstract class QuestItem extends Item{
    public void use(){

    }

    public boolean setOwner(Player owner){
        this.owner = owner;

        return true;
    }

}
