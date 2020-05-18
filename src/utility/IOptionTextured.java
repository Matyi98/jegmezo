package utility;

import javafx.scene.image.Image;

/**
 * Minden olyan modell beli elem interfésze,
 * aminek kell legyen grafikus megjelenítése.
 */
public interface IOptionTextured {
    /**
     * Elérési út az elemet ábrázoló képhez.
     * @return elérési út.
     */
    Image GetTexturePath(String option);
}
