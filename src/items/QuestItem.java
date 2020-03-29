package items;

import player.Player;

public abstract class QuestItem extends Item{
    public void use(){

    }

    @Override
    public boolean setOwner(Player owner){
        this.owner = owner;
        this.owner.questItemFound();
        return true;
    }

}
