package items.quest;

import items.Item;
import entities.Player;
import scene.GameController;

/**
 * QuestItem-ek ősosztálya. A játék megnyeréséhez szükséges.
 */
public abstract class QuestItem extends Item {

    /**
     * Adott QuestItem használata.
     */
    @Override
    public void use(){
        GameController.OutStream.println("Quest item used");
        this.owner.useFlareGun();
    }

    /**
     * QuestItem tulajdonosának beállítása, valamint jelez, hogy QuestItem-et találtak a játékosok.
     * @param owner tulajdonos.
     * @return true, mert QuestItem-et találtak.
     */
    @Override
    public boolean setOwner(Player owner){
        showPickup();
        this.owner = owner;
        //Jelez, hogy QuestItemet találtak.
        this.owner.questItemFound();
        return true;
    }

}
