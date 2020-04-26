package fields.behaviours;

import entities.Entity;
import fields.Field;
import scene.GameController;

import java.util.Collection;

/**
 * A Fieldnek az igluval rendelkező állapotának viselkedését implementáló osztály.
 */
public class FieldBehaviourWithIgloo extends FieldBehaviour {

    public FieldBehaviourWithIgloo(Field f) {
        super(f);
        GameController.OutStream.println("Successful IglooBuild");
    }

    /**
     * Mivel a FieldBehaviourWithIgloo olyan állapotot reprezentál, amely
     * megvédi a havazástól a FieldBehaviourWithIgloot tulajdonoló Fielden
     * álló Entityket, ezér nem hajt vére a paraméterként átvett Entityken
     * sebzést.
     * @param entities A FieldBehaviourWithIgloot tulajdonoló Fielden
     *                 álló Entityk.
     */
    @Override
    public void performSnow(Collection<Entity> entities) {

    }

    /**
     * Mivel a FieldBehaviourWithIgloo olyan állapotot reprezentál, amely
     * megvédi a havazástól a FieldBehaviourWithIgloot tulajdonoló Fielden
     * álló Entityket, továbbá az igloo maradandóbb alkotás mint a tent,
     * ezért nem épít tentet, amit a FieldBehaviourWithIgloot tulajdonoló Field
     * FieldBehaviour attribútumának átállításával érne el.
     * @return Amennyiben átváltotta a StandardFieldBehaviour tulajdonoló Field
     * FieldBehaviour attribútumát úgy true, ellenező esetben false értékkel tér vissza.
     */
    @Override
    public boolean buildTent() {
        return false;
    }

    /**
     * Mivel a FieldBehaviourWithIgloot tulajdonoló Field FieldBehaviour attribútuma már
     * FieldBehaviourWithIgloo, amire váltást a metódus szolgálna, nem kell azt átváltania.
     * @return False értékkel tér vissza mindig.
     */
    @Override
    public boolean buildIgloo() {
        return false;
    }

    /**
     * Mivel a FieldBehaviourWithIgloot tulajdonoló Field FieldBehaviour attribútuma nem
     * FieldBehaviourWithTent, amiről váltást a metódus szolgálna, nem kell azt átváltania.
     */
    @Override
    public void destroyTent() {

    }

    /**
     * Nem ütközteti össze a FieldBehaviourWithIgloot túlajdonoló Field Entityjeit a Fieldre lépő Entityvel
     * Ezzel azt elérve, hogy a medve nem tudja megtámadni az embereket, ugyanis FieldBehaviourWithIgloo
     * olyan állapotát valósítja meg az őt tulajdonoló Fildjének, amelyben megvédi az embereket a medvétől.
     * @param enteringEntity A FieldBehaviourt túlajdonoló Fieldenre lépő Entity.
     * @param standingEntities A FieldBehaviourt túlajdonoló Fielden lévő Entityk.
     */
    @Override
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {

    }

    /**
     * Kiírja az állapotot röviden.
     */
    @Override
    public void ShowShort() {
        GameController.OutStream.print("i");
    }
}
