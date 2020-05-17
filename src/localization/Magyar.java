package localization;

/**
 * Magyar nyelvi csomag.
 */
public class Magyar extends Language {

    /**
     * Lehetséges magyar eszkimó nevek.
     */
    private String[] naEskimo = new String[] {
            "Jég Aladár",
            "Rozmár Béla",
            "Havasi Csaba",
            "Pingvin Dávid",
            "Bálnazsír Ernő",
            "Lék Ferenc"
    };

    /**
     * Lehetséges magyar kutató nevek.
     */
    private String[] naExplorer = new String[] {
            "Dr. Jégkaparó Richárd",
            "Dr. Fagyálló Feri",
            "Dr. Mischlen",
            "Dr. Wernher von Braun",
            "Доктор Андраш Kрасный",
            "Dr. Balage Goldschmidt"
    };

    /**
     * A hóvihar szövegát adja meg
     * @return a hóvihar szövege
     */
    @Override
    public String BlizzardShort() {
        return "Hóvihar";
    }

    /**
     * A hóvihar szövegát adja meg, hosszabban
     * @return a hóvihar szövege, hosszabban
     */
    @Override
    public String BlizzardLong() {
        return "Hóvihar sújtotta a jégmezőt!";
    }

    /**
     * Az eszkimó nevekből adja meg a kiválasztottat
     * @param c a kivásztott eszkimó indexe
     * @return a kiválaszott név
     */
    @Override
    public String EskimoName(int c) {
        return naEskimo[c];
    }

    /**
     * A sarkkutató nevekből adja meg a kiválasztottat
     * @param c a kivásztott sarkkutató indexe
     * @return a kiválaszott név
     */
    @Override
    public String ExplorerName(int c) {
        return naExplorer[c];
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal egy
     * jegesmedve álltal
     * @return Az üzenet
     */
    @Override
    public String BearDeathMSG() {
        return "Széttépett egy jegesmedve.";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfagy
     * @return Az üzenet
     */
    @Override
    public String ColdDeathMSG() {
        return "Halálra fagytál egy hóviharban.";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfulladt
     * @return Az üzenet
     */
    @Override
    public String DrownDeathMSG() {
        return "Vízbefulltál.";
    }

    /**
     * Üzenet arra az esetre ha a játékosok nyernek
     * @return Az üzenet
     */
    @Override
    public String WinMSG() {
        return "Sikeresen megmenekültetek!";
    }

    /**
     * Üzenet arra az esetre ha a sarkkutató használja
     * a speciális képességét
     * @return Az üzenet
     */
    @Override
    public String ResearchMSG() {
        return "Kutatás eredménye";
    }

    /**
     * Az Inventory neve
     * @return Az Inventory neve
     */
    @Override
    public String Inventory() {
        return "Táska";
    }

    /**
     * A játékos nevének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerName() {
        return "Név: ";
    }

    /**
     * A játékos életerejének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerHP() {
        return "Életerőpont: ";
    }

    /**
     * A játékos akciópontjainak kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerAP() {
        return "Akciópont: ";
    }

    /**
     * Egy kör kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String Round() {
        return "Kör: ";
    }

    /**
     * Egy játékos kör átugrásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPass() {
        return "Passz";
    }

    /**
     * Egy játékos mozgásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionMove() {
        return "Mozgás";
    }

    /**
     * Egy játékos ásásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionDig() {
        return "Ásás";
    }

    /**
     * Egy játékos balra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnLeft() {
        return "Balra";
    }

    /**
     * Egy játékos jobbra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnRight() {
        return "Jobbra";
    }

    /**
     * Egy játékos speciális képességéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionSpecial() {
        return "Speciális";
    }

    /**
     * Egy játékos tárgyfelvételéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPickup() {
        return "Felvesz";
    }

    /**
     * Egy játékos kimentésekor megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String RescueQuestion() {
        return "Kit mentesz ki?";
    }

    /**
     * A kilépés gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuExit() {
        return "Kilépés";
    }

    /**
     * A start gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuStart() {
        return "Indítás";
    }

    /**
     * A játékosok számához tartozó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuPlayerCount() {
        return "Játékosok száma";
    }

    /**
     * A pálya választási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuSelectedMap() {
        return "Kiválasztott pálya";
    }

    /**
     * A nyelv kiválasztási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuChangeLang() {
        return "Nyelv megváltoztatása";
    }

    /**
     * A játékosok száma után megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String Players() {
        return "játékos";
    }
}
