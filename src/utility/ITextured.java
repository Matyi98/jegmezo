package utility;

/**
 * Minden olyan modell beli elem interfésze,
 * aminek kell legyen grafikus megjelenítése.
 */
public interface ITextured {
    /**
     * Elérési út az elemet ábrázoló képhez.
     * @return elérési út.
     */
    String GetTexturePath();
}
