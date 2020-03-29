package items;

import player.Player;

public abstract class QuestItem extends Item{

    public void use(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        this.owner.useFlareGun();
    }

    @Override
    public boolean setOwner(Player owner){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        this.owner = owner;
        this.owner.questItemFound();
        return true;
    }

}
