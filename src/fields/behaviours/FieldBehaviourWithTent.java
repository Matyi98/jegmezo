package fields.behaviours;

import entities.Entity;
import fields.Field;
import game.GameController;

import java.util.Collection;

/**
 * A Fieldnek az tenttel rendelkező állapotának viselkedését implementáló osztály.
 */
public class FieldBehaviourWithTent extends FieldBehaviour{

    /**
     * Konstruktor
     * @param f referencia arra a Fieldre, amely ezt a FieldBehaviourt tartalmazza.
     */
    public FieldBehaviourWithTent(Field f) {
        super(f);
        GameController.OutStream.println("Successful TentBuild");
    }

    /**
     * Mivel a FieldBehaviourWithTent olyan állapotot reprezentál, amely
     * megvédi a havazástól a FieldBehaviourWithTentet tulajdonoló Fielden
     * álló Entityket, ezér nem hajt vére a paraméterként átvett Entityken
     * sebzést.
     * @param entities A FieldBehaviourWithIgloot tulajdonoló Fielden
     *                 álló Entityk.
     */
    @Override
    public void performSnow(Collection<Entity> entities) {

    }

    /**
     * Mivel a FieldBehaviourWithTentet tulajdonoló Field FieldBehaviour attribútuma már
     * FieldBehaviourWithTent, amire váltást a metódus szolgálna, nem kell azt átváltania.
     * @return False értékkel tér vissza mindig.
     */
    @Override
    public boolean buildTent() {
        return false;
    }

    /**
     * Átváltja a FieldBehaviourWithTentet tulajdonoló Field, FieldBehaviour attribútumát
     * StandardFieldBehaviourre, ezzel azt szimulálva, mintha lerombolódna Fieldről a tent.
     */
    @Override
    public void destroyTent(){
        field.setBehaviour(new StandardFieldBehaviour(field));
    }

    /**
     * Átváltja a Field, FieldBehaviour attribútumát FieldBehaviourWithIgloora,
     * ezzel iglooval rendelkező viselkedést injektálva a Fieldbe.
     * @return Amennyiben átváltotta a StandardFieldBehaviour tulajdonoló Field
     * FieldBehaviour attribútumát úgy true, ellenező esetben false értékkel tér vissza.
     */
    @Override
    public boolean buildIgloo() {
        field.setBehaviour(new FieldBehaviourWithIgloo(field));
        return true;
    }

    /**
     * Összeütközteti a FieldBehaviourt túlajdonoló Field Entityjeit a Fieldre lépő Entityvel.
     * @param enteringEntity A FieldBehaviourWithTent túlajdonoló Fieldre lépő Entity.
     * @param standingEntities A FieldBehaviourWithTent túlajdonoló Fielden lévő Entityk.
     */
    @Override
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {
        for(Entity e : standingEntities){
            enteringEntity.collideWith(e);
        }
    }

    /**
     * Kiírja az állapotot röviden.
     */
    @Override
    public void ShowShort() {
        GameController.OutStream.print("t");
    }

    @Override
    public String GetStateTexturePath() {
        return "textures/item_textures/tent.png";
    }
}
