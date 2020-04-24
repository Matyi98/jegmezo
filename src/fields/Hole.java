package fields;

import entities.Entity;
import entities.Player;
import items.Item;
import scene.writer.SceneWriter;

public class Hole extends Field {

    /**
     * Inicializálja a mező kezdőállapotát.
     * @param w A mező által elbírt entitások száma.    Ignorált, hiszen ez egy luk.
     * @param s A mezőn lévő hószintek kezdeti értéke.
     * @param i A mezőn lévő item.
     * @param e A mezőn lévő entitás.                   Ignorált, hiszen lukon nem kezdhet entitás.
     */
    public void Setup(int w, int s, Item i, Entity e) {
        snowLevel = s;
        item = i;
    }

    /**
     * Megjeleníti a Fieldet a SceneWirterben meghatározott folyamon.
     */
    public void Show() {
        SceneWriter.OutStream.print('F');
        SceneWriter.OutStream.print('0');
        SceneWriter.OutStream.print(snowLevel);
        item.ShowShort();
    }

    @Override
    public boolean acceptPlayer(Player player) {
        System.out.println("[ " + new Object(){}.getClass().getEnclosingMethod() + " ]");
        System.out.println("Sikertelen a jatekos befogadasa.");
        players.add(player);
        return true;
    }

    @Override
    public boolean buildIgloo() {
        return false;
    }

    @Override
    public String checkStability() {
        //Megadja a mező stabilitását.
        return "Hole";
    }


}
