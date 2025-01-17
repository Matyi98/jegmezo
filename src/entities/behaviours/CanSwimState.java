package entities.behaviours;

import entities.Player;
import game.GameController;
import javafx.scene.image.Image;
import utility.TurboTextureLoader;

/**
 * A játékosokat megvalósító Player osztály, szárazföldön és
 * divingsuitsban lévő állapotának viselkedését reprezentáló
 * implementációs osztály.
 */
public class CanSwimState extends PlayerState{

    /**
     * Konstruktor
     * @param player Referencia ezzel a PlayerStattel rendelkező játékosra
     */
    public CanSwimState(Player player) {
        super(player);
    }

    /**
     * A Playernek SwimmingState állapotot állít be a Player setState metódusának segítségével.
     * Így a Player CanSwimState állapotból SwimmingState állapotba kerülhet, amennyiben olyan esemény
     * következik be, amely a Playert DrowningState állapotba akarja hozni.
     */
    @Override
    public void makeDrown(){
        GameController.OutStream.println(player.getName() +" started swimming");
        player.setState(new SwimmingState(player));
    }

    /**
     * A  Playernek NormalState állapotot állít be a Player setState metódusának segítségével.
     * Így a Player CanSwimState állapotból NormalState állapotba kerülhet DivingSuit levétele esetén.
     */
    @Override
    public void swapDivingSuit() {
        player.setState(new NormalState(player));
        GameController.OutStream.println(player.getName() + " unequiped DivingSuit");
    }

    /**
     * Búvárruha megjelenítése az entityn.
     * @return plusz sztring az elérési útba
     */
    @Override
    public Image GetTexturePath(String option) {
        if (option.equals("eskimo"))
            return TurboTextureLoader.GetEntityTexture(TurboTextureLoader.EntityTextures.eskimo_scuba);
        else
            return TurboTextureLoader.GetEntityTexture(TurboTextureLoader.EntityTextures.explorer_scuba);
    }
}
