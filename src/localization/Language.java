package localization;

/**
 * Egy nyelv ős absztrakt osztálya
 */
public abstract class Language {
    /**
     * Megadja a kiválasztott nyelvet.
     * @return  a kiválasztott nyelv
     */
    public static Languages GetSelected() {
        return sel;
    }

    /**
     * A lehetséges nyelveket tartolmazó enum.
     */
    public enum Languages {English, Magyar, Русский, Română }

    /**
     * A kiválaszott nyelv
     */
    private static Languages sel;

    /**
     * A megadott nyelv, alapértelmezetten Magyar
     */
    private static Language lang = new Magyar();

    /**
     * Beállítja a megjelenítendő nyelvet a kiválaszott érték
     * alapján
     * @param lang a kiválasztott nyelv
     */
    static public void Initialise(Languages lang) {
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
     * A kiválaszott nyelv példányát adja meg
     * @return kiválaszott nyelv
     */
    static public Language Instance() {
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

    public abstract String BearDeathMSG();
    public abstract String ColdDeathMSG();
    public abstract String DrownDeathMSG();
    public abstract String WinMSG();
    public abstract String ResearchMSG();

    public abstract String Inventory();
    public abstract String PlayerName();
    public abstract String PlayerHP();
    public abstract String PlayerAP();
    public abstract String Round();

    public abstract String ActionPass();
    public abstract String ActionMove();
    public abstract String ActionDig();
    public abstract String ActionTurnLeft();
    public abstract String ActionTurnRight();
    public abstract String ActionSpecial();
    public abstract String ActionPickup();

    public abstract String RescueQuestion();

    public abstract  String MenuExit();
    public abstract  String MenuStart();
    public abstract  String MenuPlayerCount();
    public abstract  String MenuSelectedMap();
    public abstract  String MenuSchangeLang();

    public abstract  String Players();
}
