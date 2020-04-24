package items.quest;

import items.Item;
import entities.Player;

//QuestItemeket reprezentáló osztály.
public abstract class QuestItem extends Item {

    //QuestItem használata.
    @Override
    public void use(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        this.owner.useFlareGun();
    }

    @Override
    //Beállítja a tulajdonost, és jelez, hogy QuestItemet találtak.
    public boolean setOwner(Player owner){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        this.owner = owner;

        //Jelez, hogy QuestItemet találtak.
        this.owner.questItemFound();
        return true;
    }

}
