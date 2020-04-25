package fields;

import entities.Entity;

import entities.Player;
import items.Item;
import scene.writer.SceneWriter;

public class UnstableIceField extends IceField{
    private int stability;

    @Override
    public void Show() {
        SceneWriter.OutStream.print('U');
        SceneWriter.OutStream.print('0');
        SceneWriter.OutStream.print(snowLevel);

        if (item != null)
            item.ShowShort();
        else
            SceneWriter.OutStream.print('0');

        for (Entity e : entities)
            e.ShowShort();

        this.ShowState();
    }

    //Iglu építése.
    @Override
    public boolean buildIgloo(){
        //Instabil mezőre ne lehet építeni Iglut.
        return false;
    }

    @Override
    public boolean buildTent() {
        return false;
    }

    //Jáékos befogadása a mezőre.
    @Override
    public boolean acceptEntity(Entity entity) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikeres a jatekos befogadasa");
        entities.add(entity);
        return true;
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        stability = 3;
        System.out.println("sikeres stabilitás vizsgálat: unstableIceField: "+stability);
        //A stabilitását adja vissza.
        return String.valueOf(stability);
    }

    //Játékos átadása a aszomszd mezőnek, a megadott irányba.
    @Override
    public boolean placeEntityToNextField(int direction, Entity entity){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        //Szomszéd mező lekérése.
        Field neighbour = neighbors.get(direction);
        //Átadás a szomszédnak.
        neighbour.acceptEntity(entity);
        return false;
    }

}
