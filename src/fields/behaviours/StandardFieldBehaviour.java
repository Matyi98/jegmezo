package fields.behaviours;

import entities.Entity;
import fields.Field;

import java.util.Collection;

/**
 * A Fieldnek a sátorral rendelkező állapotának viselkedését implementáló osztály.
 */
public class StandardFieldBehaviour extends FieldBehaviour {
    public StandardFieldBehaviour(Field f) {
        super(f);
    }

    /**
     * Az argumentumként átvett Entityk HP-ját csökkenti.
     * @param entities A Fielden lévő Entityk, amelyek HP-ját
     *                 a Field csökkenteni akarja.
     */
    @Override
    public void performSnow(Collection<Entity> entities) {
        for(Entity e: entities){
            e.decrementHP();
        }
        field.changeSnowLevel(2);
    }

    /**
     * Átváltja a Field, FieldBehaviour attribútumát FieldBehaviourWithTentre,
     * ezzel sátorral rendelkező viselkedést injektálva a Fieldbe.
     * Sikeres váltás esetén trueval, máskülönben false értékkel tér vissza.
     * @return Amennyiben átváltotta a StandardFieldBehaviour tulajdonoló Field
     * FieldBehaviour attribútumát úgy true, ellenező esetben false értékkel tér vissza.
     */
    @Override
    public boolean buildTent() {
        if(field.getSnowLevel() == 0){
            field.setBehaviour(new FieldBehaviourWithTent(field));
            return true;
        } else
            return false;
    }

    /**
     * Átváltja a Field, FieldBehaviour attribútumát FieldBehaviourWithIgloora,
     * ezzel iglooval rendelkező viselkedést injektálva a Fieldbe.
     * @return Amennyiben átváltotta a StandardFieldBehaviour tulajdonoló Field
     * FieldBehaviour attribútumát úgy true, ellenező esetben false értékkel tér vissza.
     */
    @Override
    public boolean buildIgloo() {
        if(field.getSnowLevel() == 0){
            field.setBehaviour(new FieldBehaviourWithIgloo(field));
            return true;
        } else
            return false;
    }

    /**
     * Mivel a StandardFieldBehaviour nem sátorral rendelkező álapotot reprezentál, így
     * nincs mit csinálnia a metódusnak, ezt üres implmentűációval éri el.
     */
    @Override
    public void destroyTent() {

    }

    /**
     * Összeütközteti a FieldBehaviourt túlajdonoló Field Entityjeit a Fieldre lépő Entityvel.
     * @param enteringEntity A StandardFieldBehaviour túlajdonoló Fieldre lépő Entity.
     * @param standingEntities A StandardFieldBehaviour túlajdonoló Fielden lévő Entityk.
     */
    @Override
    public void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities) {
        for(Entity e : standingEntities){
            enteringEntity.collideWith(e);
        }
    }

    /**
     * Kiírja az állapotot röviden. Ennek az állapotnak nincs rövid jele.
     */
    @Override
    public void ShowShort() {

    }
}
