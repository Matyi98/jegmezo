package fields;

import entities.Entity;
import items.Item;
import scene.writer.SceneWriter;

import java.util.Optional;
import java.util.Scanner;

public class Hole extends Field {

    /**
     * Inicializálja a mező kezdőállapotát.
     * @param w A mező által elbírt entitások száma.    Ignorált, hiszen ez egy luk.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.                   Ignorált, hiszen lukon nem kezdhet entitás.
     */
    public final void Setup(int w, int s, Optional<Item> i, Optional<Entity> e) {
        snowLevel = s;
    }

    /**
     * Megjeleníti a Fieldet a SceneWirterben meghatározott folyamon.
     */
    public void Show() {
        SceneWriter.OutStream.print('F');
        SceneWriter.OutStream.print('0');
        SceneWriter.OutStream.print(snowLevel);
        SceneWriter.OutStream.print(0);

        if (entities.size() == 0)
            SceneWriter.OutStream.print('0');
        else
            for (Entity e : entities)
            e.ShowShort();
        this.ShowState();
    }

    @Override
    public boolean acceptEntity(Entity entity) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikertelen a jatekos befogadasa.");
        entities.add(entity);
        return true;
    }

    @Override
    public boolean buildIgloo() { return false; }

    @Override
    public boolean buildTent() {
        return false;
    }

    @Override
    public void destroyTent() {

    }

    @Override
    public void performSnow() {

    }

    @Override
    public void collideEntities(Entity enteringEntity) {

    }

    @Override
    public String checkStability() {
        //Megadja a mező stabilitását.
        return "Hole";
    }

    public Entity selectEntity() {

        System.out.println("Válassz alapján az alábbi megmenekítendő lények közül kit szeretnél kimenteni!");
        System.out.println("A kiválasztáshoz add meg a sorszámát majd üss entert!");

        for (int i = 0; i < entities.size(); i++)
            System.out.println(i + ".: " + entities.get(i).toString());

        Scanner s = new Scanner(System.in);

        int NO_INPUT = -1;
        int indexOfSelected = NO_INPUT;
        try {
            indexOfSelected = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e){ }

        if(indexOfSelected >= entities.size() || indexOfSelected < 0)
            return null;

        return entities.get(indexOfSelected);
    }

}
