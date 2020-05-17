package fields.behaviours;

import entities.Entity;
import fields.Field;
import utility.ITextured;

import java.util.Collection;

/**
 * A Fieldek különböző állapotának a Field attribútumként való megvalósítása.
 * Ezen osztály leszármazottai valósítják meg a Field különböző állapotainak
 * eltérő viselkedését az itt deklarált metódusok különböző implementációival.
 */
public abstract class FieldBehaviour implements ITextured {
    /**
     * Azon Fieldre referencia, amelyiknek a viselkedését reprezentálja.
     */
    protected Field field;

    /**
     * Konstruktor
     * @param f referencia arra a Fieldre, amely ezt a FieldBehaviourt tartalmazza.
     */
    public FieldBehaviour(Field f) {
        this.field = f;
    }

    /**
     * Az argumentumként átvett Entity-knek egy adott logika alapján csökkenti a hőpontjaik számát.
     * @param entities A Fielden lévő Entityk, amelyek HP-ját a Field csökkenteni akarja.
     */
    public abstract void performSnow(Collection<Entity> entities);

    /**
     * E metódus implementálásával tud a leszármazott osztály StandardFieldBehaviourből átváltani FieldBehaviourWithTentre.
     * Nem rendelkezik implementációval ebben az osztályban.
     * @return Sikeres váltás esetén trueval, máskülönben false értékkel tér vissza.
     */
    public abstract boolean buildTent();

    /**
     * Átváltja a Field, FieldBehaviour attribútumát FieldBehaviourWithIgloora.
     * @return Sikeres váltás esetén trueval, máskülönben false értékkel tér vissza.
     */
    public abstract boolean buildIgloo();

    /**
     * E metódus implementálásával tud a leszármazott osztály FieldBehaviourWithTentből átváltani StandardFieldBehaviourre.
     * Nem rendelkezik implementációval ebben az osztályban.
     */
    public abstract void destroyTent();

    /**
     * E metódus implementálásával tudja a leszármazott osztály a FieldBehaviourt túlajdonoló Field Entityjeit
     * a Fieldre lépő Entityvel összeütköztetni. (FieldBehaviourWithIgloo állapotban üres az implementációja,
     * így nem tud a Player és a Bear ütközni.)
     * @param enteringEntity A StandardFieldBehaviour túlajdonoló Fieldre lépő Entity.
     * @param standingEntities A StandardFieldBehaviour túlajdonoló Fielden lévő Entityk.
     */
    public abstract void collideEntities(Entity enteringEntity, Collection<Entity> standingEntities);

    /**
     * Kiírja az állapotot röviden.
     */
    public abstract void ShowShort();
}
