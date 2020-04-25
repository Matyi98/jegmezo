package fields;

import entities.Entity;
import items.Item;
import entities.Player;
import scene.writer.SceneWriter;

public class StableIceField extends IceField{

    @Override
    public void Show() {
        SceneWriter.OutStream.print('S');
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

    //Mezőn tárolt tárgy beállíítása.
    public void setItem(Item item){
        this.item = item;
    }

    //Játékos befogadása a mezőre.
    @Override
    public boolean acceptEntity(Entity entity) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikeres a jatekos befogadasa");
        //Felvétel a belső Player listára.
        entities.add(entity);
        return true;
    }

    //Megadja a mező saját stabilitását.
    @Override
    public String checkStability() {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("sikeres stabilitás vizsgálat: stableIceField. ");
        return "Stable";
    }

    //Iglu építése a mezőn.
    @Override
    public boolean buildIgloo(){
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikeres iglu epites. ");
        return true;
    }

    @Override
    public boolean buildTent() {
        return false;
    }
}
