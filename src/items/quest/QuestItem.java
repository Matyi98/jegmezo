package items.quest;

import items.Item;
import entities.Player;
import scene.writer.SceneWriter;

//QuestItemeket reprezentáló osztály.
public abstract class QuestItem extends Item {

    //QuestItem használata.
    @Override
    public void use(){
        SceneWriter.OutStream.println("Quest item used");
        this.owner.useFlareGun();
    }

    @Override
    //Beállítja a tulajdonost, és jelez, hogy QuestItemet találtak.
    public boolean setOwner(Player owner){
        showPickup();
        this.owner = owner;
        //Jelez, hogy QuestItemet találtak.
        this.owner.questItemFound();
        return true;
    }

}
