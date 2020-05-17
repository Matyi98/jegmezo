package localization;

/**
 * Nyelvi támogatást biztosító osztály.
 */
public abstract class Language {

    /**
     * Kiválasztott nyelv.
     * @return Enum a kiválasztott nyelvről.
     */
    public static Languages GetSelected() {
        return sel;
    }

    /**
     * Lehetséges nyelvek.
     */
    public enum Languages {English, Magyar, Русский, Română }

    /**
     * Aktiálisan kiválasztott nyelvi csomag enum-ja.
     */
    private static Languages sel;

    /**
     * Aktuálisan kiválasztott nyelvi csomag osztálypéldánya.
     */
    private static Language lang = new Magyar();

    /**
     * Nyelv kiválasztása.
     * @param lang Választott nyelv.
     */
    static public void Select(Languages lang) {
        sel = lang;
        switch (lang) {
            case English:
                Language.lang = new English();
                break;
            case Magyar:
                Language.lang = new Magyar();
                break;
            case Русский:
                Language.lang = new Russian();
                break;
            case Română:
                Language.lang = new Romanian();
                break;
        }
    }

    /**
     * Visszaadja azt az osztálypéldányt,
     * amiből elérhetőek a kiválasztott nyelv mondatai.
     * @return Éppen kiválasztott nyelvi csomag osztálypéldánya.
     */
    static public Language Selected() {
        return lang;
    }

    /**
     * A hóvihar szövegát adja meg
     * @return a hóvihar szövege
     */
    public abstract String BlizzardShort();

    /**
     * A hóvihar szövegát adja meg, hosszabban
     * @return a hóvihar szövege, hosszabban
     */
    public abstract String BlizzardLong();

    /**
     * Az eszkimó nevekből adja meg a kiválasztottat
     * @param c a kivásztott eszkimó indexe
     * @return a kiválaszott név
     */
    public abstract String EskimoName(int c);

    /**
     * A sarkkutató nevekből adja meg a kiválasztottat
     * @param c a kivásztott sarkkutató indexe
     * @return a kiválaszott név
     */
    public abstract String ExplorerName(int c);

    /**
     * Üzenet arra az esetre ha a játékos meghal egy
     * jegesmedve álltal
     * @return Az üzenet
     */
    public abstract String BearDeathMSG();

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfagy
     * @return Az üzenet
     */
    public abstract String ColdDeathMSG();

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfulladt
     * @return Az üzenet
     */
    public abstract String DrownDeathMSG();

    /**
     * Üzenet arra az esetre ha a játékosok nyernek
     * @return Az üzenet
     */
    public abstract String WinMSG();
    public abstract String ResearchMSG();

    public abstract String Inventory();

    /**
     * A játékos nevének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    public abstract String PlayerName();

    /**
     * A játékos életerejének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    public abstract String PlayerHP();

    /**
     * A játékos akciópontjainak kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    public abstract String PlayerAP();

    /**
     * Egy kör kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    public abstract String Round();

    /**
     * Egy játékos kör átugrásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String ActionPass();

    /**
     * Egy játékos mozgásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String ActionMove();

    /**
     * Egy játékos ásásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String ActionDig();

    /**
     * Egy játékos balra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String ActionTurnLeft();

    /**
     * Egy játékos jobbra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String ActionTurnRight();

    /**
     * Egy játékos speciális képességéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String ActionSpecial();

    /**
     * Egy játékos tárgyfelvételéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String ActionPickup();

    /**
     * Egy játékos kimentésekor megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract String RescueQuestion();

    /**
     * A kilépés gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    public abstract  String MenuExit();

    /**
     * A start gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    public abstract  String MenuStart();

    /**
     * A játékosok számához tartozó szöveg
     * @return A megjelenő szöveg
     */
    public abstract  String MenuPlayerCount();

    /**
     * A pálya választási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    public abstract  String MenuSelectedMap();

    /**
     * A nyelv kiválasztási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    public abstract  String MenuChangeLang();

    /**
     * A játékosok száma után megjelenő szöveg
     * @return A megjelenő szöveg
     */
    public abstract  String Players();
}
